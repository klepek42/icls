package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import android.app.Activity;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;

/**
 * Responsibility: Jonas Krabs
 */
public class Data {

    private static final int DEFAULT_CURRENT_CHALLENGE_ID = 2;

    private Activity mActivity;
    private ChallengeCollection mChallengeCollection;
    private int mCurrentChallengeId;

    public Data(Activity activity) {
        mActivity = activity;
        mChallengeCollection = ChallengeDatabase.getAllChallenges();
        mCurrentChallengeId = DEFAULT_CURRENT_CHALLENGE_ID;
    }

    public int getmCurrentChallengeId() {
        return mCurrentChallengeId;
    }

    public ChallengeCollection getmChallengeCollection() {
        return mChallengeCollection;
    }
}
