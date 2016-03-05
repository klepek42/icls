package fhdw.mfwx413.flyingdutchmen.icls.activities.FragLogout;

import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by Edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 01.03.2016
 */
public class EventToListenerMapping implements View.OnClickListener {

    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getButtonConfirmLogout().setOnClickListener(this);
        gui.getButtonDenyLogout().setOnClickListener(this);
    }

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
