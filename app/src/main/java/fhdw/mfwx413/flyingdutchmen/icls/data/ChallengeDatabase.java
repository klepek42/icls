package fhdw.mfwx413.flyingdutchmen.icls.data;

import android.util.Log;
import java.util.List;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.csvImport;

/**
 * Responsibility Jonas Krabs
 * */
public class ChallengeDatabase {

    //the challengeDatabase is based on an already imported list of indexCards
    @SuppressWarnings("FieldCanBeLocal")
    private static IndexCardCollection allIndexCards;

    //get all challenges from csv
    public static ChallengeCollection getAllChallenges(){

        //import all indexCards
        allIndexCards = IndexCardDatabase.getIndexCards();

        ChallengeCollection allChallenges;
        allChallenges = new ChallengeCollection();

        List<String[]> StringCollectionFromCSV;

        // reading all Challenges from csv-File
        // output ist a List<String[]>
        StringCollectionFromCSV = csvImport.importChallengeCsv();

        // convert the List<String[]> into a ChallengeCollection
        for (int i = 0; i < StringCollectionFromCSV.size(); i++) {
            try {
                allChallenges.addChallenge(
                        new Challenge(
                                Integer.parseInt(StringCollectionFromCSV.get(i)[0]),
                                StringCollectionFromCSV.get(i)[1],
                                StringCollectionFromCSV.get(i)[2],
                                StringCollectionFromCSV.get(i)[3],
                                StringCollectionFromCSV.get(i)[4],
                                Integer.parseInt(StringCollectionFromCSV.get(i)[5]),
                                Integer.parseInt(StringCollectionFromCSV.get(i)[6]),
                                allIndexCards.getIndexCardByKey(Integer.parseInt(StringCollectionFromCSV.get(i)[7]))));
            }
            catch (IdNotFoundException e){
                Log.e("ICLS-ERROR", "ChallengeDatabase::getAllChallenges: ", e);
            }
        }

        return allChallenges;
    }

}
