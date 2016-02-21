package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by edgar on 17.02.2016.
 * Updated by Max on 20.12.2016
 */

public class Gui {

    private TextView textFieldChooseFile;
    private Spinner chooseRegister;
    private Button buttonStatistics;
    private Button buttonLogout;
    private Button buttonSettings;
    private Button buttonStartLearning;
    private Spinner files;

    public Gui(Activity activity) {
        textFieldChooseFile = (TextView) activity.findViewById(R.id.textFieldChooseFile);
        chooseRegister = (Spinner) activity.findViewById(R.id.chooseRegister);
        buttonStatistics = (Button) activity.findViewById(R.id.buttonStatistics);
        buttonLogout = (Button) activity.findViewById(R.id.buttonLogout);
        buttonSettings = (Button) activity.findViewById(R.id.buttonSettings);
        buttonStartLearning = (Button) activity.findViewById(R.id.buttonStartLearning);
    }

    public TextView getTextFieldChooseFile() {
        return textFieldChooseFile;
    }

    public Spinner getChooseRegister() {
        return chooseRegister;
    }

    public Button getButtonStatistics() {
        return buttonStatistics;
    }

    public Button getButtonLogout() {
        return buttonLogout;
    }

    public Button getButtonSettings() {
        return buttonSettings;
    }

    public Button getButtonStartLearning() {
        return buttonStartLearning;
    }

    public Spinner getFiles() {
        return files;
    }

}