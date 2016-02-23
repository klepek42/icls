package fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser;

import android.app.Activity;

import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserCollection;

/**
 * Responsibility: Luisa Leifer
 */
public class Data {

    private Activity mActivity;
    private UserCollection mUserCollection;
    private User mGivenUser;

    public Data(Activity activity) {
        mActivity = activity;
        //mUserCollection = UserDatabase.getAllUsers();
        //mGivenUser = DEFAULT_GIVEN_USER;
    }

    public User getmGivenUser() {
        return mGivenUser;
    }

    public Activity getActivity() {
        return mActivity;
    }

    /*public UserCollection getmUserCollection() {
        return mUserCollection;
    }*/
}
