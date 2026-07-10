# Mehrstufiges Dockerfile:
# 1. Build-Stage: Maven baut das JAR.
# 2. Runtime-Stage: Nur Java Runtime + fertiges JAR werden ausgefuehrt.

FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Erst pom.xml kopieren, damit Docker Maven-Abhaengigkeiten besser cachen kann.
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Danach Quellcode kopieren und JAR bauen.
COPY src ./src
RUN mvn -B clean package

FROM eclipse-temurin:21-jre
WORKDIR /app

# wget wird nur fuer den Docker-Healthcheck genutzt.
RUN apt-get update \
    && apt-get install -y --no-install-recommends wget \
    && rm -rf /var/lib/apt/lists/*

# Fuer Sicherheit im Kurs: App laeuft nicht als root.
RUN useradd -r -u 10001 appuser
COPY --from=build /app/target/*.jar app.jar
USER appuser

EXPOSE 8080

# Healthcheck prueft, ob der Spring Boot Actuator erreichbar ist.
HEALTHCHECK --interval=30s --timeout=5s --retries=3 CMD \
  wget -qO- http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
