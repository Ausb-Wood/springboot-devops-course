package de.kurs.devops;

/**
 * Datenobjekt fuer die JSON-Antwort der API.
 */
public record ReadingResponse(String meterNumber, int oldCounter, int newCounter, int difference) {
}
