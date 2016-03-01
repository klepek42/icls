package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice;

import android.util.Log;
import android.view.View;

import fhdw.mfwx413.flyingdutchmen.icls.R;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidCorrectAnswerTypeException;

/**
 * Responsibility: Daniel zur Linden
 */
    public class EventToListenerMapping implements View.OnClickListener{
        private fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.ApplicationLogic mApplicationLogic;

        public EventToListenerMapping(fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Gui gui, ApplicationLogic applicationLogic) {
            mApplicationLogic = applicationLogic;
            gui.getmButtonConfirmAnswer().setOnClickListener(this);
            gui.getmCheckBoxAnswer1().setOnClickListener(this);
            gui.getmCheckBoxAnswer2().setOnClickListener(this);
            gui.getmCheckBoxAnswer3().setOnClickListener(this);
            gui.getmButtonAbort().setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            switch (v.getId()) {
                case R.id.buttonConfirmAnswer:
                    try {
                        mApplicationLogic.onButtonConfirmAnswerClicked();
                    } catch (InvalidCorrectAnswerTypeException e) {
                        Log.e("ICLS-ERROR", "ChallengeFreeAnswer::EventToListenerMapping::onClick ", e);
                        mApplicationLogic.showErrorUnexpectedError();
                        mApplicationLogic.goBackToChooseFile();
                    }
                    break;
                case R.id.buttonAbort:
                    mApplicationLogic.goBackToChooseFile();
                    break;
                case R.id.checkboxAnswer1:
                    mApplicationLogic.onCheckBoxAnswer1Clicked();
                    break;
                case R.id.checkboxAnswer2:
                    mApplicationLogic.onCheckBoxAnswer2Clicked();
                    break;
                case R.id.checkboxAnswer3:
                    mApplicationLogic.onCheckBoxAnswer3Clicked();
                    break;
            }
        }
    }


