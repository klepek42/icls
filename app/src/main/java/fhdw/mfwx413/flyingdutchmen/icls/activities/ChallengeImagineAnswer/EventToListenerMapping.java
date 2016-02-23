package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Edgar Klepek
 */
public class EventToListenerMapping implements View.OnClickListener {
    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getmButtonAbort().setOnClickListener(this);
        gui.getmButtonConfirmThinkAnswer().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonConfirmThinkAnswer:
                mApplicationLogic.onButtonConfirmThinkAnswerClicked();
                break;
            case R.id.buttonAbort:
                mApplicationLogic.onButtonAbortClicked();
                break;
        }

    }

}
