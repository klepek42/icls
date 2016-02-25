package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.io.Serializable;

/**
 * Responsibility: Jonas Krabs
 */
public class Challenge implements Serializable{

    private int mID;
    private String mQuestiontext;
    private String mAnswerOne;
    private String mAnswerTwo;
    private String mAnswerThree;
    private int mCorrectAnswer;
    private int mQuestionTypeLayout;
    private IndexCard mIndexCard;

    public Challenge(int mID, String mQuestiontext, String mAnswerOne, String mAnswerTwo, String mAnswerThree, int mCorrectAnswer, int mQuestionTypeLayout, IndexCard mIndexCard) {
        this.mID = mID;
        this.mQuestiontext = mQuestiontext;
        this.mAnswerOne = mAnswerOne;
        this.mAnswerTwo = mAnswerTwo;
        this.mAnswerThree = mAnswerThree;
        this.mCorrectAnswer = mCorrectAnswer;
        this.mQuestionTypeLayout = mQuestionTypeLayout;
        this.mIndexCard = mIndexCard;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmQuestiontext() {
        return mQuestiontext;
    }

    public void setmQuestiontext(String mQuestiontext) {
        this.mQuestiontext = mQuestiontext;
    }

    public String getmAnswerOne() {
        return mAnswerOne;
    }

    public void setmAnswerOne(String mAnswerOne) {
        this.mAnswerOne = mAnswerOne;
    }

    public String getmAnswerTwo() {
        return mAnswerTwo;
    }

    public void setmAnswerTwo(String mAnswerTwo) {
        this.mAnswerTwo = mAnswerTwo;
    }

    public String getmAnswerThree() {
        return mAnswerThree;
    }

    public void setmAnswerThree(String mAnswerThree) {
        this.mAnswerThree = mAnswerThree;
    }

    public int getmCorrectAnswer() {
        return mCorrectAnswer;
    }

    public void setmCorrectAnswer(int mCorrectAnswer) {
        this.mCorrectAnswer = mCorrectAnswer;
    }

    public int getmQuestionTypeLayout() {
        return mQuestionTypeLayout;
    }

    public void setmQuestionTypeLayout(int mQuestionTypeLayout) {
        this.mQuestionTypeLayout = mQuestionTypeLayout;
    }

    public IndexCard getmIndexCard() {
        return mIndexCard;
    }

    public void setmIndexCard(IndexCard mIndexCard) {
        this.mIndexCard = mIndexCard;
    }

    // Pascal Heß 25.02.2016
    // Method, that delivers the String of the correct answer
    // is used in both Feedback-Application-Logic-Classes

    public String getmCorrectAnswerString() {
        String stringCorrectAnswer = null;

        //Switch-Statement is not correct! --> ChallengeFreeAnswer/ApplicationLogic
        switch (mCorrectAnswer){
            // if one, answer one is correct
            case 1:
                stringCorrectAnswer = this.mAnswerOne;
                break;
            // if two, answer two is correct
            case 2:
                stringCorrectAnswer = this.mAnswerTwo;
                break;
            //if three, answer one and two are correct
            case 3:
                stringCorrectAnswer = this.mAnswerOne;
                stringCorrectAnswer = stringCorrectAnswer.concat(", ").concat(this.mAnswerTwo);
                break;
            //if four, three is correct
            case 4:
                stringCorrectAnswer = this.mAnswerThree;
                break;
            //if five, answer one and three are correct
            case 5:
                stringCorrectAnswer = this.mAnswerOne;
                stringCorrectAnswer = stringCorrectAnswer.concat(", ").concat(this.mAnswerThree);
                break;
            //if six, answer two and three are correct
            case 6:
                stringCorrectAnswer = this.mAnswerTwo;
                stringCorrectAnswer = stringCorrectAnswer.concat(", ").concat(this.mAnswerThree);
                break;
            //if seven, all answers are correct
            case 7:
                stringCorrectAnswer = this.mAnswerOne;
                stringCorrectAnswer = stringCorrectAnswer.concat(", ").concat(this.mAnswerTwo);
                stringCorrectAnswer = stringCorrectAnswer.concat(", ").concat(this.mAnswerThree);
                break;
        }
        return stringCorrectAnswer;
        //Todo Jonas Exception Handling
    }
}
