package fhdw.mfwx413.flyingdutchmen.icls.activities.FragLogout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;

/**
 * Created by edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 01.03.2016
 */
public class Data {


    private Activity mActivity;
    private User mCurrentUser;

    public Data(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        mActivity = activity;
        intent = activity.getIntent();

        if (savedInstanceState == null) {
            mCurrentUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
        }
        else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public Activity getActivity() {
        return mActivity;
    }

    public User getCurrentUser() {
        return mCurrentUser;
    }

    public void saveDataFromBundle(Bundle savedInstanceState) {
        savedInstanceState.putSerializable(Constants.KEY_PARAM_CHOSEN_USER, mCurrentUser);
    }

    public void restoreDataFromBundle(Bundle savedInstanceState) {
        mCurrentUser = (User) savedInstanceState.getSerializable(Constants.KEY_PARAM_CHOSEN_USER);
    }
}
