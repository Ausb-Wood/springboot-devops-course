# Optionale GHCR-Anleitung

GHCR steht fuer GitHub Container Registry. Dort kann die Pipeline Docker-Images speichern.

## Wann nutzen?

Nur wenn die Gruppe Git, Docker und GitHub Actions bereits sicher beherrscht.
Fuer den 10-Tage-Kurs ist GHCR optional.

## Aktivieren

```bash
mv .github/workflows/ci-ghcr.yml.disabled .github/workflows/ci-ghcr.yml
git add .github/workflows/ci-ghcr.yml
git commit -m "ci: publish image to ghcr"
git push
```

## In GitHub pruefen

- Repository -> Actions -> Workflow erfolgreich?
- Repository/Owner -> Packages -> Container sichtbar?
- Package auf public stellen, wenn kein Login in der VM gewuenscht ist.

## Auf der Linux-VM deployen

```bash
export IMAGE_NAME=ghcr.io/MEIN-USER/springboot-devops-course:latest
bash scripts/deploy_ghcr.sh
```

## Privates Image

Bei privatem Image ist ein Personal Access Token mit `read:packages` noetig.

```bash
echo "TOKEN" | docker login ghcr.io -u GITHUB_USERNAME --password-stdin
```
