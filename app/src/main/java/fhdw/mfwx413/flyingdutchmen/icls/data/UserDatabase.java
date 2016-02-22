package fhdw.mfwx413.flyingdutchmen.icls.data;

import android.content.Context;

import java.util.List;

/**
 * Created by Max on 22/02/16
 */
public class UserDatabase {

    /**
    public static UserCollection getUser(Context context) {


        UserCollection allUsers;
        allUsers = new UserCollection();

        List<String[]> StringCollectionFromCSV;

        // reading all IndexCards from csv-File
        // output ist a List<String[]>
        StringCollectionFromCSV = csvImport.importUserCsv(context);

        //converting the List<String[]> into a IndexCardCollection
        for (int i = 0; i < StringCollectionFromCSV.size(); i++) {
            allUsers.addUser(new User(Integer.parseInt(StringCollectionFromCSV.get(i)[0]), StringCollectionFromCSV.get(i)[1]));
        }

        return allUsers;

    }**/
}
