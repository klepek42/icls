package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCardCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCardDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgress;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;

/**
 * Created by edgar on 17.02.2016.
 */
public class Data {

    private Activity mActivity;
    private User mCurrentUser;
    private UserProgressCollection allUserProgresses;
    private IndexCard mCurrentIndex;
    private IndexCardCollection mAllIndexCards;

    public Data(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        mActivity = activity;
        intent = activity.getIntent();
        mCurrentUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
        Log.d("mCurrentUser", "" + mCurrentUser.getmName());
        allUserProgresses = UserProgressDatabase.getAllUserProgresses(mActivity);
        mAllIndexCards = IndexCardDatabase.getIndexCards(mActivity);
    }

    public IndexCardCollection getmAllIndexCards() {
        return mAllIndexCards;
    }

    public User getCurrentUser() {
        return mCurrentUser;
    }

    public Activity getActivity() {
        return mActivity;
    }

    public void setmCurrentIndex(IndexCard mCurrentIndex) {
        this.mCurrentIndex = mCurrentIndex;
    }

}