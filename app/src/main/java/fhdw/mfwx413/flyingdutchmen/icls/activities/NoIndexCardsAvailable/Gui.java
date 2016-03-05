package fhdw.mfwx413.flyingdutchmen.icls.activities.NoIndexCardsAvailable;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by Max on 05.03.2016.
 * Responsibility: Max Schumacher
 * Updated by Max on 05.03.2016
 */

// Gui initializes the objects from the relating layout
public class Gui {

    private TextView textFieldNoIndexCardsWarning;
    private TextView textFieldNoIndexCardsDescription;
    private Button buttonOk3;

    // sets the connection between Gui and layout files
    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_no_index_cards);
        textFieldNoIndexCardsWarning = (TextView) activity.findViewById(R.id.textFieldNoIndexCardsWarning);
        textFieldNoIndexCardsDescription = (TextView) activity.findViewById(R.id.textFieldNoIndexCardsDescription);
        buttonOk3 = (Button) activity.findViewById(R.id.buttonOk3);
    }

    public TextView getTextFieldNoIndexCardsWarning() {
        return textFieldNoIndexCardsWarning;
    }

    public TextView getTextFieldNoIndexCardsDescription() {
        return textFieldNoIndexCardsDescription;
    }

    public Button getButtonOk3() {
        return buttonOk3;
    }
}
