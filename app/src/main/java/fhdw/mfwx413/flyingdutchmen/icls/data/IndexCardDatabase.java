package fhdw.mfwx413.flyingdutchmen.icls.data;

/**
 * Created by Krabs on 18.02.2016.
 * das ist eine testklasse... ich kann noch nicht absehen, ob wir sie wirklich brauchen
 * solange das einlesen aus den csv-Dateien noch nicht realisiert ist, ist sie aber auf jeden Fall
 * notwendig
 * Im Moment gehe ich aber stark davon aus, dass wir die Klasse brauchen werden
 * Auf diese weise wie hier die IndexCard angelegt werden müssen sie auch hinterher in der csv-Datei
 * hinterlegt sein: id, Bezeichnung
 */
public class IndexCardDatabase {

    //hier muss natürlich eigentlich die csv-Datei ausgelesen werden
    public static IndexCardCollection getIndexCards() {

        IndexCardCollection allIndexCards;
        allIndexCards = new IndexCardCollection();

        allIndexCards.addIndexCard(
                new IndexCard(1, "Geographie")
        );

        allIndexCards.addIndexCard(
                new IndexCard(2, "Mathematik")
        );

        allIndexCards.addIndexCard(
                new IndexCard(3, "Literatur/Deutsch")
        );

        allIndexCards.addIndexCard(
                new IndexCard(4, "Musik")
        );

        allIndexCards.addIndexCard(
                new IndexCard(5, "Biologie")
        );

        allIndexCards.addIndexCard(
                new IndexCard(6, "Sport")
        );

        return allIndexCards;
    }

}
