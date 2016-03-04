package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import fhdw.mfwx413.flyingdutchmen.icls.R;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;

/**
 * Responsibility: Max Schumacher
 * Created by edgar on 17.02.2016
 * Updated by Max Schumacher on 20.02.2016
 */

public class Gui {

    private TextView textFieldStart;
    private Spinner chooseUser;
    private Button buttonAddUser;
    private Button buttonConfirmUser;
    /** Function not supported in this version of app
    private Button buttonEditUser;
    */

    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_start_menu);
        textFieldStart = (TextView) activity.findViewById(R.id.textFieldStart);
        chooseUser = (Spinner) activity.findViewById(R.id.chooseUser);
        buttonAddUser = (Button) activity.findViewById(R.id.buttonAddUser);
        buttonConfirmUser = (Button) activity.findViewById(R.id.buttonConfirmUser);
        /** Function not supported in this version of app
        buttonEditUser = (Button) activity.findViewById(R.id.buttonEditUser);
        */
    }

    public TextView getTextFieldStart() {
        return textFieldStart;
    }

    public Spinner getChooseUser() {
        return chooseUser;
    }

    public Button getButtonAddUser() {
        return buttonAddUser;
    }

    public Button getButtonConfirmUser() {
        return buttonConfirmUser;
    }

    /** Function not supported in this version of app
    public Button getButtonEditUser() {
        return buttonEditUser;
    }
    */

}