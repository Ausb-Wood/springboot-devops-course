# Spring Boot DevOps Course

Dieses Repository ist eine einfache Kursanwendung fuer Umschuelerinnen und Umschueler.
Sie wird in einer Linux-VM bearbeitet, nach GitHub gepusht, in GitHub Actions getestet und
anschliessend als Docker-Container auf der Linux-VM bereitgestellt.

## Kernvariante fuer 10 Tage

Die Kernvariante nutzt **keine Container Registry**. Das ist bewusst einfacher:

1. In der Linux-VM entwickeln.
2. Aenderung in Feature-Branch committen.
3. Pull Request in GitHub erstellen.
4. GitHub Actions testet und baut.
5. Nach Merge in `main`: in der Linux-VM `git pull` und `docker compose up -d --build`.

## Optional: GHCR

GitHub Container Registry ist realistisch, aber fuer Anfaenger zusaetzlich komplex.
Die Datei `.github/workflows/ci-ghcr.yml.disabled` kann als Dozenten-Demo genutzt werden.

## Lokaler Start

```bash
mvn -B test package
mvn spring-boot:run
curl http://localhost:8080/actuator/health
```

## Docker-Start

```bash
docker compose up -d --build
docker compose ps
curl http://localhost:8080/actuator/health
```

## Deployment-Automatisierung

```bash
bash scripts/deploy_local_build.sh
```

## API testen

```bash
curl "http://localhost:8080/api/difference?oldCounter=100&newCounter=135"

curl -X POST http://localhost:8080/api/readings \
  -H "Content-Type: application/json" \
  -d '{"meterNumber":"M-100","oldCounter":100,"newCounter":135}'
```
