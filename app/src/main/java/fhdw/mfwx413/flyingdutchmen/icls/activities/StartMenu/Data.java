package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserDatabase;

/**
 * Created by edgar on 17.02.2016
 * Responsibility: Max
 * Updated by Max on 20.02.2016
 */

public class Data {

    private Activity mActivity;
    private User mCurrentUser;
    private UserCollection mAllUsers;

    public Data(Activity activity, Bundle savedInstanceState) {

        mActivity = activity;

        mAllUsers = UserDatabase.getAllUser(mActivity);
        //DEBUG
        //mCurrentUser = new User("Test", 1, 2, 3, 4, 5, 6);
        //eod
        Log.d("mAllUsers: ", "" + mAllUsers);

    }

    public UserCollection getmAllUsers() {
        return mAllUsers;
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

    public void setmCurrentUser(User mCurrentUser) {
        this.mCurrentUser = mCurrentUser;
    }
}
