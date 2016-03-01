package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
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
    //for testing
    private static final int DEFAULT_CURRENT_CHALLENGE_ID = 0;


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
        bundle.putInt(Constants.BUNDLE_KEY_CURRENT_CHALLENGE_ID, mCurrentChallengeId);
        bundle.putSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_OF_USER_IN_FILE, mDueChallengesOfUserInFile);
        bundle.putSerializable(Constants.BUNDLE_KEY_CHOSEN_USER, mChosenUser);
        bundle.putSerializable(Constants.BUNDLE_KEY_CHOSEN_FILE, mChosenFile);
    }

    //restore data from given bundle
    public void restoreDataFromBundle(Bundle bundle) {
        mCurrentChallengeId = bundle.getInt(Constants.BUNDLE_KEY_CURRENT_CHALLENGE_ID);
        mDueChallengesOfUserInFile = (ChallengeCollection) bundle.getSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_OF_USER_IN_FILE);
        mChosenUser = (User) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_USER);
        mChosenFile = (IndexCard) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_FILE);
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


