package fhdw.mfwx413.flyingdutchmen.icls.activities.DuplicateFiles;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by Edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 03.03.2016
 */
public class Gui {

    private TextView textFieldDuplicatesWarning;
    private TextView textFieldDuplicatesDescription;
    private Button buttonOk;

    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_duplicate_files);
        textFieldDuplicatesDescription = (TextView) activity.findViewById(R.id.textFieldDuplicateIndexCardsWarning);
        textFieldDuplicatesWarning = (TextView) activity.findViewById(R.id.textFieldDuplicateIndexCardsDescription);
        buttonOk = (Button) activity.findViewById(R.id.buttonOk);
    }

    public TextView getTextFieldDuplicatesWarning() {
        return textFieldDuplicatesWarning;
    }

    public TextView getTextFieldDuplicatesDescription() {
        return textFieldDuplicatesDescription;
    }

    public Button getButtonOk() {
        return buttonOk;
    }
}
