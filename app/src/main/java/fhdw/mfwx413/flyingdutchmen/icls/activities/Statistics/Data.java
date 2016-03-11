package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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

    private Activity mActivity;
    private User mChosenUser;
    private IndexCard mChosenFile;
    private int mNumberAllChallenges;
    private ChallengeCollection mDueChallenges;
    private ChallengeCollection mAllChallenges;
    private UserProgressCollection mCurrentUserUserProgresses;

    // Constructor
    public Data(Activity activity, Bundle bundle) {
        mActivity = activity;
        Intent intent;
        mAllChallenges = ChallengeDatabase.getAllChallenges();

        // First start of the activity triggers to get the data given by the previous Activity as an intent
        if(bundle == null) {
            intent = mActivity.getIntent();
            mChosenUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
            mChosenFile = (IndexCard) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_INDEX_CARD);
            mDueChallenges = (ChallengeCollection) intent.getSerializableExtra(Constants.KEY_PARAM_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD);
            mCurrentUserUserProgresses = UserProgressDatabase.getUserProgresses(mActivity, mChosenUser.getName());
        }
        else{
            // Restore Data if bundle is filled
            restoreDataFromBundle(bundle);
        }
    }

    // Save data in bundle if activity stops
    public void saveDataFromBundle(Bundle bundle) {
        bundle.putSerializable(Constants.BUNDLE_KEY_CHOSEN_USER, mChosenUser);
        bundle.putSerializable(Constants.BUNDLE_KEY_CHOSEN_INDEX_CARD, mChosenFile);
        bundle.putSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD, mDueChallenges);
        bundle.putSerializable(Constants.BUNDLE_KEY_USER_PROGRESS_CURRENT_USER, mCurrentUserUserProgresses);
    }

    // Restore data from given bundle
    public void restoreDataFromBundle(Bundle bundle) {
        mChosenUser = (User) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_USER);
        mChosenFile = (IndexCard) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_INDEX_CARD);
        mDueChallenges = (ChallengeCollection) bundle.getSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD);
        mCurrentUserUserProgresses = (UserProgressCollection) bundle.getSerializable(Constants.BUNDLE_KEY_USER_PROGRESS_CURRENT_USER);
    }

    // Get the current activity and simultaneously the context
    public Activity getActivity() {
        return mActivity;
    }

    // Get the current user
    public User getChosenUser() {
        return mChosenUser;

    }

    // Get the current file
    public IndexCard getChosenFile() {
        return mChosenFile;
    }

    // Count the number of all existing challenges of the current file
    public int getNumberAllChallenges() {
        for(int i = 0; i < mAllChallenges.getSize(); i++) {
            Challenge mChallenge = mAllChallenges.getChallenge(i);
            if(mChallenge.getmIndexCard().getmID() == mChosenFile.getmID()) {
                mNumberAllChallenges++;
            }
        }
        return mNumberAllChallenges;
    }

    // Get the number of the current due challenges
    public int getNumberDueChallenges() {
        return mDueChallenges.getSize();
    }

    // Get all challenges of a given class from progress_username.csv
    public int getNumberOfClass(int classNumber) {
        // Get all challenges
        mAllChallenges = ChallengeDatabase.getAllChallenges();
        ChallengeCollection challengesFromIndex = new ChallengeCollection();

        // Go through all challenges and give a collection with all challenges matching with the index
        for(int i = 0; i < mAllChallenges.getSize(); i++) {
            Challenge mChallenge = mAllChallenges.getChallenge(i);
            if(mChallenge.getmIndexCard().getmID() == mChosenFile.getmID()) {
                challengesFromIndex.addChallenge(mAllChallenges.getChallenge(i));
            }
        }

        // Load the user progress of the current user
        UserProgressCollection allProgressData = UserProgressDatabase.getUserProgresses(mActivity, mChosenUser.getName());
        int countClassOne = 0;

        // Go through all user progresses and count the matching ones
        for(int j = 0; j < allProgressData.getSize(); j++) {
            UserProgress progress = allProgressData.getUserProgress(j);
            for(int k = 0; k < challengesFromIndex.getSize(); k++) {
                if (progress.getmChallengeID() == challengesFromIndex.getChallenge(k).getmID() && progress.getmPeriodClass() == classNumber) {
                    countClassOne++;
                }
            }
        }
        return countClassOne;
    }

    // Get a ChallengeCollection containing the current due challenges
    public ChallengeCollection getDueChallenges() {
        return mDueChallenges;
    }


    // Get the current userProgress of the current user as an UserProgressCollection
    public UserProgressCollection getCurrentUserUserProgresses() {
        return mCurrentUserUserProgresses;
    }

    // Get ChallengesCollection with current Index out of all Challenges and save them as a new ChallengeCollection
    public ChallengeCollection getChallengesForSelectedIndexCard() {
        ChallengeCollection mChallengesCurrentIndexCard = new ChallengeCollection();
        for(int i=0; i<mAllChallenges.getSize(); i++) {
            if(mAllChallenges.getChallenge(i).getmIndexCard().getmID() == mChosenFile.getmID()) {
                mChallengesCurrentIndexCard.addChallenge(mAllChallenges.getChallenge(i));
            }
        }
        return mChallengesCurrentIndexCard;
    }

}