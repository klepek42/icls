package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCardCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCardDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgress;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;

/**
 * Created by edgar on 17.02.2016.
 */
public class Data {

    private static final int DEFAULT_CURRENT_CHALLENGE_ID = 1;
    // static variables for bundle
    private static final String KEY_CURRENT_CHALLENGE_ID = "K1";
    private static final String KEY_DUE_CHALLENGES_OF_USER_IN_FILE = "K2";
    private static final String KEY_CHOSEN_USER = "K3";
    private static final String KEY_CHOSEN_FILE = "K4";

    private Activity mActivity;
    private User mCurrentUser;
    private UserProgressCollection allUserProgresses;
    private IndexCard mCurrentIndex;
    private IndexCardCollection mAllIndexCards;

    public Data(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        mActivity = activity;

        if(savedInstanceState == null) {
            intent = activity.getIntent();
            mCurrentUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
            allUserProgresses = UserProgressDatabase.getAllUserProgresses(mActivity);
            mAllIndexCards = IndexCardDatabase.getIndexCards(mActivity);
            Log.d("mCurrentUser: ", "" + mCurrentUser);

            /** Was macht das?
            try {
                mChosenFile = IndexCardDatabase.getIndexCards(mActivity).getIndexCard(4);
            }
            catch (IdNotFoundException e){
                Log.e("ICLS-LOG", "ChallengeFreeAnswer::Data: ", e);
            }**/
        }
        else {
            restoreDataFromBundle(savedInstanceState);
        }

    }

    public IndexCardCollection getmAllIndexCards() {
        return mAllIndexCards;
    }

    public User getCurrentUser() {
        return mCurrentUser;
    }

    public Activity getActivity() {
        return mActivity;
    }

    public void setmCurrentIndex(IndexCard mCurrentIndex) {
        this.mCurrentIndex = mCurrentIndex;
    }

    //save data in bundle if activity stops
    public void saveDataFromBundle(Bundle bundle) {
        //bundle.putInt(KEY_CURRENT_CHALLENGE_ID, mCurrentChallengeId);
        //bundle.putSerializable(KEY_DUE_CHALLENGES_OF_USER_IN_FILE, mDueChallengesOfUserInFile);
        bundle.putSerializable(KEY_CHOSEN_USER, mCurrentUser);
        bundle.putSerializable(KEY_CHOSEN_FILE, mCurrentIndex);
    }

    //restore data from given bundle
    public void restoreDataFromBundle(Bundle bundle) {
        //mCurrentChallengeId = bundle.getInt(KEY_CURRENT_CHALLENGE_ID);
        //mDueChallengesOfUserInFile = (ChallengeCollection) bundle.getSerializable(KEY_DUE_CHALLENGES_OF_USER_IN_FILE);
        mCurrentUser = (User) bundle.getSerializable(KEY_CHOSEN_USER);
        mCurrentIndex = (IndexCard) bundle.getSerializable(KEY_CHOSEN_FILE);
    }

}