#!/usr/bin/env bash
set -euo pipefail

# Raeumt Container auf, ohne Quellcode zu loeschen.
docker compose down --remove-orphans
