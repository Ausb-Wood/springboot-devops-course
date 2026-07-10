#!/usr/bin/env bash
set -euo pipefail

# Einfacher Deployment-Automat fuer den 10-Tage-Kurs.
# Einsatz: auf der Linux-VM im geklonten Repository ausfuehren.
# Ablauf: neuen Code holen, lokal testen, Container neu bauen und starten.

echo "[1/6] Aktuellen Stand aus GitHub holen"
git pull --ff-only

echo "[2/6] Tests und Build ausfuehren"
mvn -B test package

echo "[3/6] Alten Container ersetzen und neues Image bauen"
docker compose up -d --build

echo "[4/6] Containerstatus anzeigen"
docker compose ps

echo "[5/6] Healthcheck pruefen"
for i in {1..30}; do
  if curl -fsS http://localhost:8080/actuator/health >/dev/null; then
    echo "Healthcheck erfolgreich"
    break
  fi
  echo "Warte auf Anwendung... ($i/30)"
  sleep 2
  if [ "$i" = "30" ]; then
    echo "Healthcheck fehlgeschlagen. Logs folgen:"
    docker compose logs --tail=80 springboot-app
    exit 1
  fi
done

echo "[6/6] Deployment abgeschlossen"
curl -s http://localhost:8080/actuator/health && echo
