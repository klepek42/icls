package fhdw.mfwx413.flyingdutchmen.icls.data;

import android.content.Context;

import java.util.List;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.csvImport;

/**
 * Responsibility Jonas Krabs
 * this class provides the Challenges in Form of a ChallengeCollection
 * It converts the Strings from the csv-File into the Java-Structure Challenge
 * */
public class ChallengeDatabase {

    //the challengeDatabase is based on an already imported list of indexCards
    private static IndexCardCollection allIndexCards;

    public static ChallengeCollection getAllChallenges(Context context){

        //import all indexCards
        allIndexCards = IndexCardDatabase.getIndexCards(context);

        ChallengeCollection allChallenges;
        allChallenges = new ChallengeCollection();

        List<String[]> StringCollectionFromCSV;

        // reading all Challenges from csv-File
        // output ist a List<String[]>
        StringCollectionFromCSV = csvImport.importAllChallengesCsv(context);

        // converting the List<String[]> into a ChallengeCollection
        for (int i = 0; i < StringCollectionFromCSV.size(); i++) {
            allChallenges.addChallenge(
                    new Challenge(
                            Integer.parseInt(StringCollectionFromCSV.get(i)[0]),
                            StringCollectionFromCSV.get(i) [1],
                            StringCollectionFromCSV.get(i) [2],
                            StringCollectionFromCSV.get(i) [3],
                            StringCollectionFromCSV.get(i) [4],
                            Integer.parseInt(StringCollectionFromCSV.get(i)[5]),
                            Integer.parseInt(StringCollectionFromCSV.get(i)[6]),
                            allIndexCards.getIndexCard(Integer.parseInt(StringCollectionFromCSV.get(i)[7]))));
        }

        return allChallenges;
    }

}
