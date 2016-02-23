package fhdw.mfwx413.flyingdutchmen.icls.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by H00052647 on 23.02.2016.
 */
public class UserProgressDatabase {

    public static UserProgressCollection getAllUserProgresses(Context context){

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
}
