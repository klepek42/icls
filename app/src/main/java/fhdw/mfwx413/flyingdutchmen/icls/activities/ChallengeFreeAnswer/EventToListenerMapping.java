package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Jonas Krabs
 */
public class EventToListenerMapping implements View.OnClickListener{
    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getmButtonConfirmFreeAnswer().setOnClickListener(this);
        gui.getmButtonAbort().setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.buttonConfirmFreeAnswer:
                mApplicationLogic.onButtonConfirmFreeAnswerClicked();
                break;
            case R.id.buttonAbort:
                mApplicationLogic.onButtonAbortClicked();
                break;
            //Todo Jonas: ZurückButton realisieren
        }
    }
}
