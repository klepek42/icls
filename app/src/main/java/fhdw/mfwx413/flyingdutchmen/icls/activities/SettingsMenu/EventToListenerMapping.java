package fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu;

import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Daniel zur Linden
 */
public class EventToListenerMapping implements View.OnClickListener {
    private fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getmButtonAbortSettings().setOnClickListener(this);
        gui.getmButtonConfirmSettings().setOnClickListener(this);
        gui.getmButtonSetSettingsDefault().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAbortSettings:
                mApplicationLogic.goBackToChooseFile();
                break;
            case R.id.buttonConfirmSettings:
                mApplicationLogic.onButtonConfirmSettingsClicked();
                break;
            case R.id.buttonSetSettingsDefault:
                mApplicationLogic.onButtonSetSettingsDefaultClicked();
                break;
        }
    }
}
