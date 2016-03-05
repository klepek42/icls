package fhdw.mfwx413.flyingdutchmen.icls.activities.DuplicateIndexCards;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 03.03.2016
 */

// Data initializes all the data that is relevant in the current activity
public class Data {


    private Activity mActivity;

    public Data(Activity activity, Bundle savedInstanceState) {
        mActivity = activity;

    }

    public Activity getActivity() {
        return mActivity;
    }

}
