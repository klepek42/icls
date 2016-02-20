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
        gui.getmButtonLogout().setOnClickListener(this);
        gui.getmButtonConfirmThinkAnswer().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonConfirmFreeAnswer:
                mApplicationLogic.onButtonConfirmFreeAnswerClicked();
                break;
            case R.id.buttonLogout:
                mApplicationLogic.onButtonLogoutClicked();
                break;
        }

    }

}
