package de.kurs.devops;

/**
 * Datenobjekt fuer eingehende JSON-Requests.
 *
 * Beispiel:
 * {
 *   "meterNumber": "M-100",
 *   "oldCounter": 100,
 *   "newCounter": 135
 * }
 */
public record ReadingRequest(String meterNumber, int oldCounter, int newCounter) {
}
