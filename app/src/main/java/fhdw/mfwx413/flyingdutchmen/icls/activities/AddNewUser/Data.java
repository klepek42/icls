package fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser;

import android.app.Activity;

/**
 * Created by edgar on 17.02.2016.
 */
public class Data {

    private static final String DEFAULT_CURRENT_USER = "";

    private Activity mActivity;
    //private UserCollection mUserCollection;
    private String mCurrentUser;

    public Data(Activity activity) {
        mActivity = activity;
        //mUserCollection = UserDatabase.getAllUsers();
        mCurrentUser = DEFAULT_CURRENT_USER;
    }

    public String getmCurrentUser() {
        return mCurrentUser;
    }

    /*public UserCollection getmChallengeCollection() {
        return mUserCollection;
    }*/
}
