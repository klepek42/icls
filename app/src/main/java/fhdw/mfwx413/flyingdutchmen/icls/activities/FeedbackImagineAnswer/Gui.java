package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Pascal Heß
 */

public class Gui {

    private final TextView mTextViewCorrectAnswer;
    private final Button mButtonWasAnswerCorrect;
    private final Button mButtonWasAnswerWrong;

    //Constructor
    public Gui(Activity activity) {
        //set Gui elements
        activity.setContentView(R.layout.layout_feedback_imagine_answer);
        mTextViewCorrectAnswer = (TextView) activity.findViewById(R.id.textFieldCorrectAnswer);
        mButtonWasAnswerCorrect = (Button) activity.findViewById(R.id.buttonWasAnswerCorrect);
        mButtonWasAnswerWrong = (Button) activity.findViewById(R.id.buttonWasAnswerWrong);
    }

    //setter for the textview "TextViewCorrectAnswer"
    // it displays the correct answers, that are saved in the challenge
    public void setTextViewCorrectAnswer(String feedbackTextCorrectAnswer) {
        //delimiter you need, to separate the answer string into its components
        String delimiter = ", ";
        int sizeOfAnswerArray;

        //split the correct answer string with all answers into the array with the single answers
        String AnswerArray[] = feedbackTextCorrectAnswer.split(delimiter);
        sizeOfAnswerArray = AnswerArray.length;

        String correctAnswerIs = "Die richtige(n) Antwort(en):\n \n";

        //it depends on the size of the array, how many "lines" have to be generated
        for (int i = 0; i < sizeOfAnswerArray; i++){
            correctAnswerIs = correctAnswerIs.concat("\u2022 " + AnswerArray[i] + "\n");
        }

        //finally set the strings into the textview
        mTextViewCorrectAnswer.setText(correctAnswerIs);
    }

    //getter for button "getmButtonWasAnswerWrong"
    public Button getmButtonWasAnswerWrong() {
        return mButtonWasAnswerWrong;
    }

    //getter for button "getmButtonWasAnswerCorrect"
    public Button getmButtonWasAnswerCorrect() {
        return mButtonWasAnswerCorrect;
    }
}
