package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.FileNotFoundException;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgress;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.csvExport;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.csvImport;

/**
 * Created by Edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 20.02.2016
 * Updated by Max on 21.02.2016
 * Updated by Max on 23.02.2016
 * Updated by Jonas on 26.02.2016
 * Updated by Max on 02.03.2016
 */
//Todo Jonas: Umsetzen der FirstRun Aktionen
public class Init extends Activity {

    private Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    // Jonas
    private SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Jonas
        checkFirstRun();
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
        initGui();
        initApplicationLogic();
        initEventToListenerMapping();
    }

    private void initData(Bundle savedInstanceState) {
        mData = new Data(this, savedInstanceState);
    }

    private void initGui() {
        mGui = new Gui(this);
    }

    private void initApplicationLogic() {
        mApplicationLogic = new ApplicationLogic(mData, mGui, this);
    }

    private void initEventToListenerMapping() {
        new EventToListenerMapping(mGui, mApplicationLogic);
    }

    // Jonas
    //There are some things that have to be done, only on the first run of the app after the installation
    private void checkFirstRun() {

        final String PREFS_NAME = "FirstRunPref";
        final String PREF_VERSION_CODE_KEY = "version_code";
        final int DOESNT_EXIST = -1;


        // Get current version code
        int currentVersionCode = 0;
        try {
            //it is set up in Gradle Script > build.gradle (Module:app)
            //You also can set up the Version Code and name in the manifest, but therefor you have to delete the default values in gradle
            currentVersionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            // handle exception
            e.printStackTrace();
            return;
        }

        // Get saved version code
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int savedVersionCode = prefs.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);
        Log.d("ICLS-INFO", "currentVersionCode: " + currentVersionCode);
        Log.d("ICLS-INFO", "savedVersionCode: " + savedVersionCode);

        // Check for first run or upgrade
        if (currentVersionCode == savedVersionCode) {

            Log.d("ICLS-INFO", "this is a normal run");
            // This is just a normal run
            return;

        } else if (savedVersionCode == DOESNT_EXIST) {

            Log.d("ICLS-INFO", "This is the first run after a new installation! App data will be installed!");
            //build app folder on external storage
            try {
                csvExport.buildFolders(this);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //copy app data from assets into app folder on external storage
            csvExport.copyAssets(this);
            //create userprogresses and save in app folder
            createUserProgresses();

            //check if all necessary files are installed
            if(csvImport.checkICLSFile(this) == true){
                Log.d("ICLS-INFO", "Alle Dateien für die App wurden erfolgreich auf SD-Card kopiert");
                Toast info = Toast.makeText(this, "AppData wurde erfolgreich angelegt", Toast.LENGTH_LONG);
                info.show();
            }
            else{
                //if there are any missing files, the app will be closed, becaue there would be an exception on runtime
                Log.e("ICLS-ERROR", "Bei dem erzeugen der AppData ist ein Fehler aufgetreten");
                Toast info = Toast.makeText(this, "Fehler beim erzeugen der AppData!", Toast.LENGTH_LONG);
                info.show();
                this.finish();
            }

        } else if (currentVersionCode > savedVersionCode) {

            Log.d("ICLS-INFO", "This is the first run after an update!");
            //In the moment there is no need to care for updates. We will stay on Version 1 for the exam
            //Updates could be done, by setting a new VersionCode and a new VersionName for the app
            //This could be done in to ways:
            //1) change VersionCode and VersionName in Gradle Script > build.gradle (Module:app)
            //2) set VersionCode and VersionName in the manifest (you have to remove the values from gradle, because otherwise the values will be overwritten) be careful with that!!
        }

        // Update the shared preferences with the current version code
        prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).commit();

    }


    //create a userprogress.csv file for each user and save it in app folder
    private void createUserProgresses() {
        UserCollection allUsers = UserDatabase.getAllUser(this);
        ChallengeCollection allChallenges = ChallengeDatabase.getAllChallenges(this);

        for(int i = 0; i < allUsers.getSize(); i++) {
            UserProgressCollection userProgressCollection = new UserProgressCollection();


            for(int j = 0; j < allChallenges.getSize(); j++) {
                UserProgress userProgress = new UserProgress(allUsers.get(i).getName(), allChallenges.getChallenge(j).getmID(), 1, Constants.DEFAULT_TIMESTAMP);
                userProgressCollection.addUserProgress(userProgress);
            }
            UserProgressDatabase.writeSpecificUserProgresses(userProgressCollection, allUsers.get(i).getName(), this);
        }

    }
}