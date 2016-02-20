package fhdw.mfwx413.flyingdutchmen.icls.utilities;

import android.app.Activity;
import android.content.Intent;

import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.12.2016: startActivityAddNewUser
 */
public class Navigation {

    public static void startActivityAddNewUser(Activity callingActivity) {
        Intent intent;

        intent = new Intent(callingActivity, fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

}
