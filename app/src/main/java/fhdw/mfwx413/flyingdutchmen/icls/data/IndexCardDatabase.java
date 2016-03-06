package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.util.List;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.csvImport;

/**
 * Responsibility Jonas Krabs
 * */

public class IndexCardDatabase {

    //get all IndexCards from csv
    public static IndexCardCollection getIndexCards() {

        IndexCardCollection allIndexCards;
        allIndexCards = new IndexCardCollection();

        List<String[]> StringCollectionFromCSV;

        // reading all IndexCards from csv-File
        // output is a List<String[]>
        StringCollectionFromCSV = csvImport.importIndexCsv();

        //converting the List<String[]> into a IndexCardCollection
        for (int i = 0; i < StringCollectionFromCSV.size(); i++) {
            allIndexCards.addIndexCard(new IndexCard(Integer.parseInt(StringCollectionFromCSV.get(i)[0]), StringCollectionFromCSV.get(i)[1]));
        }

        return allIndexCards;
    }

}
