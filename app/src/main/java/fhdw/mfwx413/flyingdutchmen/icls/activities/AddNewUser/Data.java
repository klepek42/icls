package fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser;

import android.app.Activity;

import fhdw.mfwx413.flyingdutchmen.icls.data.UserCollection;

/**
 * Responsibility: Luisa Leifer
 */
public class Data {

    private static final String DEFAULT_GIVEN_USER = "";

    private Activity mActivity;
    private UserCollection mUserCollection;
    private String mGivenUser;

    public Data(Activity activity) {
        mActivity = activity;
        //mUserCollection = UserDatabase.getAllUsers();
        mGivenUser = DEFAULT_GIVEN_USER;
    }

    public String getmGivenUser() {
        return mGivenUser;
    }

    public Activity getActivity() {
        return mActivity;
    }

    /*public UserCollection getmUserCollection() {
        return mUserCollection;
    }*/
}
