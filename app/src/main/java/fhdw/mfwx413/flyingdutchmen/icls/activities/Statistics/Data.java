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
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.UserProgressNotFoundException;

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

    public Data(Activity activity, Bundle bundle) {
        mActivity = activity;
        Intent intent;

        // First start of the activity triggers to get the data given by the previous Activity as an intent
        if(bundle == null) {
            intent = mActivity.getIntent();
            mChosenUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
            mChosenFile = (IndexCard) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_FILE);
            mDueChallenges = (ChallengeCollection) intent.getSerializableExtra(Constants.KEY_PARAM_DUE_CHALLENGES_OF_USER_IN_FILE);
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
        bundle.putSerializable(Constants.BUNDLE_KEY_CHOSEN_FILE, mChosenFile);
        bundle.putSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_OF_USER_IN_FILE, mDueChallenges);
        bundle.putSerializable(Constants.BUNDLE_KEY_USER_PROGRESS_CURRENT_USER, mCurrentUserUserProgresses);
    }

    // Restore data from given bundle
    public void restoreDataFromBundle(Bundle bundle) {
        mChosenUser = (User) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_USER);
        mChosenFile = (IndexCard) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_FILE);
        mDueChallenges = (ChallengeCollection) bundle.getSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_OF_USER_IN_FILE);
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
        mAllChallenges = ChallengeDatabase.getAllChallenges();
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

    // Get all challenges with class 1 from progress_username.csv
    public int getNumberOfClass1() {
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
                if (progress.getmChallengeID() == challengesFromIndex.getChallenge(k).getmID() && progress.getmPeriodClass() == 1) {
                    countClassOne++;
                }
            }
        }
        return countClassOne;
    }

    // Get all challenges with class 2 from progress_username.csv
    public int getNumberOfClass2() {
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
        int countClassTwo = 0;

        // Go through all user progresses and count the matching ones
        for(int j = 0; j < allProgressData.getSize(); j++) {
            UserProgress progress = allProgressData.getUserProgress(j);
            for(int k = 0; k < challengesFromIndex.getSize(); k++) {
                if (progress.getmChallengeID() == challengesFromIndex.getChallenge(k).getmID() && progress.getmPeriodClass() == 2) {
                    countClassTwo++;
                }
            }
        }
        return countClassTwo;
    }

    // Get all challenges with class 3 from progress_username.csv
    public int getNumberOfClass3() {
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
        int countClassThree = 0;

        // Go through all user progresses and count the matching ones
        for(int j = 0; j < allProgressData.getSize(); j++) {
            UserProgress progress = allProgressData.getUserProgress(j);
            for(int k = 0; k < challengesFromIndex.getSize(); k++) {
                if (progress.getmChallengeID() == challengesFromIndex.getChallenge(k).getmID() && progress.getmPeriodClass() == 3) {
                    countClassThree++;
                }
            }
        }
        return countClassThree;
    }

    // Get all challenges with class 4 from progress_username.csv
    public int getNumberOfClass4() {
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
        int countClassFour = 0;

        // Go through all user progresses and count the matching ones
        for(int j = 0; j < allProgressData.getSize(); j++) {
            UserProgress progress = allProgressData.getUserProgress(j);
            for(int k = 0; k < challengesFromIndex.getSize(); k++) {
                if (progress.getmChallengeID() == challengesFromIndex.getChallenge(k).getmID() && progress.getmPeriodClass() == 4) {
                    countClassFour++;
                }
            }
        }
        return countClassFour;
    }

    // Get all challenges with class 5 from progress_username.csv
    public int getNumberOfClass5() {
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
        int countClassFive = 0;

        // Go through all user progresses and count the matching ones
        for(int j = 0; j < allProgressData.getSize(); j++) {
            UserProgress progress = allProgressData.getUserProgress(j);
            for(int k = 0; k < challengesFromIndex.getSize(); k++) {
                if (progress.getmChallengeID() == challengesFromIndex.getChallenge(k).getmID() && progress.getmPeriodClass() == 5) {
                    countClassFive++;
                }
            }
        }
        return countClassFive;
    }

    // Get all challenges with class 6 from progress_username.csv
    public int getNumberOfClass6() {
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
        int countClassSix = 0;

        // Go through all user progresses and count the matching ones
        for(int j = 0; j < allProgressData.getSize(); j++) {
            UserProgress progress = allProgressData.getUserProgress(j);
            for(int k = 0; k < challengesFromIndex.getSize(); k++) {
                if (progress.getmChallengeID() == challengesFromIndex.getChallenge(k).getmID() && progress.getmPeriodClass() == 6) {
                    countClassSix++;
                }
            }
        }
        return countClassSix;
    }

    // Get a ChallengeCollection containing the current due challenges
    public ChallengeCollection getDueChallenges() {
        return mDueChallenges;
    }


    // Get the current userProgress of the current user as an UserProgressCollection
    public UserProgressCollection getCurrentUserUserProgresses() {
        return mCurrentUserUserProgresses;
    }

    // I. -> Get ChallengesCollection with current Index out of all Challenges and save them as a new ChallengeCollection L1
    public ChallengeCollection getChallengesForSelectedIndexCard() {
        ChallengeCollection mChallengesCurrentIndexCard = new ChallengeCollection();
        for(int i=0; i<mAllChallenges.getSize(); i++) {
            if(mAllChallenges.getChallenge(i).getmIndexCard().getmID() == mChosenFile.getmID()) {
                mChallengesCurrentIndexCard.addChallenge(mAllChallenges.getChallenge(i));
            }
        }
        return mChallengesCurrentIndexCard;
    }

    // II. -> Get UserProgressCollection with current Index Card out of CurrentUserUserProgress and save them as a new UserProgressCollection L2
    public UserProgressCollection getUserProgressForCurrentIndexCard() throws UserProgressNotFoundException {
        UserProgressCollection mCurrentUserUserProgressForCurrentIndexCard = new UserProgressCollection();

        for(int i=0; i< mCurrentUserUserProgresses.getSize(); i++){
            for(int j=0; j<getChallengesForSelectedIndexCard().getSize(); j++) {
                if(mCurrentUserUserProgresses.getUserProgress(i).getmChallengeID() == getChallengesForSelectedIndexCard().getChallenge(j).getmID()) {
                    mCurrentUserUserProgressForCurrentIndexCard.addUserProgress(mCurrentUserUserProgresses.getUserProgress(i));
                }
            }
        }
        if (mCurrentUserUserProgressForCurrentIndexCard.getSize() == 0){
            throw new UserProgressNotFoundException("Fehler beim Erstellen von CurrentUserUserProgressForCurrentIndexCard");
        }
        return mCurrentUserUserProgressForCurrentIndexCard;
    }

}