package de.kurs.devops;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-Controller fuer den Kurs.
 *
 * Ein REST-Controller nimmt HTTP-Anfragen entgegen und gibt HTTP-Antworten
 * zurueck. Damit koennen die Teilnehmenden die App mit Browser oder curl testen.
 */
@RestController
public class ReadingController {

    @GetMapping("/")
    public Map<String, String> index() {
        return Map.of(
                "app", "springboot-devops-course",
                "message", "Nutze /api/difference oder /actuator/health"
        );
    }

    @GetMapping("/api/difference")
    public ReadingResponse difference(
            @RequestParam(defaultValue = "M-DEMO") String meterNumber,
            @RequestParam int oldCounter,
            @RequestParam int newCounter) {
        int difference = MeterCalculator.calculateDifference(oldCounter, newCounter);
        return new ReadingResponse(meterNumber, oldCounter, newCounter, difference);
    }

    @PostMapping("/api/readings")
    public ResponseEntity<ReadingResponse> createReading(@RequestBody ReadingRequest request) {
        int difference = MeterCalculator.calculateDifference(request.oldCounter(), request.newCounter());
        ReadingResponse response = new ReadingResponse(
                request.meterNumber(),
                request.oldCounter(),
                request.newCounter(),
                difference
        );

        // Ungueltige Fachwerte liefern HTTP 400. Das ist fuer Fehlertraining nuetzlich.
        if (difference < 0) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }
}
