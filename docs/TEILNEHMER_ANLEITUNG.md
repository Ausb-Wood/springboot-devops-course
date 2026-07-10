# Teilnehmeranleitung: Von Git bis Deployment

## 1. Repository klonen

```bash
git clone https://github.com/ORG/springboot-devops-course.git
cd springboot-devops-course
```

## 2. Lokal testen

```bash
mvn -B test package
```

Bedeutung:
- `mvn` startet Maven.
- `test` fuehrt Unit- und Integrationstests aus.
- `package` baut das ausfuehrbare JAR.

## 3. App lokal starten

```bash
mvn spring-boot:run
```

Im zweiten Terminal:

```bash
curl http://localhost:8080/actuator/health
curl "http://localhost:8080/api/difference?oldCounter=100&newCounter=135"
```

## 4. Docker-Container starten

```bash
docker compose up -d --build
docker compose ps
curl http://localhost:8080/actuator/health
```

## 5. Eigene Aenderung im Feature-Branch

```bash
git checkout -b feature/meine-aenderung
# Code bearbeiten
git status
git add .
git commit -m "feat: kleine API-Aenderung"
git push -u origin feature/meine-aenderung
```

## 6. Pull Request in GitHub

- GitHub oeffnen.
- "Compare & pull request" anklicken.
- Beschreiben: Was wurde geaendert? Wie wurde getestet?
- Auf GitHub Actions warten.

## 7. Nach Merge: neue Version bereitstellen

```bash
git checkout main
git pull --ff-only
bash scripts/deploy_local_build.sh
```

## 8. Fehleranalyse

```bash
docker compose ps
docker compose logs --tail=100 springboot-app
curl -i http://localhost:8080/actuator/health
```
