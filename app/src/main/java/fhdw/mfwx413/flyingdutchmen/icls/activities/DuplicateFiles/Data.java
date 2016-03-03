package fhdw.mfwx413.flyingdutchmen.icls.activities.DuplicateFiles;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by edgar on 17.02.2016.
 * Updated by Max on 01.03.2016
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
