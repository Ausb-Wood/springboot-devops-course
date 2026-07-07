# Spring Boot DevOps Kursprojekt

Dieses Repository ist Teil eines 10-tägigen DevOps- und Deployment-Kurses für Umschülerinnen und Umschüler.

Ziel des Projekts ist es, eine einfache Spring-Boot-Anwendung in einer Linux-VM zu entwickeln, mit Git und GitHub zu versionieren, über Pull Requests zu bearbeiten, mit GitHub Actions automatisch zu testen und anschließend mit Docker auf der Linux-VM bereitzustellen.

---

## 1. Ziel des Projekts

Am Ende dieses Projekts sollen die Teilnehmenden verstanden haben:

- wie ein Spring-Boot-Projekt aufgebaut ist,
- wie man mit Git arbeitet,
- wie man Änderungen über Branches und Pull Requests einreicht,
- wie eine GitHub-Actions-Pipeline funktioniert,
- wie Maven eine Java-Anwendung baut und testet,
- wie aus der Anwendung ein Docker-Image entsteht,
- wie die Anwendung mit Docker Compose gestartet wird,
- wie man Logs und Healthchecks zur Fehleranalyse verwendet.

---

## 2. DevOps-Ablauf im Kurs

Der Ablauf im Kurs sieht so aus:

```text
Linux-VM
  ↓
Code ändern
  ↓
lokal testen
  ↓
git add / git commit
  ↓
git push
  ↓
Pull Request in GitHub erstellen
  ↓
GitHub Actions Pipeline läuft automatisch
  ↓
Tests und Build werden geprüft
  ↓
Pull Request wird gemerged
  ↓
Linux-VM aktualisiert den Code mit git pull
  ↓
Docker baut und startet die neue Version

---

## 3. Kubernetes-Einstieg mit minikube

Am Ende des Kurses kann die Anwendung optional auch mit Kubernetes gestartet werden.

Wichtig:

```text
Docker Compose ist der Pflichtteil des Kurses.
minikube und Kubernetes sind ein Einstieg am Kursende.
