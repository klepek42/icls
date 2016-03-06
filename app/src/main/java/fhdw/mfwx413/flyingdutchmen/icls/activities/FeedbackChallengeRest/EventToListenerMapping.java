package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackChallengeRest;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import fhdw.mfwx413.flyingdutchmen.icls.R;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidQuestionTypeLayoutException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Pascal Heß
 */

public class EventToListenerMapping implements View.OnClickListener {
    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getmButtonContinue().setOnClickListener(this);
        gui.getmButtonAbort().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAbort:
                mApplicationLogic.onButtonAbortClicked();
                break;
            case R.id.buttonContinue:
                mApplicationLogic.onButtonContinue();
                break;
                }
        }
    }

