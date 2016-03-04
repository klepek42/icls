package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Edgar Klepek
 */
public class EventToListenerMapping implements View.OnClickListener {
    // Member variable
    private ApplicationLogic mApplicationLogic;

    // Constructor
    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getButtonAbort().setOnClickListener(this);
        gui.getButtonConfirmThinkAnswer().setOnClickListener(this);
    }

    // Actions to perform once a specific button has been pressed
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
