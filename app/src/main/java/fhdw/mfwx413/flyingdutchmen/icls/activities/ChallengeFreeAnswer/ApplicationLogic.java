package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;

/**
 * Responsibility: Jonas Krabs
 */
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initialUpdateGui();
    }

    private void initialUpdateGui() {
        Challenge challenge;
        int currentChallengeId;

        currentChallengeId = mData.getmCurrentChallengeId();
        challenge = mData.getmDueChallengesOfUserInFile().getChallenge(currentChallengeId);

        mGui.setQuestionText(challenge.getmQuestiontext());
    }

    public void onButtonConfirmFreeAnswerClicked(){
        int challengeId = mData.getmCurrentChallengeId();
        Challenge challenge;
        String givenAnswer;
        boolean isAnswerCorrect;

        givenAnswer = mGui.getmGivenAnswer().getText().toString();
        challenge = mData.getmDueChallengesOfUserInFile().getChallenge(challengeId);

        switch (challenge.getMcorrectAnswer()){
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
        }

    }

    public void onButtonLogoutClicked(){

    }

    //Todo zurücktaste realisieren


}
