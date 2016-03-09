package fhdw.mfwx413.flyingdutchmen.icls.data;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import fhdw.mfwx413.flyingdutchmen.icls.utilities.csvExport;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.csvImport;

/**
 * Responsibility: Daniel zur Linden
 */
public class UserProgressDatabase {

    public static UserProgressCollection getUserProgresses(Context context, String userName) {

        //the challengeDatabase is based on an already imported list of UserPro
        UserProgressCollection userProgresses;

        //create a UserProgressCollection
        userProgresses = new UserProgressCollection();

        //create a List<String[]> and put in the UserProgresses from csv-file
        List<String[]> stringCollectionFromCSV;
        stringCollectionFromCSV = csvImport.importUserProgressCsv(context, userName);

        //convert the List<String[]> into a UserProgressCollection
        for (int i = 0; i < stringCollectionFromCSV.size(); i++) {
                userProgresses.addUserProgress(
                        new UserProgress(
                                stringCollectionFromCSV.get(i)[0], //UserName
                                Integer.parseInt(stringCollectionFromCSV.get(i)[1]), //ChallengeID
                                Integer.parseInt(stringCollectionFromCSV.get(i)[2]), //PeriodClass
                                stringCollectionFromCSV.get(i)[3] //TimeStampAnswered
                        )
                );
            }
        return userProgresses;
    }

    //write all UserProgresses to csv-file
    public static void writeSpecificUserProgresses(UserProgressCollection userProgressCollection, String userName, Context context) {
        //create a List<String[]> to list all userProgresses
        List<String[]> userProgressList = new ArrayList<String[]>();

        try {
            //go through the UserProgressCollection and fill in the list of all userProgresses with String-Arrays
            for (int i = 0; i < userProgressCollection.getSize(); i++) {

                //Convert a progress object into a String array (necessary for writing ist into csv)
                String[] userProgressAsString = new String[4];
                UserProgress userProgress = userProgressCollection.getUserProgress(i);

                userProgressAsString[0] = userProgress.getmUserName();
                userProgressAsString[1] = Integer.toString(userProgress.getmChallengeID());
                userProgressAsString[2] = Integer.toString(userProgress.getmPeriodClass());
                userProgressAsString[3] = userProgress.getmTimeStampAnswered();

                userProgressList.add(i, userProgressAsString);
            }
            csvExport.saveUserProgressToCsv(userProgressList, userName, context);
        } catch (IOException e) {
            Log.e("ICLS-ERROR", "UserProgressDatabase::writeSpecificUserProgress::saveUserProgressToCsv(): ", e);
        }
    }

}