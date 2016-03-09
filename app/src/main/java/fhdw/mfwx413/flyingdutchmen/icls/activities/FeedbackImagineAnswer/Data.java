package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;

/**
 * Responsibility: Pascal Heß
 */
public class Data {

    //static variables are necessary for intent.getIntExtra
    private static final int DEFAULT_CURRENT_CHALLENGE_ID = 0;
    private static final boolean DEFAULT_IS_ANSWER_CORRECT = false;

    private final Activity mActivity;
    private ChallengeCollection mDueChallengesOfUserInFile;
    private int mCurrentChallengeId;
    private User mChosenUser;
    private IndexCard mChosenFile;
    private boolean mIsAnswerCorrect;
    private UserProgressCollection mCurrentUserProgresses;

    //Constructor
    public Data(Activity activity, Bundle bundle) {
        Intent intent;
        mActivity = activity;
        intent = activity.getIntent();

        if (bundle == null) {
            // If bundle isn't filled, the data will be initialized by the extras of the intent
            mCurrentChallengeId = intent.getIntExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, DEFAULT_CURRENT_CHALLENGE_ID);
            mDueChallengesOfUserInFile = (ChallengeCollection) intent.getSerializableExtra(Constants.KEY_PARAM_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD);
            mChosenUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
            mChosenFile = (IndexCard) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_INDEX_CARD);
            mIsAnswerCorrect = intent.getBooleanExtra(Constants.KEY_PARAM_IS_ANSWER_CORRECT, DEFAULT_IS_ANSWER_CORRECT);
            mCurrentUserProgresses = (UserProgressCollection) intent.getSerializableExtra(Constants.KEY_PARAM_USER_PROGRESS_CURRENT_USER);
        } else {
            // if bundle is filled, data will be restored by content of the bundle
            restoreDataFromBundle(bundle);
        }
    }

    //this method saves the data in bundle, if activity stops
    public void saveDataFromBundle(Bundle bundle) {
        bundle.putInt(Constants.BUNDLE_KEY_CURRENT_CHALLENGE_ID, mCurrentChallengeId);
        bundle.putSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD, mDueChallengesOfUserInFile);
        bundle.putSerializable(Constants.BUNDLE_KEY_CHOSEN_USER, mChosenUser);
        bundle.putSerializable(Constants.BUNDLE_KEY_CHOSEN_INDEX_CARD, mChosenFile);
        bundle.putBoolean(Constants.BUNDLE_KEY_IS_ANSWER_CORRECT, mIsAnswerCorrect);
        bundle.putSerializable(Constants.BUNDLE_KEY_USER_PROGRESS_CURRENT_USER, mCurrentUserProgresses);
    }

    //this method restores the data from the given bundle
    private void restoreDataFromBundle(Bundle bundle) {
        mCurrentChallengeId = bundle.getInt(Constants.BUNDLE_KEY_CURRENT_CHALLENGE_ID);
        mDueChallengesOfUserInFile = (ChallengeCollection) bundle.getSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD);
        mChosenUser = (User) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_USER);
        mChosenFile = (IndexCard) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_INDEX_CARD);
        mIsAnswerCorrect = bundle.getBoolean(Constants.BUNDLE_KEY_IS_ANSWER_CORRECT);
        mCurrentUserProgresses = (UserProgressCollection) bundle.getSerializable(Constants.BUNDLE_KEY_USER_PROGRESS_CURRENT_USER);
    }

    //this method increments the current challenge ID by 1
    //it is important to compute the next challenge ID.
    public void incrementChallengeIdByOne() {
        mCurrentChallengeId = mCurrentChallengeId + 1;
    }

    //in the following you will find the getter for the private attributes of this class:
    public ChallengeCollection getmDueChallengesOfUserInFile() {
        return mDueChallengesOfUserInFile;
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

    public int getmCurrentChallengeId() {
        return mCurrentChallengeId;
    }

    public UserProgressCollection getmCurrentUserProgresses() {
        return mCurrentUserProgresses;
    }
}
