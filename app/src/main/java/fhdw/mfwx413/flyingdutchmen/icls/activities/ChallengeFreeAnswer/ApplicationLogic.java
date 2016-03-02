package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidCorrectAnswerTypeException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.UserProgressNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Jonas Krabs
 */
//Todo Jonas: Alle Klassen mit Verantwortlichkeit vernünftig kommentieren
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private Activity mActivity;

    public ApplicationLogic(Data data, Gui gui, Activity activity) {
        mData = data;
        mGui = gui;
        mActivity = activity;
        initialUpdateGui();
    }

    // initialize the Gui by setting the questiontext
    private void initialUpdateGui() {
        Challenge challenge;
        int currentChallengeId;

        currentChallengeId = mData.getmCurrentChallengeId();
        challenge = mData.getmDueChallengesOfUserInFile().getChallenge(currentChallengeId);

        mGui.setQuestionText(challenge.getmQuestiontext());
    }

    //method that is invoked if the confirm button is clicked
    public void onButtonConfirmFreeAnswerClicked()throws InvalidCorrectAnswerTypeException{
        int challengeId = mData.getmCurrentChallengeId();
        Challenge challenge;
        String givenAnswer;
        boolean isAnswerCorrect;

        isAnswerCorrect = false;
        //save the given question from the input textfield
        givenAnswer = mGui.getmGivenAnswer().getText().toString();

        challenge = mData.getmDueChallengesOfUserInFile().getChallenge(challengeId);

        //analyze if the given answer was correct or not
        switch (challenge.getmCorrectAnswer()){
            // if one, there only one answer saved in the challenge and this is the right one
            case 1:
                if (givenAnswer.equals(challenge.getmAnswerOne())){
                    isAnswerCorrect = true;
                }
                else {
                    isAnswerCorrect = false;
                }
                break;
            //if three, there are two answers saved in the challenge and both are right
            case 3:
                if (givenAnswer.equals(challenge.getmAnswerOne()) || givenAnswer.equals(challenge.getmAnswerTwo())){
                    isAnswerCorrect = true;
                }
                else {
                    isAnswerCorrect = false;
                }
                break;
            //if seven, there are three answers saved in the challenge and all three are right
            case 7:
                if (givenAnswer.equals(challenge.getmAnswerTwo()) || givenAnswer.equals(challenge.getmAnswerTwo()) || givenAnswer.equals(challenge.getmAnswerThree())){
                    isAnswerCorrect = true;
                }
                else {
                    isAnswerCorrect = false;
                }
                break;
            default:
                throw new InvalidCorrectAnswerTypeException("ChallengeFreeAnswer::ApplicationLogic::onButtonConfirmFreeAnswerClicked: Ungültiger Wert für CorrectAnswer: " + challenge.getmCorrectAnswer());
        }

        try {
            updateUserProgress(isAnswerCorrect);

            //call the Feedback-Activity and send the required data
            Navigation.startActivityFeedbackChallengeRest(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), isAnswerCorrect, mData.getmUserProgresses());

        }
        catch (UserProgressNotFoundException e){
            Log.e("ICLS-LOG", "ChallengeFreeAnswer::ApplicationLogic::onButtonConfirmFreeAnswerClicked: ", e);
            showErrorUnexpectedError();
            Navigation.startActivityStartMenu(mActivity);
        }
    }

    public void goBackToChooseFile() {
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
    }

    public void showErrorUnexpectedError(){
        Toast.makeText(mActivity, "Unerwarteter Fehler", Toast.LENGTH_SHORT).show();
    }

    public void updateUserProgress(boolean isAnswerCorrect) throws UserProgressNotFoundException{
        boolean userProgressFound = false;
        for (int i = 0; i < mData.getmUserProgresses().getSize(); i++){
            if (mData.getmUserProgresses().getUserProgress(i).getmChallengeID() == mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmID()){
                int actualTimeClass = mData.getmUserProgresses().getUserProgress(i).getmPeriodClass();
                userProgressFound = true;
                mData.getmUserProgresses().getUserProgress(i).setCurrentTimeStamp();
                if (isAnswerCorrect == true) {
                    if (actualTimeClass < 5 ) {
                        mData.getmUserProgresses().getUserProgress(i).setmPeriodClass(actualTimeClass + 1);
                    }
                }
                else {
                    if (actualTimeClass > 1 ) {
                        mData.getmUserProgresses().getUserProgress(i).setmPeriodClass(actualTimeClass - 1);
                    }
                }
                UserProgressDatabase.writeSpecificUserProgresses(mData.getmUserProgresses(), mData.getmChosenUser().getmName(), mActivity);
                break;
            }
        }
        if (userProgressFound == false){
            throw new UserProgressNotFoundException("ChallengeFreeAnswer::ApplicationLogic::updateUserProgress:"
                    + " CurrentUserName: " + mData.getmChosenUser().getmName()
                    + " ChallengeID:" + mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmID());
        }
    }


}
