package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import android.app.Activity;
import android.widget.Toast;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Jonas Krabs
 */
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
    public void onButtonConfirmFreeAnswerClicked(){
        int challengeId = mData.getmCurrentChallengeId();
        Challenge challenge;
        String givenAnswer;
        boolean isAnswerCorrect;

        isAnswerCorrect = false;
        //save the given question from the input textfield
        givenAnswer = mGui.getmGivenAnswer().getText().toString();

        challenge = mData.getmDueChallengesOfUserInFile().getChallenge(challengeId);

        //analyze if the given answer was correct or not
        switch (challenge.getMcorrectAnswer()){
            // if one, there only one answer saved in the challenge and this is the right one
            //Todo Jonas: Testausgaben entfernen (erst wenn Feedback soweit realisiert ist)
            case 1:
                if (givenAnswer.equals(challenge.getmAnswerOne())){
                    System.out.println("Die Antwort ist korrekt!");
                    isAnswerCorrect = true;
                }
                else {
                    System.out.println("Die Antwort ist leider falsch");
                    System.out.println("givenAnswer: " + givenAnswer);
                    System.out.println("hinterlegte Antwort: " + challenge.getmAnswerOne());
                    isAnswerCorrect = false;
                }
                break;
            //if three, there are two answers saved in the challenge and both are right
            case 3:
                if (givenAnswer.equals(challenge.getmAnswerOne()) || givenAnswer.equals(challenge.getmAnswerTwo())){
                    System.out.println("Die Antwort ist korrekt!");
                    isAnswerCorrect = true;
                }
                else {
                    System.out.println("Die Antwort ist leider falsch");
                    isAnswerCorrect = false;
                }
                break;
            //if seven, there are three answers saved in the challenge and all three are right
            case 7:
                if (givenAnswer.equals(challenge.getmAnswerTwo()) || givenAnswer.equals(challenge.getmAnswerTwo()) || givenAnswer.equals(challenge.getmAnswerThree())){
                    System.out.println("Die Antwort ist korrekt!");
                    isAnswerCorrect = true;
                }
                else {
                    System.out.println("Die Antwort ist leider falsch");
                    isAnswerCorrect = false;
                }
                break;
            default: System.out.println("Fatal Error");
                Toast.makeText(mActivity, "Unerwarteter Wert in CorrectAnswer", Toast.LENGTH_SHORT).show();
                mActivity.finish();
        }

      //Todo Jonas: Aufrufen des Feedbacks bei Bestätigung der Antwort
      //call the Feedback-Activity and send the required data
      //  Navigation.startActivityFeedbackChallengeRest(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), isAnswerCorrect);

    }

    public void onButtonAbortClicked() {
        //Todo Jonas: realisieren des LogOut-Buttons; Aufruf der Karteiauswahl
    }


}
