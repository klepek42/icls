package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgress;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;

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
    private int mNumberAllChallenges;
    private int mNumberDueChallenges;
    private int mNumberOfPeriodClass1;
    private int mNumberOfPeriodClass2;
    private int mNumberOfPeriodClass3;
    private int mNumberOfPeriodClass4;
    private int mNumberOfPeriodClass5;
    private int mNumberOfPeriodClass6;
    private ChallengeCollection mAllChallenges;

    public Data(Activity activity, Bundle bundle) {
        mActivity = activity;
        Intent intent;

        if(bundle == null) {
            // First start of the activity
            intent = mActivity.getIntent();
            mChosenUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
            Log.d("Statistics::Data::User", "" + mChosenUser.getmName());
            mChosenFile = (IndexCard) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_FILE);
            Log.d("Statistics::Data::File", "" + mChosenFile.getmName());
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

    public void setmChosenFile(IndexCard mChosenFile) {
        this.mChosenFile = mChosenFile;
    }

    // Count the number of all existing challenges of the current file
    public int getmNumberAllChallenges() {
        mAllChallenges = ChallengeDatabase.getAllChallenges(mActivity);
        for(int i = 0; i < mAllChallenges.getSize(); i++) {
            Challenge mChallenge = mAllChallenges.getChallenge(i);
            if(mChallenge.getmIndexCard().getmID() == mChosenFile.getmID()) {
                mNumberAllChallenges++;
            }
        }
        return mNumberAllChallenges;
    }

    public int getmNumberDueChallenges() {
        /*
        // TODO: Berechnung der Anzahl der fälligen Challenges der aktuellen Kartei und des aktuellen Users (Datumvergleich?)
        // Experiment --> zu kompliziert und redundant
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd.hhmmss");
        // DEMODATEN
        Date challengeTimestamp = new Date("2016.01.25.18.00.00");

        int numberDueChallenges = 0;
        UserProgressCollection mAllUserProgresses = UserProgressDatabase.getAllUserProgresses(mActivity);
        for(int i = 0; i < mAllUserProgresses.getSize(); i++) {
            UserProgress mUserProgress = mAllUserProgresses.getUserProgress(i);

            if(mUserProgress.getmChallengeID() ==  && mUserProgress.getmUserName() == mChosenUser.getmName()) {
                int compareResult = currentDate.compareTo(challengeTimestamp);
                if(compareResult >= mChosenUser.getmPeriodClass1() && all.get) {
                    numberDueChallenges++;
                }

                int compareResult = currentDate.compareTo(challengeTimestamp);
                if(compareResult >= mChosenUser.getmPeriodClass2() && all.get) {
                    numberDueChallenges++;
                }
            }

        }*/
        int numberDueChallenges = getmNumberOfPeriodClass1() + getmNumberOfPeriodClass2() + getmNumberOfPeriodClass3() + getmNumberOfPeriodClass4() + getmNumberOfPeriodClass5() + getmNumberOfPeriodClass6();
        return numberDueChallenges;
    }

    public int getmNumberOfPeriodClass1() {
        // TODO: Berechnung der fälligen Challenges in Klasse 1

        int numberDueChallenges = 0;
        UserProgressCollection mAllUserProgresses = UserProgressDatabase.getSpecificUserAndClassProgresses(mActivity, mChosenUser.toString(), "1");
        for(int i = 0; i < mAllUserProgresses.getSize(); i++) {
            UserProgress mUserProgress = mAllUserProgresses.getUserProgress(i);


            /* if (mUserProgress.getmChallengeID() ==  && mUserProgress.getmUserName() == mChosenUser.getmName()) {
            }*/
        }

        // TODO: Wert aus Berechnung einfügen
        int numberOfPeriodClass1 = 0;
        return numberOfPeriodClass1;
    }

    public int getmNumberOfPeriodClass2() {
        // TODO: Berechnung der fälligen Challenges in Klasse 2

        // TODO: Wert aus Berechnung einfügen
        int numberOfPeriodClass2 = 0;
        return numberOfPeriodClass2;
    }

    public int getmNumberOfPeriodClass3() {
        // TODO: Berechnung der fälligen Challenges in Klasse 3

        // TODO: Wert aus Berechnung einfügen
        mNumberOfPeriodClass3 = 0;
        return mNumberOfPeriodClass3;
    }

    public int getmNumberOfPeriodClass4() {
        // TODO: Berechnung der fälligen Challenges in Klasse 4

        // TODO: Wert aus Berechnung einfügen
        mNumberOfPeriodClass4 = 0;
        return mNumberOfPeriodClass4;
    }

    public int getmNumberOfPeriodClass5() {
        // TODO: Berechnung der fälligen Challenges in Klasse 5

        // TODO: Wert aus Berechnung einfügen
        mNumberOfPeriodClass5 = 0;
        return mNumberOfPeriodClass5;
    }

    public int getmNumberOfPeriodClass6() {
        // TODO: Berechnung der fälligen Challenges in Klasse 6

        // TODO: Wert aus Berechnung einfügen
        mNumberOfPeriodClass6 = 0;
        return mNumberOfPeriodClass6;
    }


}