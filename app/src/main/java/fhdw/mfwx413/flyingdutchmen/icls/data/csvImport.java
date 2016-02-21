package fhdw.mfwx413.flyingdutchmen.icls.data;

import android.content.Context;

import com.opencsv.CSVReader;

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
    public static ArrayList<String> importUserCsv(Context context) {

        ArrayList<String> userList = new ArrayList<String>();

        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(context.getAssets().open("users.csv"));
            // Alternative Ordner zum Auslesen "raw" in res
            //InputStreamReader csvStreamReader = new InputStreamReader(context.getResources().openRawResource(R.raw.users));

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
        for (int i = 0; i < list.size(); i++) {
            userList.add(list.get(i)[0]);
        }

        return userList;
    }


    // Import the user specific setting from users.csv and return the resulting ArrayList
    public static ArrayList<String> importSettingsFromUserCsv(Context context, String userName) {

        ArrayList<String> userList = new ArrayList<String>();
        ArrayList<String> settingsList = new ArrayList<String>();

        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(context.getAssets().open("users.csv"));
            // Alternative Ordner zum Auslesen "raw" in res
            //InputStreamReader csvStreamReader = new InputStreamReader(context.getResources().openRawResource(R.raw.users));

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

        int x = 0;
        // Go through the list and get all users
        for (int i = 0; i < list.size(); i++) {
            userList.add(list.get(i)[0]);
        }

        // Get the row of chosen user
        for (int j = 0; j < list.size(); j++) {
            if(userList.get(j).contains(userName)) {
                x = j;
            }
        }

        // Go trough the list, collect all settings and save them in ArrayList
        for (int y = 0; y < list.size(); y++) {
            settingsList.add(list.get(x)[1]);
            settingsList.add(list.get(x)[2]);
            settingsList.add(list.get(x)[3]);
            settingsList.add(list.get(x)[4]);
            settingsList.add(list.get(x)[5]);
            settingsList.add(list.get(x)[6]);
        }

        return settingsList;
    }


    // Import the index.csv and return results as List<String[]>
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

    // Import all challenges from challenges.csv and return the resulting ArrayList
    public static List<String[]> importAllChallengesCsv(Context context) {

       // ArrayList<String> challengeList = new ArrayList<String>();

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

        /**
        // Go through the list and add only the users to it
        for (int i = 1; i < list.size(); i++) {
            challengeList.add(list.get(i)[0]);
        }*/
        return list;
    }


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


    // Import progress data from progress.csv and return the resulting ArrayList
    public static ArrayList<String> importProgressCsv(Context context) {

        ArrayList<String> progressList = new ArrayList<String>();

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

        // Go through the list and add only the users to it
        for (int i = 0; i < list.size(); i++) {
            progressList.add(list.get(i)[0]);
        }
        return progressList;
    }


}