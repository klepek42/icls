package fhdw.mfwx413.flyingdutchmen.icls.activities.NoChallengesForCurrentIndexCard;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by edgar on 17.02.2016.
 */
public class Gui {

    private TextView textFieldWarning;
    private Button buttonOk2;


    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_no_challenges_for_current_index_card);
        textFieldWarning = (TextView) activity.findViewById(R.id.textFieldNoChallengesAvailable);
        buttonOk2 = (Button) activity.findViewById(R.id.buttonOk2);
    }

    public TextView getTextFieldWarning() {
        return textFieldWarning;
    }

    public Button getButtonOk2() {
        return buttonOk2;
    }

}
