package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import android.util.Log;
import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidCorrectAnswerTypeException;

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
                try {
                    mApplicationLogic.onButtonConfirmFreeAnswerClicked();
                }
                catch (InvalidCorrectAnswerTypeException e){
                    Log.e("ICLS-ERROR", "ChallengeFreeAnswer::EventToListenerMapping::onClick ", e);
                    mApplicationLogic.showErrorToastOfInvalidAnswerType();
                    mApplicationLogic.goBackToChooseFile();
                }
                break;
            case R.id.buttonAbort:
                mApplicationLogic.goBackToChooseFile();
                break;
        }
    }
}
