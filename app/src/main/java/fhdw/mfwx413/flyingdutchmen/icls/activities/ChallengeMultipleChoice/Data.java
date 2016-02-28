package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCardDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;

/**
 * Responsibility: Daniel zur Linden
 */
public class Data {
    private static final int DEFAULT_CURRENT_CHALLENGE_ID = 1;
    // static variables for bundle
    private static final String KEY_CURRENT_CHALLENGE_ID = "K1";
    private static final String KEY_DUE_CHALLENGES_OF_USER_IN_FILE = "K2";
    private static final String KEY_CHOSEN_USER = "K3";
    private static final String KEY_CHOSEN_FILE = "K4";

    private Activity mActivity;
    private ChallengeCollection mDueChallengesOfUserInFile;
    private int mCurrentChallengeId;
    private User mChosenUser;
    private IndexCard mChosenFile;
    private UserProgressCollection mAllUserProgresses;

    public Data(Activity activity, Bundle bundle) {
        mActivity = activity;
        //Intent intent;

        if(bundle == null) {
            //Todo Daniel: intent auslesen, wenn Activiy aufgerufen wird
            //if bundle isn't filled, the data will be initialized by the extras of the intent
            //intent = mActivity.getIntent();
            //Testweise (hier muss in Zukunft der intent übertrag realisiert werden)
            mCurrentChallengeId = DEFAULT_CURRENT_CHALLENGE_ID;
            mDueChallengesOfUserInFile = ChallengeDatabase.getAllChallenges(mActivity);
            mChosenUser = new User("Testuser", 5, 60, 1440, 10080, 43200, 259200);
            try {
                mChosenFile = IndexCardDatabase.getIndexCards(mActivity).getIndexCard(4);
            }
            catch (IdNotFoundException e){
                Log.e("ICLS-LOG", "ChallengeMultipleChoice::Data: ", e);
            }
            mAllUserProgresses = UserProgressDatabase.getAllUserProgresses(mActivity);
        }
        else{
            //restore Data if bundle is filled
            restoreDataFromBundle(bundle);
        }

    }

    //save data in bundle if activity stops
    public void saveDataFromBundle(Bundle bundle) {
        bundle.putInt(KEY_CURRENT_CHALLENGE_ID, mCurrentChallengeId);
        bundle.putSerializable(KEY_DUE_CHALLENGES_OF_USER_IN_FILE, mDueChallengesOfUserInFile);
        bundle.putSerializable(KEY_CHOSEN_USER, mChosenUser);
        bundle.putSerializable(KEY_CHOSEN_FILE, mChosenFile);
    }

    //restore data from given bundle
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

    public Activity getActivity() {
        return mActivity;
    }

    public User getmChosenUser() {return mChosenUser;}

    public UserProgressCollection getmAllUserProgresses() {
        return mAllUserProgresses;
    }

    public IndexCard getmChosenFile() {return mChosenFile;}
}


