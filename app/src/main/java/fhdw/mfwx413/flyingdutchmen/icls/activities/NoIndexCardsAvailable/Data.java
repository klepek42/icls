package fhdw.mfwx413.flyingdutchmen.icls.activities.NoIndexCardsAvailable;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Max on 05.03.2016.
 * Responsibility: Max Schumacher
 * Updated by Max on 05.03.2016
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
