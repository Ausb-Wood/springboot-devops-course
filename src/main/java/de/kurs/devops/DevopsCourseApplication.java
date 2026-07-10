package de.kurs.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Einstiegspunkt der Spring-Boot-Anwendung.
 *
 * SpringApplication.run(...) startet den eingebetteten Webserver.
 * Danach sind die REST-Endpunkte im Browser oder mit curl erreichbar.
 */
@SpringBootApplication
public class DevopsCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevopsCourseApplication.class, args);
    }
}
