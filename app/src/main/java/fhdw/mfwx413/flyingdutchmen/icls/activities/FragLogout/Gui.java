package fhdw.mfwx413.flyingdutchmen.icls.activities.FragLogout;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by edgar on 17.02.2016.
 */
public class Gui {

    private TextView textFieldLogout;
    private Button buttonConfirmLogout;
    private Button buttonDenyLogout;

    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_logout);
        textFieldLogout = (TextView) activity.findViewById(R.id.textFieldLogout);
        buttonConfirmLogout = (Button) activity.findViewById(R.id.buttonConfirmLogout);
        buttonDenyLogout = (Button) activity.findViewById(R.id.buttonDenyLogout);
    }

    public TextView getTextFieldLogout() {
        return textFieldLogout;
    }

    public Button getButtonConfirmLogout() {
        return buttonConfirmLogout;
    }

    public Button getButtonDenyLogout() {
        return buttonDenyLogout;
    }
}
