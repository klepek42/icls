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
    private static ArrayList<String> userList = new ArrayList<String>();

    // Import the users from the users.csv and return the resulting ArrayList
    public static ArrayList<String> importUserCsv(Context context) {

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

}