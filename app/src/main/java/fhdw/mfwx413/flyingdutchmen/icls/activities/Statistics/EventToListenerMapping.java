package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.view.View;

import java.text.ParseException;

import fhdw.mfwx413.flyingdutchmen.icls.R;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidQuestionTypeLayoutException;

/**
 * Responsibility: Edgar Klepek
 */
public class EventToListenerMapping implements View.OnClickListener {

    // Member variable
    private ApplicationLogic mApplicationLogic;

    // Constructor
    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getButtonBackToChooseFile().setOnClickListener(this);
        gui.getButtonStartLearning().setOnClickListener(this);
    }

    // Handle which actions have to be performed once a specific button has been clicked
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBackToChooseFile:
                mApplicationLogic.onButtonBackToChooseFileClicked();
                break;
            case R.id.buttonStartLearning:
                try {
                    mApplicationLogic.onButtonStartLearningClicked();
                } catch (ParseException | IdNotFoundException | InvalidQuestionTypeLayoutException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}