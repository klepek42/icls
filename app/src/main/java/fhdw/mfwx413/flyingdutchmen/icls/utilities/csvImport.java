package fhdw.mfwx413.flyingdutchmen.icls.utilities;

import android.content.Context;
import android.util.Log;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileInputStream;
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
            FileInputStream fis = context.openFileInput("users.csv");
            InputStreamReader csvStreamReader = new InputStreamReader(fis);
            Log.d("ICLS-INFO", "FileInputStream: " + fis.toString());
            Log.d("ICLS-INFO", "csvStreamReader: " + csvStreamReader.toString());

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

    // Import the index.csv and return the results as list
    public static List<String[]> importIndexCsv(Context context) {

        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

        try {
            FileInputStream fis = new FileInputStream(android.os.Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/ICLS/index.csv");
            InputStreamReader csvStreamReader = new InputStreamReader(fis);
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
    public static List<String[]> importChallengeCsv(Context context) {

        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

        try {
            FileInputStream fis = new FileInputStream(android.os.Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/ICLS/challenges.csv");
            InputStreamReader csvStreamReader = new InputStreamReader(fis);

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

    // Import progress data from progress.csv and return the resulting ArrayList
    public static  List<String[]> importUserProgressCsv(Context context, String userName) {

        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

        try {
            String path = context.getFilesDir().toString() + "/UserProgresses/progress_" + userName + ".csv";
            //FileInputStream fis = context.openFileInput("/UserProgresses/progress_" + userName);
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader csvStreamReader = new InputStreamReader(fis);
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

    public static boolean checkICLSFile(Context context){
        boolean allFilesExists = false;
        File fileProgresses = new File(context.getFilesDir().toString() + "/UserProgresses");
        File fileUsers = new File(context.getFilesDir().toString() + "/users.csv");
        File fileChallenges = new File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/ICLS/challenges.csv");
        File fileIndex = new File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/ICLS/index.csv");
        if (fileProgresses.exists() && fileChallenges.exists() && fileUsers.exists() && fileIndex.exists()) {
            allFilesExists = true;
        }
        return allFilesExists;
    }
}