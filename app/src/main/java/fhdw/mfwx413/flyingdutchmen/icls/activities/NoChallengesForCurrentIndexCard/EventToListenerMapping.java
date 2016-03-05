package fhdw.mfwx413.flyingdutchmen.icls.activities.NoChallengesForCurrentIndexCard;

import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by Max on 02.03.2016.
 * Responsibility: Max Schumacher
 * Updated by Max on 02.03.2016
 */
public class EventToListenerMapping implements View.OnClickListener {

    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getButtonOk2().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonOk2:
                mApplicationLogic.onButtonOk2Clicked();
                break;
        }
    }
}
