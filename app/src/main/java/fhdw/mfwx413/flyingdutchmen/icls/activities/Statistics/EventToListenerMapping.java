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
    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getmButtonBackToChooseFile().setOnClickListener(this);
        gui.getmButtonStartLearning().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBackToChooseFile:
                mApplicationLogic.onButtonBackToChooseFileClicked();
                break;
            case R.id.buttonStartLearning:
                try {
                    mApplicationLogic.onButtonStartLearningClicked();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IdNotFoundException e) {
                    e.printStackTrace();
                } catch (InvalidQuestionTypeLayoutException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}