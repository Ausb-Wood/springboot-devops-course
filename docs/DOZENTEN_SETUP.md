# Dozenten-Setup fuer den Kurs

## Kursentscheidung

Fuer Umschueler in 10 Tagen ist die Kernvariante ohne GHCR empfohlen.
Die Linux-VM baut den Docker-Container lokal nach dem Git-Pull. Dadurch verstehen die Teilnehmenden Git, Build, Docker und Deployment, ohne zusaetzlich Registry-Rechte, Tokens und Package-Sichtbarkeit zu verwalten.

GHCR wird als optionale Praxisstufe eingefuehrt:
- Dozenten-Demo oder schnelle Gruppen am Ende.
- Nicht als Pflicht fuer alle.

## Vorbereitung

1. GitHub-Organisation oder Template-Repository vorbereiten.
2. VM-Image mit Ubuntu Server, Git, OpenJDK 21, Maven und Docker vorbereiten.
3. Docker-Images vorab ziehen, falls Internet instabil ist.
4. Moodle-Kurs mit Tagesabschnitten anlegen.
5. Poster und PDF-Handbuch hochladen.

## Mindesttests vor Kursstart

```bash
git --version
java -version
mvn --version
docker --version
docker compose version
```

Projekt pruefen:

```bash
mvn -B test package
docker compose up -d --build
curl http://localhost:8080/actuator/health
bash scripts/deploy_local_build.sh
docker compose down
```
