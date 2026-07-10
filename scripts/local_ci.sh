#!/usr/bin/env bash
set -euo pipefail

# Lokale CI: fuehrt die gleichen Grundschritte aus wie die Pipeline.
# Das ist der Plan B, wenn GitHub oder GitHub Actions nicht erreichbar sind.

echo "[1/4] Maven-Tests und JAR-Build"
mvn -B test package

echo "[2/4] Docker-Compose-Konfiguration pruefen"
docker compose config >/dev/null

echo "[3/4] Docker-Image lokal bauen"
docker build -t springboot-devops-course:local .

echo "[4/4] Fertig: lokale CI erfolgreich"
