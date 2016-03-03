package fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser;

import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;

/**
 * Responsibility: Luisa Leifer
 */
public class EventToListenerMapping implements View.OnClickListener {
    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getmButtonAbortNewUser().setOnClickListener(this);
        gui.getmButtonSaveNewUser().setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.buttonAbortNewUser:
                mApplicationLogic.onButtonAbortNewUserClicked();
                break;
            case R.id.buttonSaveNewUser:
                try {
                    mApplicationLogic.onButtonSaveNewUserClicked();
                } catch (IdNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}