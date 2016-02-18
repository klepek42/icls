package fhdw.mfwx413.flyingdutchmen.icls.data;

/**
 * Created by Krabs on 18.02.2016.
 * das ist eine testklasse... ich kann noch nicht absehen, ob wir sie wirklich brauchen
 * solange das einlesen aus den csv-Dateien noch nicht realisiert ist, ist sie aber auf jeden Fall
 * notwendig
 * Im Moment gehe ich aber stark davon aus, dass wir die Klasse brauchen werden
 */
public class IndexCardDatabase {

    public static IndexCardCollection getIndexCards() {

        IndexCardCollection allIndexCards;
        allIndexCards = new IndexCardCollection();

        allIndexCards.addIndexCard(
                new IndexCard(1, "Geographie")
        );

        allIndexCards.addIndexCard(
                new IndexCard(2, "Musik")
        );

        allIndexCards.addIndexCard(
                new IndexCard(3, "Sport")
        );

        return allIndexCards;
    }

}
