package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import android.app.Activity;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;

/**
 * Responsibility: Edgar Klepek
 */
public class Data {
    private static final int DEFAULT_CURRENT_CHALLENGE_ID = 1;

    public Activity getActivity() {
        return mActivity;
    }

    private Activity mActivity;
    private ChallengeCollection mChallengeCollection;
    private int mCurrentChallengeId;

    public Data(Activity activity) {
        mActivity = activity;
        mChallengeCollection = ChallengeDatabase.getAllChallenges(mActivity);
        mCurrentChallengeId = DEFAULT_CURRENT_CHALLENGE_ID;
    }

    public int getmCurrentChallengeId() {
        return mCurrentChallengeId;
    }

    public ChallengeCollection getmChallengeCollection() {
        return mChallengeCollection;
    }
}
