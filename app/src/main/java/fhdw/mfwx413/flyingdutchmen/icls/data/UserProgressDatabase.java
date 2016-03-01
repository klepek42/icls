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

        // converting the List<String[]> into a UserProgressCollection
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

    // Give all user progresses filtered by userName
    public static UserProgressCollection getSpecificUserProgresses(Context context, String chosenUser) {

        UserProgressCollection UserProgresses;
        UserProgresses = new UserProgressCollection();
        List<String[]> StringCollectionFromCSV;
        StringCollectionFromCSV = csvImport.importProgressCsv(context);

        // converting the List<String[]> into a UserProgressCollection
        for (int i = 0; i < StringCollectionFromCSV.size(); i++) {
            if (StringCollectionFromCSV.get(i)[0] == chosenUser) {
                UserProgresses.addUserProgress(
                        new UserProgress(
                                StringCollectionFromCSV.get(i)[0], //UserName
                                Integer.parseInt(StringCollectionFromCSV.get(i)[1]), //ChallengeID
                                Integer.parseInt(StringCollectionFromCSV.get(i)[2]), //Zeitklasse
                                StringCollectionFromCSV.get(i)[3] //TimeStampBeantwortung
                        )
                );
            }
        }
        return UserProgresses;
    }

    // Give all user progresses filtered by userName and periodClass
    public static UserProgressCollection getSpecificUserAndClassProgresses(Context context, String chosenUser, String periodClass) {

        UserProgressCollection UserProgresses;
        UserProgresses = new UserProgressCollection();
        List<String[]> StringCollectionFromCSV;
        StringCollectionFromCSV = csvImport.importProgressCsv(context);

        // converting the List<String[]> into a UserProgressCollection
        for (int i = 0; i < StringCollectionFromCSV.size(); i++) {
            if (StringCollectionFromCSV.get(i)[0] == chosenUser && StringCollectionFromCSV.get(i)[2] == periodClass) {
                UserProgresses.addUserProgress(
                        new UserProgress(
                                StringCollectionFromCSV.get(i)[0], //UserName
                                Integer.parseInt(StringCollectionFromCSV.get(i)[1]), //ChallengeID
                                Integer.parseInt(StringCollectionFromCSV.get(i)[2]), //Zeitklasse
                                StringCollectionFromCSV.get(i)[3] //TimeStampBeantwortung
                        )
                );
            }
        }
        return UserProgresses;
    }


    // Give all user progresses filtered by userName, periodClass and index
    public static UserProgressCollection getSpecificUserClassAndIndexProgresses(Context context, String chosenUser, String periodClass, String chosenFile) {

        UserProgressCollection UserProgresses;
        UserProgresses = new UserProgressCollection();
        List<String[]> StringCollectionFromCSV;
        StringCollectionFromCSV = csvImport.importProgressCsv(context);

        // converting the List<String[]> into a UserProgressCollection
        for (int i = 0; i < StringCollectionFromCSV.size(); i++) {
            if (StringCollectionFromCSV.get(i)[0] == chosenUser && StringCollectionFromCSV.get(i)[2] == periodClass) {
                /*if(StringCollectionFromCSV.get(i)[1] == ) {

                }*/
                UserProgresses.addUserProgress(
                        new UserProgress(
                                StringCollectionFromCSV.get(i)[0], //UserName
                                Integer.parseInt(StringCollectionFromCSV.get(i)[1]), //ChallengeID
                                Integer.parseInt(StringCollectionFromCSV.get(i)[2]), //Zeitklasse
                                StringCollectionFromCSV.get(i)[3] //TimeStampBeantwortung
                        )
                );
            }
        }
        return UserProgresses;
    }

    //write all UserProgresses to csv-file
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

    //write all UserProgresses to csv-file
    public static void writeSpecificUserProgresses(UserProgressCollection userProgressCollection, String userName, Context context){
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
            csvExport.saveUserProgressToCsv(userProgressList, userName, context);
        }
        catch (IOException e){
            Log.e("ICLS-ERROR", "UserProgressDatabase::writeAllUserProgresses::saveUserToCsv(): ", e);
        }

    }

}