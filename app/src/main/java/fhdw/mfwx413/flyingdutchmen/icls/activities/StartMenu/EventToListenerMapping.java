package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max Schumacher on 20.02.2016
 */

public class EventToListenerMapping implements View.OnClickListener {

    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getButtonAddUser().setOnClickListener(this);
        gui.getButtonConfirmUser().setOnClickListener(this);
        gui.getButtonEditUser().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonAddUser:
                mApplicationLogic.onButtonAddUserClicked();
                break;
            case R.id.buttonConfirmUser:
                mApplicationLogic.onButtonConfirmUserClicked();
                break;
            case R.id.buttonEditUser:
                mApplicationLogic.onButtonEditUserClicked();
                break;
        }
    }
}
