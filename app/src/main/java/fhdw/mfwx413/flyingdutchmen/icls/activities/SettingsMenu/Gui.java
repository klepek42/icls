package fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Daniel zur Linden
 */
public class Gui {

    private TextView mTextFieldSettingsMenu;
    private TextView mTextFieldPeriodClass1;
    private TextView mTextFieldPeriodClass2;
    private TextView mTextFieldPeriodClass3;
    private TextView mTextFieldPeriodClass4;
    private TextView mTextFieldPeriodClass5;
    private TextView mTextFieldPeriodClass6;
    private EditText mPeriodClass1;
    private EditText mPeriodClass2;
    private EditText mPeriodClass3;
    private EditText mPeriodClass4;
    private EditText mPeriodClass5;
    private EditText mPeriodClass6;
    private Spinner mDropDownSetTimeUnit1;
    private Spinner mDropDownSetTimeUnit2;
    private Spinner mDropDownSetTimeUnit3;
    private Spinner mDropDownSetTimeUnit4;
    private Spinner mDropDownSetTimeUnit5;
    private Spinner mDropDownSetTimeUnit6;
    private Button mButtonAbortSettings;
    private Button mButtonConfirmSettings;
    private Button mButtonSetSettingsDefault;

    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_settings_menu);
        mTextFieldSettingsMenu = (TextView) activity.findViewById(R.id.textFieldSettingsMenu);
        mTextFieldPeriodClass1 = (TextView) activity.findViewById(R.id.textFieldPeriodClass1);
        mTextFieldPeriodClass2 = (TextView) activity.findViewById(R.id.textFieldPeriodClass2);
        mTextFieldPeriodClass3 = (TextView) activity.findViewById(R.id.textFieldPeriodClass3);
        mTextFieldPeriodClass4 = (TextView) activity.findViewById(R.id.textFieldPeriodClass4);
        mTextFieldPeriodClass5 = (TextView) activity.findViewById(R.id.textFieldPeriodClass5);
        mTextFieldPeriodClass6 = (TextView) activity.findViewById(R.id.textFieldPeriodClass6);
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

    //Set settings heading
    public void setmTextFieldSettingsMenu(String text) {
        mTextFieldSettingsMenu.setText(text);
    }

    public TextView getmTextFieldSettingsMenu() {

        return mTextFieldSettingsMenu;
    }

    public TextView getmTextFieldPeriodClass1() {
        return mTextFieldPeriodClass1;
    }

    public TextView getmTextFieldPeriodClass2() {
        return mTextFieldPeriodClass2;
    }

    public TextView getmTextFieldPeriodClass3() {
        return mTextFieldPeriodClass3;
    }

    public TextView getmTextFieldPeriodClass4() {
        return mTextFieldPeriodClass4;
    }

    public TextView getmTextFieldPeriodClass5() {
        return mTextFieldPeriodClass5;
    }

    public TextView getmTextFieldPeriodClass6() {
        return mTextFieldPeriodClass6;
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
