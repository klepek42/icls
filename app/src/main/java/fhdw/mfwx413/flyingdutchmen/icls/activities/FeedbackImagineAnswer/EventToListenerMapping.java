package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer;

import android.view.View;
import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Pascal Heß
 */

public class EventToListenerMapping implements View.OnClickListener {
    private ApplicationLogic mApplicationLogic;

    //Constructor
    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        //gui elements are equipped with listeners
        gui.getmButtonWasAnswerCorrect().setOnClickListener(this);
        gui.getmButtonWasAnswerWrong().setOnClickListener(this);
    }

    //define the actions that are performed, if a specific button has been pressed
    //so it depends on the clicked button, which method in the ApplicationLogic is called
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonWasAnswerCorrect:
                mApplicationLogic.onButtonWasAnswerCorrect();
                break;
            case R.id.buttonWasAnswerWrong:
                mApplicationLogic.onButtonWasAnswerWrong();
                break;
        }
    }
}
