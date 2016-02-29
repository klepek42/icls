package fhdw.mfwx413.flyingdutchmen.icls.utilities;

import android.content.Context;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by edgar on 21.02.2016.
 * Responsibility: Edgar Klepek
 */
public class csvImport {

    private static Context context;

    // Import the users from users.csv and return the resulting ArrayList
    public static List<String[]> importUserCsv(Context context) {

        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(context.getAssets().open("users.csv"));

            CSVReader reader = new CSVReader(csvStreamReader);
            // Fill the temporary list with the lines read from the csv file
            for (;;) {
                next = reader.readNext();
                if (next != null) {
                    list.add(next);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /* UNNOETIG WEIL ALLES SOWIESO AUS KOMPLETTEM USER GELESEN WIRD
    // Import the user specific setting from users.csv and return the resulting ArrayList
    public static List<String[]> importSettingsFromUserCsv(Context context) {

        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(context.getAssets().open("users.csv"));

            CSVReader reader = new CSVReader(csvStreamReader);
            // Fill the temporary list with the lines read from the csv file
            for (;;) {
                next = reader.readNext();
                if (next != null) {
                    list.add(next);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    */


    // Import the index.csv and return the results as list
    public static List<String[]> importIndexCsv(Context context) {

        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(context.getAssets().open("index.csv"));

            CSVReader reader = new CSVReader(csvStreamReader);
            // Fill the list with the lines read from the csv file
            for (;;) {
                next = reader.readNext();
                if (next != null) {
                    list.add(next);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Import all challenges from challenges.csv and return the resulting list
    public static List<String[]> importAllChallengesCsv(Context context) {

        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(context.getAssets().open("challenges.csv"));

            CSVReader reader = new CSVReader(csvStreamReader, ';');
            // Fill the temporary list with the lines read from the csv file
            for (;;) {
                next = reader.readNext();
                if (next != null) {
                    list.add(next);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

/*  UNNOETIG WEIL EINFACH ALLE CHALLENGES GENOMMEN WERDEN UND WOANDERS GEFILTERT WIRD
    // Import all challenges from a specific index from challenges.csv and return the resulting ArrayList
    public static ArrayList<String> importChallengesFromFileCsv(Context context, int fileId) {

        ArrayList<String> challengeList = new ArrayList<String>();

        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(context.getAssets().open("challenges.csv"));

            CSVReader reader = new CSVReader(csvStreamReader);
            // Fill the temporary list with the lines read from the csv file
            for (;;) {
                next = reader.readNext();
                if (next != null) {
                    list.add(next);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Go through the list and add only the users to it
        for (int i = 1; i < list.size(); i++) {
            challengeList.add(list.get(i)[0]);
        }
        return challengeList;
    }
*/

    // Import progress data from progress.csv and return the resulting ArrayList
    public static  List<String[]> importProgressCsv(Context context) {

        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(context.getAssets().open("progress.csv"));

            CSVReader reader = new CSVReader(csvStreamReader);
            // Fill the temporary list with the lines read from the csv file
            for (;;) {
                next = reader.readNext();
                if (next != null) {
                    list.add(next);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean checkICLSFile(){
        boolean allFilesExists = false;
        File fileProgresses = new File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/ICLS/UserProgresses");
        File fileChallenges = new File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/ICLS/challenges.csv");
        File fileUsers = new File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/ICLS/users.csv");
        File fileIndex = new File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/ICLS/index.csv");
        if (fileProgresses.exists() && fileChallenges.exists() && fileUsers.exists() && fileIndex.exists()) {
            allFilesExists = true;
        }
        return allFilesExists;
    }
}