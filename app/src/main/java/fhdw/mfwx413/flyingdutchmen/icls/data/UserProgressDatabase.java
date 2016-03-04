package fhdw.mfwx413.flyingdutchmen.icls.data;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.csvExport;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.csvImport;

/**
 * Created by Daniel on 23.02.2016.
 * Responsibility: Daniel zur Linden
 */
public class UserProgressDatabase {

    public static UserProgressCollection getAllUserProgresses(Context context) {

        UserProgressCollection UserProgresses;
        UserProgresses = new UserProgressCollection();
        List<String[]> StringCollectionFromCSV;
        StringCollectionFromCSV = csvImport.importProgressCsv(context);

        // Converting the List<String[]> into a UserProgressCollection
        for (int i = 0; i < StringCollectionFromCSV.size(); i++) {
            UserProgresses.addUserProgress(
                    new UserProgress(
                            StringCollectionFromCSV.get(i)[0], //UserName
                            Integer.parseInt(StringCollectionFromCSV.get(i)[1]), //ChallengeID
                            Integer.parseInt(StringCollectionFromCSV.get(i)[2]), //Zeitklasse
                            StringCollectionFromCSV.get(i)[3] //TimeStampBeantwortung
                    )
            );
        }
        return UserProgresses;
    }

    public static UserProgressCollection getUserProgresses(Context context, String userName) {

        UserProgressCollection UserProgresses;
        UserProgresses = new UserProgressCollection();
        List<String[]> StringCollectionFromCSV;
        StringCollectionFromCSV = csvImport.importUserProgressCsv(context, userName);

        // Converting the List<String[]> into a UserProgressCollection
        for (int i = 0; i < StringCollectionFromCSV.size(); i++) {
            UserProgresses.addUserProgress(
                    new UserProgress(
                            StringCollectionFromCSV.get(i)[0], //UserName
                            Integer.parseInt(StringCollectionFromCSV.get(i)[1]), //ChallengeID
                            Integer.parseInt(StringCollectionFromCSV.get(i)[2]), //Zeitklasse
                            StringCollectionFromCSV.get(i)[3] //TimeStampBeantwortung
                    )
            );
        }
        return UserProgresses;
    }

    // Write all UserProgresses to csv-file
    // DIESE FUNKTION IST VERALTET UND SOLLTE NICHT MEHR VERWENDET WERDEN, BITTE UMSTEIGEN AUF DIE DADRUNTER
    /*
    public static void writeAllUserProgresses(UserProgressCollection userProgressCollection){
        List<String[]> userProgressList = new ArrayList<String[]>();

        try {
            // UserProgressCollection >>> List<String[]>
            for(int i = 0; i < userProgressCollection.getSize(); i++) { // ArrayList with Progress objects
                //convert a progress object into a String array (necessary for writing ist into csv)
                String [] userProgressAsString = new String[4];
                UserProgress userProgress = userProgressCollection.getUserProgress(i);

                userProgressAsString[0] = userProgress.getmUserName();
                userProgressAsString[1] = Integer.toString(userProgress.getmChallengeID());
                userProgressAsString[2] = Integer.toString(userProgress.getmPeriodClass());
                userProgressAsString[3] = userProgress.getmTimeStampAnswered();

                userProgressList.add(i, userProgressAsString);
            }
            csvExport.saveProgressToCsv(userProgressList);
        }
        catch (IOException e){
            Log.e("ICLS-ERROR", "UserProgressDatabase::writeAllUserProgresses::saveUserToCsv(): ", e);
        }

    }
    */

    // Write all UserProgresses to csv-file
    public static void writeSpecificUserProgresses(UserProgressCollection userProgressCollection, String userName, Context context){
        List<String[]> userProgressList = new ArrayList<String[]>();

        try {
            // UserProgressCollection >>> List<String[]>
            for(int i = 0; i < userProgressCollection.getSize(); i++) { // ArrayList with Progress objects
                // Convert a progress object into a String array (necessary for writing ist into csv)
                String [] userProgressAsString = new String[4];
                UserProgress userProgress = userProgressCollection.getUserProgress(i);

                userProgressAsString[0] = userProgress.getmUserName();
                userProgressAsString[1] = Integer.toString(userProgress.getmChallengeID());
                userProgressAsString[2] = Integer.toString(userProgress.getmPeriodClass());
                userProgressAsString[3] = userProgress.getmTimeStampAnswered();

                userProgressList.add(i, userProgressAsString);
            }
            csvExport.saveUserProgressToCsv(userProgressList, userName, context);
        }
        catch (IOException e){
            Log.e("ICLS-ERROR", "UserProgressDatabase::writeAllUserProgresses::saveUserToCsv(): ", e);
        }
    }

}