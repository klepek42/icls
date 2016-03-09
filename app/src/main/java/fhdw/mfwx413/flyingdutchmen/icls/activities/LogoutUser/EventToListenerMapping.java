package fhdw.mfwx413.flyingdutchmen.icls.activities.LogoutUser;

import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by Edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 01.03.2016
 */

// EventToListenerMapping connects the objects from Gui with the events of application logic
public class EventToListenerMapping implements View.OnClickListener {

    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getButtonConfirmLogout().setOnClickListener(this);
        gui.getButtonDenyLogout().setOnClickListener(this);
    }

    // onClick defines what methods of application logic are called after a certain user-interaction
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonConfirmLogout:
                mApplicationLogic.onButtonConfirmLogoutClicked();
                break;
            case R.id.buttonDenyLogout:
                mApplicationLogic.onButtonDenyLogoutClicked();
                break;
        }
    }
}
