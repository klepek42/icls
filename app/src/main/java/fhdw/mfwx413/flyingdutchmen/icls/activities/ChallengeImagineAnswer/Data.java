package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCardDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.IdNotFoundException;

/**
 * Responsibility: Edgar Klepek
 */
public class Data {
    private static final int DEFAULT_CURRENT_CHALLENGE_ID = 1;
    // static variables for bundle
    private static final String KEY_CURRENT_CHALLENGE_ID = "K1";
    private static final String KEY_DUE_CHALLENGES_OF_USER_IN_FILE = "K2";
    private static final String KEY_CHOSEN_USER = "K3";
    private static final String KEY_CHOSEN_FILE = "K4";

    public Activity getActivity() {
        return mActivity;
    }

    private Activity mActivity;
    private int mCurrentChallengeId;
    private ChallengeCollection mDueChallengesOfUserInFile;
    private User mChosenUser;
    private IndexCard mChosenFile;

    public Data(Activity activity, Bundle bundle) {
        mActivity = activity;
        //Intent intent;
        // Auslesen des Intents sobald vorhanden

        if(bundle == null) {
            //Todo Edgar: intent auslesen, wenn Activiy aufgerufen wird
            // if bundle is not filled, the data will be initialized by the extras of the intent
            //intent = mActivity.getIntent();
            // Testweise (hier muss in Zukunft der intent übertrag realisiert werden)
            mCurrentChallengeId = DEFAULT_CURRENT_CHALLENGE_ID;
            mDueChallengesOfUserInFile = ChallengeDatabase.getAllChallenges(mActivity);
            mChosenUser = new User("ImagineUser", 5, 60, 1440, 10080, 43200, 259200);
            try {
                mChosenFile = IndexCardDatabase.getIndexCards(mActivity).getIndexCard(4);
            }
            catch (IdNotFoundException e){
                Log.e("ICLS-LOG", "ChallengeImagineAnswer::Data: ", e);
            }
        }
        else{
            // Restore Data when bundle gets filled
            restoreDataFromBundle(bundle);
        }
    }

    // Save data in bundle for restoration
    public void saveDataFromBundle(Bundle bundle) {
        bundle.putInt(KEY_CURRENT_CHALLENGE_ID, mCurrentChallengeId);
        bundle.putSerializable(KEY_DUE_CHALLENGES_OF_USER_IN_FILE, mDueChallengesOfUserInFile);
        bundle.putSerializable(KEY_CHOSEN_USER, mChosenUser);
        bundle.putSerializable(KEY_CHOSEN_FILE, mChosenFile);
    }

    // Restore data from the given bundle
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

    public User getmChosenUser() {return mChosenUser;}

    public IndexCard getmChosenFile() {return mChosenFile;}
}
