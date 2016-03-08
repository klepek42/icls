package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import fhdw.mfwx413.flyingdutchmen.icls.R;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;

/**
 * Created by Edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 20.02.2016
 * Updated by Max on 21.02.2016
 * Updated by Max on 23.02.2016
 * Updated by Max on 02.03.2016
 */

// Gui initializes the objects from the relating layout
public class Gui {

    private TextView textFieldStart;
    private Spinner chooseUser;
    private Button buttonAddUser;
    private Button buttonConfirmUser;
    /** Function not supported in this version of app
    private Button buttonEditUser;
    */

    // sets the connection between Gui and layout files
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