package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;

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
                mApplicationLogic.onButtonStartLearning();
                break;
        }
    }

}