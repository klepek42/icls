package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgress;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;

/**
 * Created by edgar on 17.02.2016.
 */
public class Data {

    public Activity getActivity() {
        return mActivity;
    }

    private Activity mActivity;
    private User mCurrentUser;
    private UserProgressCollection allUserProgresses;

    public Data(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        mActivity = activity;
        intent = activity.getIntent();
        mCurrentUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
        allUserProgresses = UserProgressDatabase.getAllUserProgresses(mActivity);
    }

}