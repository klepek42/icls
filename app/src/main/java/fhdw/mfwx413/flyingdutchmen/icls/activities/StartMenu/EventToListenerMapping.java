package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import android.view.View;
import android.widget.AdapterView;

import fhdw.mfwx413.flyingdutchmen.icls.R;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;

/**
 * Created by edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max Schumacher on 20.02.2016
 */
public class EventToListenerMapping implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getButtonAddUser().setOnClickListener(this);
        gui.getButtonConfirmUser().setOnClickListener(this);
        /** Function not supported in this version of app
        gui.getButtonEditUser().setOnClickListener(this);
        */
        gui.getChooseUser().setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonAddUser:
                mApplicationLogic.onButtonAddUserClicked();
                break;
            case R.id.buttonConfirmUser:
                try {
                    mApplicationLogic.onButtonConfirmUserClicked();
                } catch (IdNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            /** Function not supported in this version of app
            case R.id.buttonEditUser:
                try {
                    mApplicationLogic.onButtonEditUserClicked();
                } catch (IdNotFoundException e) {
                    e.printStackTrace();
                }
                break;
             */
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mApplicationLogic.onUserSelected(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Spinner is always filled with init of activity, therefore method doesn't need to be filled
    }


}
