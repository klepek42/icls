package fhdw.mfwx413.flyingdutchmen.icls.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

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
    public static IndexCardCollection getIndexCards(Context context) {

        IndexCardCollection allIndexCards;
        allIndexCards = new IndexCardCollection();

        List<String[]> StringCollectionFromCSV;

        // reading all IndexCards from csv-File
        // output ist a List<String[]>
        StringCollectionFromCSV = csvImport.importIndexCsv(context);

        //converting the List<String[]> into a IndexCardCollection
        for (int i = 0; i < StringCollectionFromCSV.size(); i++) {
            allIndexCards.addIndexCard(new IndexCard(Integer.parseInt(StringCollectionFromCSV.get(i)[0]), StringCollectionFromCSV.get(i)[1]));
        }

        return allIndexCards;
    }

}
