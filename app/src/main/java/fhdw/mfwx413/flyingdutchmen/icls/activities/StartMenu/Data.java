package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import fhdw.mfwx413.flyingdutchmen.icls.data.User;

/**
 * Created by edgar on 17.02.2016
 * Responsibility: Max
 * Updated by Max on 20.02.2016
 */

public class Data {

    private Activity mActivity;
    private User mCurrentUser;

    public Data(Activity activity, Bundle savedInstanceState) {

        mActivity = activity;

        //DEBUG
        mCurrentUser = new User(17, "Test", 1, 2, 3, 4, 5, 6);
        //eod


    }

    public User getCurrentUser() {
        //DEBUG
        Log.d("mCurrentUser: ", "" + mCurrentUser);
        //eod
        return mCurrentUser;
    }

    public Activity getActivity() {
        //DEBUG
        Log.d("mActivity: ", "" + mActivity);
        //eod
        return mActivity;
    }
}
