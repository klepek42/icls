package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer;

import android.view.View;
import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Resposibility: Pascal Heß
 */

public class EventToListenerMapping implements View.OnClickListener {
    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getmButtonWasAnswerCorrect().setOnClickListener(this);
        gui.getmButtonWasAnswerWrong().setOnClickListener(this);
    }

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
