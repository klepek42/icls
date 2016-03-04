package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.view.View;
import android.widget.AdapterView;

import java.text.ParseException;

import fhdw.mfwx413.flyingdutchmen.icls.R;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidQuestionTypeLayoutException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.UserProgressNotFoundException;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.12.2016
 */

public class EventToListenerMapping implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ApplicationLogic mApplicationLogic;

    public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        gui.getButtonLogout().setOnClickListener(this);
        gui.getButtonStatistics().setOnClickListener(this);
        gui.getButtonSettings().setOnClickListener(this);
        gui.getButtonStartLearning().setOnClickListener(this);
        gui.getChooseIndexCard().setOnItemSelectedListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonLogout:
                mApplicationLogic.onButtonLogoutClicked();
                break;
            case R.id.buttonStatistics:
                try {
                    mApplicationLogic.onButtonStatisticsClicked();
                } catch (ParseException | IdNotFoundException | UserProgressNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.buttonSettings:
                mApplicationLogic.onButtonSettingsClicked();
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mApplicationLogic.onIndexCardSelected(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Spinner is always filled with init of activity, therefore method doesn't need to be filled
    }
}
