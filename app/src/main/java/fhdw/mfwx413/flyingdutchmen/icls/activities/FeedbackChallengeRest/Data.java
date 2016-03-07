package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackChallengeRest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;


/**
 * Responsibilty: Pascal Heß
 */
public class Data {

    private static final int DEFAULT_CURRENT_CHALLENGE_ID = 0;
    private static final boolean DEFAULT_IS_ANSWER_CORRECT = false;

    // static variables for bundle are defined in the own constants-class

    private Activity mActivity;
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

        if(bundle == null) {
            mCurrentChallengeId = intent.getIntExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, DEFAULT_CURRENT_CHALLENGE_ID);
            mDueChallengesOfUserInFile = (ChallengeCollection) intent.getSerializableExtra(Constants.KEY_PARAM_DUE_CHALLENGES_OF_USER_IN_FILE);
            mChosenUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
            mChosenFile = (IndexCard) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_INDEX_CARD);
            mIsAnswerCorrect = intent.getBooleanExtra(Constants.KEY_PARAM_IS_ANSWER_CORRECT, DEFAULT_IS_ANSWER_CORRECT);
            mCurrentUserProgresses = (UserProgressCollection) intent.getSerializableExtra(Constants.KEY_PARAM_USER_PROGRESS_CURRENT_USER);
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
        bundle.putSerializable(Constants.BUNDLE_KEY_CHOSEN_INDEX_CARD, mChosenFile);
        bundle.putBoolean(Constants.BUNDLE_KEY_IS_ANSWER_CORRECT, mIsAnswerCorrect);
        bundle.putSerializable(Constants.BUNDLE_KEY_USER_PROGRESS_CURRENT_USER, mCurrentUserProgresses);
    }

    //restore data from given bundle
    public void restoreDataFromBundle(Bundle bundle) {
        mCurrentChallengeId = bundle.getInt(Constants.BUNDLE_KEY_CURRENT_CHALLENGE_ID);
        mDueChallengesOfUserInFile = (ChallengeCollection) bundle.getSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_OF_USER_IN_FILE);
        mChosenUser = (User) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_USER);
        mChosenFile = (IndexCard) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_INDEX_CARD);
        mIsAnswerCorrect = bundle.getBoolean(Constants.BUNDLE_KEY_IS_ANSWER_CORRECT);
        mCurrentUserProgresses = (UserProgressCollection) bundle.getSerializable(Constants.BUNDLE_KEY_USER_PROGRESS_CURRENT_USER);
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

    public boolean getmIsAnswerCorrect() {
        return mIsAnswerCorrect;
    }

    public UserProgressCollection getmCurrentUserProgresses() {
        return mCurrentUserProgresses;
    }

    public void incrementChallengeIdByOne() {
        mCurrentChallengeId = mCurrentChallengeId + 1;
    }
}
