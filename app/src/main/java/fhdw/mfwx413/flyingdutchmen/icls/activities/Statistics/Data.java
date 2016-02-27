package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;

/**
 * Responsibility: Edgar Klepek
 */
public class Data {
    // Static variables for the bundle
    //private static final String KEY_DUE_CHALLENGES_OF_USER_IN_FILE = "K1";
    private static final String KEY_CHOSEN_USER = "K2";
    private static final String KEY_CHOSEN_FILE = "K3";

    private Activity mActivity;
    private User mChosenUser;
    private IndexCard mChosenFile;
    private int mPeriodClass1;
    private int mPeriodClass2;
    private int mPeriodClass3;
    private int mPeriodClass4;
    private int mPeriodClass5;
    private int mPeriodClass6;

    public Data(Activity activity, Bundle bundle) {
        mActivity = activity;
        Intent intent;

        if(bundle == null) {
            // First start of the activity
            intent = mActivity.getIntent();
            mChosenUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
            Log.d("Statistics::Data", "" + mChosenUser.getmName());
            mChosenFile = (IndexCard) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_FILE);
            Log.d("Statistics::Data", "" + mChosenFile.getmName());
        }
        else{
            // Restore Data if bundle is filled
            restoreDataFromBundle(bundle);
        }
    }

    // Save data in bundle if activity stops
    public void saveDataFromBundle(Bundle bundle) {
        bundle.putSerializable(KEY_CHOSEN_USER, mChosenUser);
        bundle.putSerializable(KEY_CHOSEN_FILE, mChosenFile);
    }

    // Restore data from given bundle
    public void restoreDataFromBundle(Bundle bundle) {
        mChosenUser = (User) bundle.getSerializable(KEY_CHOSEN_USER);
        mChosenFile = (IndexCard) bundle.getSerializable(KEY_CHOSEN_FILE);
    }

    public Activity getActivity() {
        return mActivity;
    }

    public User getmChosenUser() {
        return mChosenUser;

    }

    public IndexCard getmChosenFile() {
        return mChosenFile;
    }

    public int getmPeriodClass1() {
        return mPeriodClass1;
    }

    public int getmPeriodClass2() {
        return mPeriodClass2;
    }

    public int getmPeriodClass3() {
        return mPeriodClass3;
    }

    public int getmPeriodClass4() {
        return mPeriodClass4;
    }

    public int getmPeriodClass5() {
        return mPeriodClass5;
    }

    public int getmPeriodClass6() {
        return mPeriodClass6;
    }

    public void setmChosenFile(IndexCard mChosenFile) {
        this.mChosenFile = mChosenFile;
    }
}