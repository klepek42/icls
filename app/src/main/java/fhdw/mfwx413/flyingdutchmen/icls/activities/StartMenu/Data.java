package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

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

        // If there is no existing user, go directly to the ActivityAddNewUser
        if(mAllUsers.getSize()==0) {
            Navigation.startActivityAddNewUser(getActivity());
        }
    }

    public UserCollection getAllUsers() {
        return mAllUsers;
    }

    public User getCurrentUser() {
        return mCurrentUser;
    }

    public Activity getActivity() {
        return mActivity;
    }

    public void setCurrentUser(User mCurrentUser) {
        this.mCurrentUser = mCurrentUser;
    }
}
