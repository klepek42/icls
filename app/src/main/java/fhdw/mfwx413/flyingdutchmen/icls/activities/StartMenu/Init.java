package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

/**
 * Responsibility: Max
 * Created by Max on 20.02.2016
 */
//Todo Jonas: Umsetzen der FirstRun Aktionen
public class Init extends Activity {

    private Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    // private SharedPreferences prefs = null; (jonas)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //checkFirstRun(); (jonas)
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

    /* Jonas
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
            //user-csv auf sd-card auslagern
            //index.csv auf sd-card auslagern
            //idee (noch nicht kommuniziert): für jeden Benutzer eine einzelne progress.csv (z.B. progress_Jonas.csv) erstellen und unter assets abspeichern

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
    */
}