package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.io.File;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCardDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;

/**
 * Responsibility: Jonas Krabs
 */
public class Data {

    private static final int DEFAULT_CURRENT_CHALLENGE_ID = 2;
    private static final String KEY_CURRENT_CHALLENGE_ID = "K1";
    private static final String KEY_DUE_CHALLENGES_OF_USER_IN_FILE = "K2";
    private static final String KEY_CHOSEN_USER = "K3";
    private static final String KEY_CHOSEN_FILE = "K4";

    private Activity mActivity;
    private ChallengeCollection mDueChallengesOfUserInFile;
    private int mCurrentChallengeId;
    private User mChosenUser;
    private IndexCard mChosenFile;

    public Data(Activity activity, Bundle bundle) {
        mActivity = activity;
        //Intent intent;

        if(bundle == null) {
            //intent = mActivity.getIntent();
            //Testweise (hier muss in Zukunft der intent übertrag realisiert werden)
            mCurrentChallengeId = DEFAULT_CURRENT_CHALLENGE_ID;
            mDueChallengesOfUserInFile = ChallengeDatabase.getAllChallenges();
            mChosenUser = new User();
            mChosenFile = IndexCardDatabase.getIndexCards().getIndexCard(4);
        }
        else{
            restoreDataFromBundle(bundle);
        }

    }

    public void saveDataFromBundle(Bundle bundle) {
        bundle.putInt(KEY_CURRENT_CHALLENGE_ID, mCurrentChallengeId);
        bundle.putSerializable(KEY_DUE_CHALLENGES_OF_USER_IN_FILE, mDueChallengesOfUserInFile);
        bundle.putSerializable(KEY_CHOSEN_USER, mChosenUser);
        bundle.putSerializable(KEY_CHOSEN_FILE, mChosenFile);
    }

    public void restoreDataFromBundle(Bundle bundle) {
        mCurrentChallengeId = bundle.getInt(KEY_CURRENT_CHALLENGE_ID);
        mDueChallengesOfUserInFile = (ChallengeCollection) bundle.getSerializable(KEY_DUE_CHALLENGES_OF_USER_IN_FILE);
        mChosenUser = (User) bundle.getSerializable(KEY_CHOSEN_USER);
        mChosenFile = (IndexCard) bundle.getSerializable(KEY_CHOSEN_FILE);
    }

    public int getmCurrentChallengeId() {
        return mCurrentChallengeId;
    }

    public ChallengeCollection getmDueChallengesOfUserInFile() {
        return mDueChallengesOfUserInFile;
    }
}
