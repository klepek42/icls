package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.app.Activity;
import android.util.Log;

import java.text.ParseException;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidQuestionTypeLayoutException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.UserProgressNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Edgar Klepek
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

    private void initialUpdateGui() {
        // Demodaten
        mGui.setmTextFieldFileNameText(mData.getmChosenFile().getmName().toString());
        mGui.setmTextFieldNumberAllChallenges(String.valueOf(mData.getmNumberAllChallenges()));
        mGui.setmTextFieldNumberDueChallenges(String.valueOf(mData.getmNumberDueChallenges()));
        mGui.setmTextFieldNumberOfClass1(String.valueOf(mData.getmNumberOfClass1()));
        mGui.setmTextFieldNumberOfClass2(String.valueOf(mData.getmNumberOfClass2()));
        mGui.setmTextFieldNumberOfClass3(String.valueOf(mData.getmNumberOfClass3()));
        mGui.setmTextFieldNumberOfClass4(String.valueOf(mData.getmNumberOfClass4()));
        mGui.setmTextFieldNumberOfClass5(String.valueOf(mData.getmNumberOfClass5()));
        mGui.setmTextFieldNumberOfClass6(String.valueOf(mData.getmNumberOfClass6()));
    }

    public void onButtonBackToChooseFileClicked() {;
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
    }

    public void onButtonStartLearningClicked() throws ParseException, IdNotFoundException, InvalidQuestionTypeLayoutException {
        ChallengeCollection mChallengesCurrentIndexCard = mData.getChallengesForSelectedIndexCard();
        // In case that there are IndexCards but no questions assigned
        if (mChallengesCurrentIndexCard.getSize() == 0) {
            Navigation.startActivityNoChallengesForCurrentIndex(mData.getActivity(), mData.getmChosenUser());
        }
        else{
            try {
                UserProgressCollection userProgressForCurrentIndexCard = mData.getUserProgressForCurrentIndexCard();
            }
            catch (UserProgressNotFoundException e) {
                e.printStackTrace();
            }

            ChallengeCollection mDueChallenges = mData.getmDueChallenges();

            if(mDueChallenges.getSize() == 0) {
                Navigation.startActivityFinalEndOfChallenges(mData.getActivity(), mData.getmChosenUser(), mData.getmChosenFile());
            }
            else {
                int mQuestionTypeLayout = mDueChallenges.getChallenge(0).getmQuestionTypeLayout();
                switch (mQuestionTypeLayout) {
                    case 1: Navigation.startActivityChallengeFreeAnswer(mData.getActivity(), mDueChallenges, 0, mData.getmChosenUser(), mData.getmChosenFile(), mData.getCurrentUserUserProgresses());
                        break;
                    case 2: Navigation.startActivityChallengeImagineAnswer(mData.getActivity(), mDueChallenges, 0, mData.getmChosenUser(), mData.getmChosenFile(), mData.getCurrentUserUserProgresses());
                        break;
                    case 3: Navigation.startActivityChallengeMultipleChoice(mData.getActivity(), mDueChallenges, 0, mData.getmChosenUser(), mData.getmChosenFile(), mData.getCurrentUserUserProgresses());
                        break;
                    default: throw new InvalidQuestionTypeLayoutException("FeedbackChallengeRest::ApplicationLogic::onButtonContinue");
                }
            }
        }
    }



}