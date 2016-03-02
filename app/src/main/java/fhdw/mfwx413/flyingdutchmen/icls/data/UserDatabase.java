package fhdw.mfwx413.flyingdutchmen.icls.data;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.csvExport;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.csvImport;

/**
 * Created by Max on 22/02/16
 */
public class UserDatabase {

    public static UserCollection getAllUser(Context context) {

        UserCollection allUsers;
        allUsers = new UserCollection();

        List<String[]> StringCollectionFromCSV;

        // reading all IndexCards from csv-File
        // output ist a List<String[]>
        StringCollectionFromCSV = csvImport.importUserCsv(context);

        //converting the List<String[]> into a IndexCardCollection
        for (int i = 0; i < StringCollectionFromCSV.size(); i++) {
            allUsers.addUser(
                    new User(
                            StringCollectionFromCSV.get(i)[0],
                            Integer.parseInt(StringCollectionFromCSV.get(i)[1]),
                            Integer.parseInt(StringCollectionFromCSV.get(i)[2]),
                            Integer.parseInt(StringCollectionFromCSV.get(i)[3]),
                            Integer.parseInt(StringCollectionFromCSV.get(i)[4]),
                            Integer.parseInt(StringCollectionFromCSV.get(i)[5]),
                            Integer.parseInt(StringCollectionFromCSV.get(i)[6])
                            )
                    );
        }

        return allUsers;
    }


    public static void writeAllUsers(Context context, UserCollection uc) {
        List<String[]> userList = new ArrayList<String[]>();

        try {
            // UserCollection >>> List<String[]>
            for(int i = 0; i < uc.getSize(); i++) { // ArrayList mit User Objekten
                // String userName = userList.get(i).getmName();
                String [] userAsString = new String[7];
                User user = uc.get(i);

                userAsString[0] = user.getmName();
                userAsString[1] = Integer.toString(user.getmPeriodClass1());
                userAsString[2] = Integer.toString(user.getmPeriodClass2());
                userAsString[3] = Integer.toString(user.getmPeriodClass3());
                userAsString[4] = Integer.toString(user.getmPeriodClass4());
                userAsString[5] = Integer.toString(user.getmPeriodClass5());
                userAsString[6] = Integer.toString(user.getmPeriodClass6());

                userList.add(i, userAsString);
            }
            csvExport.saveUserToCsv(context, userList);
        }
        catch (IOException e){
            Log.e("ICLS-ERROR", "UserDatabase::writeAllUsers::saveUserToCsv(): ", e);
        }


    }

}
