package fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserDatabase;

/**
 * Responsibility: Daniel zur Linden
 */
//Todo Daniel: Change bundle?
public class Data {

    public Activity getActivity() {
        return mActivity;
    }

    private static final String KEY_CHOSEN_USER = "K0";

    private Activity mActivity;
    private User mChosenUser;
    private UserCollection mAllUsers;

    public Data(Activity activity, Bundle bundle) {
        Intent intent;
        mActivity = activity;
        intent = activity.getIntent();
        mAllUsers = UserDatabase.getAllUser(mActivity);

        if(bundle == null) {
            mChosenUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
        }
        else{
            //restore Data if bundle is filled
            restoreDataFromBundle(bundle);
        }
    }

    //save data in bundle if activity stops
    public void saveDataFromBundle(Bundle bundle) {
        bundle.putSerializable(KEY_CHOSEN_USER, mChosenUser);
    }

    //restore data from given bundle
    public void restoreDataFromBundle(Bundle bundle) {
        mChosenUser = (User) bundle.getSerializable(KEY_CHOSEN_USER);
    }

    public User getmChosenUser() {
        return mChosenUser;
    }

    public UserCollection getmUserCollection() {
        return mAllUsers;
    }

    public UserCollection getmAllUsers() {
        return mAllUsers;
    }

    public User getCurrentUser() {
        return mChosenUser;
    }

    public void setmCurrentUser(User mCurrentUser) {
        this.mChosenUser = mCurrentUser;
    }
}
