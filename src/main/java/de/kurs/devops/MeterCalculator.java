package de.kurs.devops;

/**
 * Kleine Fachlogik fuer den Kurs.
 *
 * Die Methode berechnet die positive Differenz zwischen zwei Zaehlerstaenden.
 * Sie ist bewusst einfach gehalten, damit Unit-Tests und Fehleranalyse im Kurs
 * nachvollziehbar bleiben.
 */
public class MeterCalculator {

    private MeterCalculator() {
        // Utility-Klasse: Es werden keine Objekte dieser Klasse benoetigt.
    }

    public static int calculateDifference(int oldCounter, int newCounter) {
        // Negative Zaehlerstaende sind fachlich ungueltig.
        if (oldCounter < 0 || newCounter < 0) {
            return -1;
        }

        // Der neue Zaehlerstand darf nicht kleiner sein als der alte.
        if (oldCounter > newCounter) {
            return -1;
        }

        // Gueltiger Fall: Differenz bilden.
        return newCounter - oldCounter;
    }
}
