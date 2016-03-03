package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Random;

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
 * Responsibility: Edgar Klepek
 */
public class Data {
    // Static variables for bundle
    private static final int DEFAULT_CURRENT_CHALLENGE_ID = 0;

    private Activity mActivity;
    private int mCurrentChallengeId;
    private ChallengeCollection mDueChallengesOfUserInFile;
    private User mChosenUser;
    private IndexCard mChosenFile;
    private UserProgressCollection mUserProgresses;

    public Data(Activity activity, Bundle bundle) {
        mActivity = activity;
        Intent intent;

        if(bundle == null) {
            // If bundle is not filled, the data will be initialized by the extras of the intent
            intent = activity.getIntent();
            mCurrentChallengeId = intent.getIntExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, DEFAULT_CURRENT_CHALLENGE_ID);
            mDueChallengesOfUserInFile = (ChallengeCollection) intent.getSerializableExtra(Constants.KEY_PARAM_DUE_CHALLENGES_OF_USER_IN_FILE);
            mChosenUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
            mChosenFile = (IndexCard) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_FILE);
            mUserProgresses = (UserProgressCollection) intent.getSerializableExtra(Constants.KEY_PARAM_USER_PROGRESS_CURRENT_USER);
        }
        else{
            // Restore Data when bundle gets filled
            restoreDataFromBundle(bundle);
        }
    }

    // Save data in bundle for restoration
    public void saveDataFromBundle(Bundle bundle) {
        bundle.putInt(Constants.BUNDLE_KEY_CURRENT_CHALLENGE_ID, mCurrentChallengeId);
        bundle.putSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_OF_USER_IN_FILE, mDueChallengesOfUserInFile);
        bundle.putSerializable(Constants.BUNDLE_KEY_CHOSEN_USER, mChosenUser);
        bundle.putSerializable(Constants.BUNDLE_KEY_CHOSEN_FILE, mChosenFile);
        bundle.putSerializable(Constants.BUNDLE_KEY_USER_PROGRESS_CURRENT_USER, mUserProgresses);
    }

    // Restore data from the given bundle
    public void restoreDataFromBundle(Bundle bundle) {
        mCurrentChallengeId = bundle.getInt(Constants.BUNDLE_KEY_CURRENT_CHALLENGE_ID);
        mDueChallengesOfUserInFile = (ChallengeCollection) bundle.getSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_OF_USER_IN_FILE);
        mChosenUser = (User) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_USER);
        mChosenFile = (IndexCard) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_FILE);
        mUserProgresses = (UserProgressCollection) bundle.getSerializable(Constants.BUNDLE_KEY_USER_PROGRESS_CURRENT_USER);
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

    public IndexCard getmChosenFile() {return mChosenFile;}
}