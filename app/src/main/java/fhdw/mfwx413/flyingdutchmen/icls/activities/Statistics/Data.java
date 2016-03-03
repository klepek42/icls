package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserCollection;
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

    public Data(Activity activity, Bundle bundle) {
        mActivity = activity;
        Intent intent;

        if(bundle == null) {
            // First start of the activity
            intent = mActivity.getIntent();
            mChosenUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
            mChosenFile = (IndexCard) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_FILE);
            mDueChallenges = (ChallengeCollection) intent.getSerializableExtra(Constants.KEY_PARAM_DUE_CHALLENGES_OF_USER_IN_FILE);
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
    }

    // Restore data from given bundle
    public void restoreDataFromBundle(Bundle bundle) {
        mChosenUser = (User) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_USER);
        mChosenFile = (IndexCard) bundle.getSerializable(Constants.BUNDLE_KEY_CHOSEN_FILE);
        mDueChallenges = (ChallengeCollection) bundle.getSerializable(Constants.BUNDLE_KEY_DUE_CHALLENGES_OF_USER_IN_FILE);
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

    // Count the number of all existing challenges of the current file
    public int getmNumberAllChallenges() {
        mAllChallenges = ChallengeDatabase.getAllChallenges(mActivity);
        for(int i = 0; i < mAllChallenges.getSize(); i++) {
            Challenge mChallenge = mAllChallenges.getChallenge(i);
            if(mChallenge.getmIndexCard().getmID() == mChosenFile.getmID()) {
                mNumberAllChallenges++;
            }
        }
        return mNumberAllChallenges;
    }

    // Get dueChallenges from Max
    public int getmNumberDueChallenges() {
        int numberDueChallenges = mDueChallenges.getSize();
        return numberDueChallenges;
    }

    // Get all challenges with class 1 from progress.csv
    public int getmNumberOfClass1() {
        // Get all challenges
        mAllChallenges = ChallengeDatabase.getAllChallenges(mActivity);
        ChallengeCollection challengesFromIndex = new ChallengeCollection();

        // Go through all challenges and give a collection with all challenges matching with the index
        for(int i = 0; i < mAllChallenges.getSize(); i++) {
            Challenge mChallenge = mAllChallenges.getChallenge(i);
            if(mChallenge.getmIndexCard().getmID() == mChosenFile.getmID()) {
                challengesFromIndex.addChallenge(mAllChallenges.getChallenge(i));
            }
        }

        UserProgressCollection allProgressData = UserProgressDatabase.getUserProgresses(mActivity, mChosenUser.getmName());
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

    // Get all challenges with class 2 from progress.csv
    public int getmNumberOfClass2() {
        // Get all challenges
        mAllChallenges = ChallengeDatabase.getAllChallenges(mActivity);
        ChallengeCollection challengesFromIndex = new ChallengeCollection();

        // Go through all challenges and give a collection with all challenges matching with the index
        for(int i = 0; i < mAllChallenges.getSize(); i++) {
            Challenge mChallenge = mAllChallenges.getChallenge(i);
            if(mChallenge.getmIndexCard().getmID() == mChosenFile.getmID()) {
                challengesFromIndex.addChallenge(mAllChallenges.getChallenge(i));
            }
        }

        UserProgressCollection allProgressData = UserProgressDatabase.getUserProgresses(mActivity, mChosenUser.getmName());
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

    // Get all challenges with class 3 from progress.csv
    public int getmNumberOfClass3() {
        // Get all challenges
        mAllChallenges = ChallengeDatabase.getAllChallenges(mActivity);
        ChallengeCollection challengesFromIndex = new ChallengeCollection();

        // Go through all challenges and give a collection with all challenges matching with the index
        for(int i = 0; i < mAllChallenges.getSize(); i++) {
            Challenge mChallenge = mAllChallenges.getChallenge(i);
            if(mChallenge.getmIndexCard().getmID() == mChosenFile.getmID()) {
                challengesFromIndex.addChallenge(mAllChallenges.getChallenge(i));
            }
        }

        UserProgressCollection allProgressData = UserProgressDatabase.getUserProgresses(mActivity, mChosenUser.getmName());
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

    // Get all challenges with class 4 from progress.csv
    public int getmNumberOfClass4() {
        // Get all challenges
        mAllChallenges = ChallengeDatabase.getAllChallenges(mActivity);
        ChallengeCollection challengesFromIndex = new ChallengeCollection();

        // Go through all challenges and give a collection with all challenges matching with the index
        for(int i = 0; i < mAllChallenges.getSize(); i++) {
            Challenge mChallenge = mAllChallenges.getChallenge(i);
            if(mChallenge.getmIndexCard().getmID() == mChosenFile.getmID()) {
                challengesFromIndex.addChallenge(mAllChallenges.getChallenge(i));
            }
        }

        UserProgressCollection allProgressData = UserProgressDatabase.getUserProgresses(mActivity, mChosenUser.getmName());
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

    // Get all challenges with class 5 from progress.csv
    public int getmNumberOfClass5() {
        // Get all challenges
        mAllChallenges = ChallengeDatabase.getAllChallenges(mActivity);
        ChallengeCollection challengesFromIndex = new ChallengeCollection();

        // Go through all challenges and give a collection with all challenges matching with the index
        for(int i = 0; i < mAllChallenges.getSize(); i++) {
            Challenge mChallenge = mAllChallenges.getChallenge(i);
            if(mChallenge.getmIndexCard().getmID() == mChosenFile.getmID()) {
                challengesFromIndex.addChallenge(mAllChallenges.getChallenge(i));
            }
        }

        UserProgressCollection allProgressData = UserProgressDatabase.getUserProgresses(mActivity, mChosenUser.getmName());
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

    // Get all challenges with class 6 from progress.csv
    public int getmNumberOfClass6() {
        // Get all challenges
        mAllChallenges = ChallengeDatabase.getAllChallenges(mActivity);
        ChallengeCollection challengesFromIndex = new ChallengeCollection();

        // Go through all challenges and give a collection with all challenges matching with the index
        for(int i = 0; i < mAllChallenges.getSize(); i++) {
            Challenge mChallenge = mAllChallenges.getChallenge(i);
            if(mChallenge.getmIndexCard().getmID() == mChosenFile.getmID()) {
                challengesFromIndex.addChallenge(mAllChallenges.getChallenge(i));
            }
        }

        UserProgressCollection allProgressData = UserProgressDatabase.getUserProgresses(mActivity, mChosenUser.getmName());
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


}