package fhdw.mfwx413.flyingdutchmen.icls.activities.DuplicateFiles;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 03.03.2016
 */
public class Data {


    private Activity mActivity;

    public Data(Activity activity, Bundle savedInstanceState) {
        mActivity = activity;

    }

    public Activity getActivity() {
        return mActivity;
    }

}
