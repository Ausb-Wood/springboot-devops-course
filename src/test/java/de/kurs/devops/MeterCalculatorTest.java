package de.kurs.devops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit-Tests fuer die Fachlogik.
 *
 * Wichtig fuer den Kurs:
 * - Tests laufen lokal in der Linux-VM.
 * - Tests laufen spaeter automatisch in GitHub Actions.
 * - Bei einem Fehler stoppt die Pipeline.
 */
class MeterCalculatorTest {

    @Test
    void calculatesPositiveDifference() {
        assertEquals(35, MeterCalculator.calculateDifference(100, 135));
    }

    @Test
    void equalCountersAreValid() {
        assertEquals(0, MeterCalculator.calculateDifference(120, 120));
    }

    @Test
    void newCounterSmallerThanOldCounterIsInvalid() {
        assertEquals(-1, MeterCalculator.calculateDifference(200, 150));
    }

    @Test
    void negativeOldCounterIsInvalid() {
        assertEquals(-1, MeterCalculator.calculateDifference(-1, 20));
    }

    @Test
    void negativeNewCounterIsInvalid() {
        assertEquals(-1, MeterCalculator.calculateDifference(1, -20));
    }
}
