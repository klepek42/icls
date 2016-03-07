package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
/**
 * Responsibility: Edgar Klepek
 */
public class Data {

    // Static variable for bundle
    private static final int DEFAULT_CURRENT_CHALLENGE_ID = 0;

    // Member variables
    private Activity mActivity;
    private int mCurrentChallengeId;
    private ChallengeCollection mDueChallengesOfUserInFile;
    private User mChosenUser;
    private IndexCard mChosenFile;
    private UserProgressCollection mUserProgresses;

    // Constructor
    public Data(Activity activity, Bundle bundle) {
        mActivity = activity;
        Intent intent;

        // First start of the activity triggers to get the data given by the previous Activity as an intent
        if(bundle == null) {
            intent = activity.getIntent();
            mCurrentChallengeId = intent.getIntExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, DEFAULT_CURRENT_CHALLENGE_ID);
            mDueChallengesOfUserInFile = (ChallengeCollection) intent.getSerializableExtra(Constants.KEY_PARAM_DUE_CHALLENGES_OF_USER_IN_FILE);
            mChosenUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
            mChosenFile = (IndexCard) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_INDEX_CARD);
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
        bundle.putSerializable(Constants.BUNDLE_KEY_CHOSEN_INDEX_CARD, mChosenFile);
        bundle.putSerializable(Constants.BUNDLE_KEY_USER_PROGRESS_CURRENT_USER, mUserProgresses);
    }

    // Restore data from the given bundle
    public void restoreDataFromBundle(Bundle bundle) {
        mCurrentChallengeId = bundle.getInt(Constants.BUNDLE_KEY_CURRENT_CHALLENGE_ID);
        mDueChallengesOfUserInFile = (ChallengeCollection) bundle.getSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_OF_USER_IN_FILE);
        mChosenUser = (User) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_USER);
        mChosenFile = (IndexCard) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_INDEX_CARD);
        mUserProgresses = (UserProgressCollection) bundle.getSerializable(Constants.BUNDLE_KEY_USER_PROGRESS_CURRENT_USER);
    }

    // Get the current challenge id
    public int getCurrentChallengeId() {
        return mCurrentChallengeId;
    }

    // Get the list of due challenges of the chosen file
    public ChallengeCollection getDueChallengesOfUserInFile() {
        return mDueChallengesOfUserInFile;
    }

    // Get the current activity and simultaneously the context
    public Activity getActivity() {
        return mActivity;
    }

    // Get the current user
    public User getChosenUser() {return mChosenUser;}

    // Get the current file
    public IndexCard getChosenFile() {return mChosenFile;}

    // Get the current user progress to give it to the following feedback
    public UserProgressCollection getUserProgresses() {
        return mUserProgresses;
    }
}