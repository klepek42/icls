package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by edgar on 13.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 20.02.2016
 * Updated by Max on 21.02.2016
 * Updated by Max on 22.02.2016
 * Updated by Max on 24.02.2016
 * Updated by Max on 27.02.2016
 * Updated by Max on 01.03.2016
 */

// Gui initializes the objects from the relating layout
public class Gui {

    private TextView textFieldChooseFile;
    private Button buttonStatistics;
    private Button buttonLogout;
    private Button buttonSettings;
    private Button buttonStartLearning;
    private Spinner chooseIndexCard;

    // sets the connection between Gui and layout files
    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_choose_file);
        textFieldChooseFile = (TextView) activity.findViewById(R.id.textFieldChooseFile);
        chooseIndexCard = (Spinner) activity.findViewById(R.id.chooseRegister);
        buttonStatistics = (Button) activity.findViewById(R.id.buttonStatistics);
        buttonLogout = (Button) activity.findViewById(R.id.buttonLogout);
        buttonSettings = (Button) activity.findViewById(R.id.buttonSettings);
        buttonStartLearning = (Button) activity.findViewById(R.id.buttonStartLearning);
    }

    public TextView getTextFieldChooseFile() {
        return textFieldChooseFile;
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

    public Spinner getChooseIndexCard() {
        return chooseIndexCard;
    }

}