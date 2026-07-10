#!/usr/bin/env bash
set -euo pipefail

# Hilfsskript fuer Fehleranalyse.
docker compose ps
docker compose logs --tail=120 springboot-app
