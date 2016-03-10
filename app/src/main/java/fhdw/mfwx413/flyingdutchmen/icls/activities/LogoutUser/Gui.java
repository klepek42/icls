package fhdw.mfwx413.flyingdutchmen.icls.activities.LogoutUser;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 01.03.2016
 */

// Gui initializes the objects from the relating layout
public class Gui {

    private TextView textFieldLogout;
    private Button buttonConfirmLogout;
    private Button buttonDenyLogout;

    // sets the connection between Gui and layout files
    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_logout_user);
        textFieldLogout = (TextView) activity.findViewById(R.id.textFieldLogout);
        buttonConfirmLogout = (Button) activity.findViewById(R.id.buttonConfirmLogout);
        buttonDenyLogout = (Button) activity.findViewById(R.id.buttonDenyLogout);
    }

    public Button getButtonConfirmLogout() {
        return buttonConfirmLogout;
    }

    public Button getButtonDenyLogout() {
        return buttonDenyLogout;
    }
}
