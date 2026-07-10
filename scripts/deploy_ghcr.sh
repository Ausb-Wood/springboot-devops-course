#!/usr/bin/env bash
set -euo pipefail

# Optionale Praxisvariante mit GitHub Container Registry.
# Voraussetzung: IMAGE_NAME zeigt auf das GHCR-Image.
# Beispiel:
# export IMAGE_NAME=ghcr.io/MEIN-USER/springboot-devops-course:latest
# bash scripts/deploy_ghcr.sh

: "${IMAGE_NAME:?Bitte IMAGE_NAME setzen, z. B. ghcr.io/MEIN-USER/springboot-devops-course:latest}"

export IMAGE_NAME

echo "[1/4] Image aus GHCR ziehen: $IMAGE_NAME"
docker compose -f docker-compose.ghcr.yml pull

echo "[2/4] Container neu starten"
docker compose -f docker-compose.ghcr.yml up -d

echo "[3/4] Status pruefen"
docker compose -f docker-compose.ghcr.yml ps

echo "[4/4] Healthcheck pruefen"
curl -fsS http://localhost:8080/actuator/health && echo
