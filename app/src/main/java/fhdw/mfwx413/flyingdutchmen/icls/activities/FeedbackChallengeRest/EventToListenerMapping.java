package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackChallengeRest;

import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;

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
        switch (v.getId())
        {
            case R.id.buttonLogout:
                mApplicationLogic.onButtonAbortClicked();
                break;
            case R.id.buttonStatistics:
                mApplicationLogic.onButtonContinue();
                break;
        }
    }
}
