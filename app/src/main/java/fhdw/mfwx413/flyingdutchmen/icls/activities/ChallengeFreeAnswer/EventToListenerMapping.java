package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import android.util.Log;
import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidCorrectAnswerTypeException;

/**
 * Responsibility: Jonas Krabs
 */
public class EventToListenerMapping implements View.OnClickListener{
    private final ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        //equip the gui elements with listeners
        gui.getmButtonConfirmFreeAnswer().setOnClickListener(this);
        gui.getmButtonAbort().setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            //calling the methods in ApplicationLogic depending on which button was clicked
            case R.id.buttonConfirmFreeAnswer:
                try {
                    mApplicationLogic.onButtonConfirmFreeAnswerClicked();
                }
                //if there was a invalid answertype deposited in the answered challenge the Activity ChooseFile will be started
                catch (InvalidCorrectAnswerTypeException e){
                    Log.e("ICLS-ERROR", "ChallengeFreeAnswer::EventToListenerMapping::onClick ", e);
                    mApplicationLogic.showErrorUnexpectedError();
                    mApplicationLogic.goBackToChooseFile();
                }
                break;
            case R.id.buttonAbort:
                mApplicationLogic.goBackToChooseFile();
                break;
        }
    }
}
