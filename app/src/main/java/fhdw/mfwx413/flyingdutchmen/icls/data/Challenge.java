package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.io.Serializable;

import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidCorrectAnswerTypeException;

/**
 * Responsibility: Jonas Krabs
 */
public class Challenge implements Serializable{

    private final int mID;
    private final String mQuestiontext;
    private final String mAnswerOne;
    private final String mAnswerTwo;
    private final String mAnswerThree;
    private final int mCorrectAnswer;
    private final int mQuestionTypeLayout;
    private final IndexCard mIndexCard;

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

    public String getmQuestiontext() {
        return mQuestiontext;
    }

    public String getmAnswerOne() {
        return mAnswerOne;
    }

    public String getmAnswerTwo() {
        return mAnswerTwo;
    }

    public String getmAnswerThree() {
        return mAnswerThree;
    }

    public int getmCorrectAnswer() {
        return mCorrectAnswer;
    }

    public int getmQuestionTypeLayout() {
        return mQuestionTypeLayout;
    }

    public IndexCard getmIndexCard() {
        return mIndexCard;
    }

    // Pascal Heß 25.02.2016
    // Method, that delivers the String of the correct answer
    // is used in both Feedback-Application-Logic-Classes
    public String getmCorrectAnswerString() throws InvalidCorrectAnswerTypeException{
        String stringCorrectAnswer;

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
            //if four, answer three is correct
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
            default:
                //if there is another value than 1-7 the value is invalid and the method throws an exception
                throw new InvalidCorrectAnswerTypeException("Challenge::getmCorrectAnswerString: Ungültiger Wert für CorrectAnswer: " + mCorrectAnswer);
        }
        return stringCorrectAnswer;
    }
}
