package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.app.Activity;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;

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
    private String currentUser;
    private String getCurrentIndexCard;
    private int mPeriodClass1;
    private int mPeriodClass2;
    private int mPeriodClass3;
    private int mPeriodClass4;
    private int mPeriodClass5;
    private int mPeriodClass6;

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

    public String getCurrentUser() {
        //currentUser = User.getmName();
        return currentUser;

    }

    public String getCurrentIndexcard() {
        //getCurrentIndexCard = IndexCard.getmName();
        return getCurrentIndexCard;
    }

    //public int get


}
