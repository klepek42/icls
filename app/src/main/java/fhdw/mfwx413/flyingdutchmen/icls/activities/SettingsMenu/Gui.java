package fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Daniel zur Linden
 */
public class Gui {
    //set Gui elements
    private final EditText mPeriodClass1;
    private final EditText mPeriodClass2;
    private final EditText mPeriodClass3;
    private final EditText mPeriodClass4;
    private final EditText mPeriodClass5;
    private final EditText mPeriodClass6;
    private final Spinner mDropDownSetTimeUnit1;
    private final Spinner mDropDownSetTimeUnit2;
    private final Spinner mDropDownSetTimeUnit3;
    private final Spinner mDropDownSetTimeUnit4;
    private final Spinner mDropDownSetTimeUnit5;
    private final Spinner mDropDownSetTimeUnit6;
    private final Button mButtonAbortSettings;
    private final Button mButtonConfirmSettings;
    private final Button mButtonSetSettingsDefault;

    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_settings_menu);
        mPeriodClass1 = (EditText) activity.findViewById(R.id.periodClass1);
        mPeriodClass2 = (EditText) activity.findViewById(R.id.periodClass2);
        mPeriodClass3 = (EditText) activity.findViewById(R.id.periodClass3);
        mPeriodClass4 = (EditText) activity.findViewById(R.id.periodClass4);
        mPeriodClass5 = (EditText) activity.findViewById(R.id.periodClass5);
        mPeriodClass6 = (EditText) activity.findViewById(R.id.periodClass6);
        mDropDownSetTimeUnit1 = (Spinner) activity.findViewById(R.id.dropDownSetTimeUnit1);
        mDropDownSetTimeUnit2 = (Spinner) activity.findViewById(R.id.dropDownSetTimeUnit2);
        mDropDownSetTimeUnit3 = (Spinner) activity.findViewById(R.id.dropDownSetTimeUnit3);
        mDropDownSetTimeUnit4 = (Spinner) activity.findViewById(R.id.dropDownSetTimeUnit4);
        mDropDownSetTimeUnit5 = (Spinner) activity.findViewById(R.id.dropDownSetTimeUnit5);
        mDropDownSetTimeUnit6 = (Spinner) activity.findViewById(R.id.dropDownSetTimeUnit6);
        mButtonAbortSettings = (Button) activity.findViewById(R.id.buttonAbortSettings);
        mButtonConfirmSettings = (Button) activity.findViewById(R.id.buttonConfirmSettings);
        mButtonSetSettingsDefault = (Button) activity.findViewById(R.id.buttonSetSettingsDefault);


    }

    public EditText getmPeriodClass1() {
        return mPeriodClass1;
    }

    public EditText getmPeriodClass2() {
        return mPeriodClass2;
    }

    public EditText getmPeriodClass3() {
        return mPeriodClass3;
    }

    public EditText getmPeriodClass4() {
        return mPeriodClass4;
    }

    public EditText getmPeriodClass5() {
        return mPeriodClass5;
    }

    public EditText getmPeriodClass6() {
        return mPeriodClass6;
    }

    public Spinner getTimeUnit1() {
        return mDropDownSetTimeUnit1;
    }

    public Spinner getTimeUnit2() {
        return mDropDownSetTimeUnit2;
    }

    public Spinner getTimeUnit3() {
        return mDropDownSetTimeUnit3;
    }

    public Spinner getTimeUnit4() {
        return mDropDownSetTimeUnit4;
    }

    public Spinner getTimeUnit5() {
        return mDropDownSetTimeUnit5;
    }

    public Spinner getTimeUnit6() {
        return mDropDownSetTimeUnit6;
    }

    public Button getmButtonAbortSettings() {
        return mButtonAbortSettings;
    }

    public Button getmButtonConfirmSettings() {
        return mButtonConfirmSettings;
    }

    public Button getmButtonSetSettingsDefault() {
        return mButtonSetSettingsDefault;
    }


}
