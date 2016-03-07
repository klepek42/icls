package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import java.text.ParseException;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidQuestionTypeLayoutException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Edgar Klepek
 */
public class ApplicationLogic {

    // Member variables
    private Data mData;
    private Gui mGui;

    // Constructor
    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initialUpdateGui();
    }

    // Initialize all statistics data with the current calculated values
    private void initialUpdateGui() {
        mGui.setTextFieldFileNameText(mData.getChosenFile().getmName());
        mGui.setTextFieldNumberAllChallenges(String.valueOf(mData.getNumberAllChallenges()));
        mGui.setTextFieldNumberDueChallenges(String.valueOf(mData.getNumberDueChallenges()));
        mGui.setTextFieldNumberOfClass1(String.valueOf(mData.getNumberOfClass(1)));
        mGui.setTextFieldNumberOfClass2(String.valueOf(mData.getNumberOfClass(2)));
        mGui.setTextFieldNumberOfClass3(String.valueOf(mData.getNumberOfClass(3)));
        mGui.setTextFieldNumberOfClass4(String.valueOf(mData.getNumberOfClass(4)));
        mGui.setTextFieldNumberOfClass5(String.valueOf(mData.getNumberOfClass(5)));
        mGui.setTextFieldNumberOfClass6(String.valueOf(mData.getNumberOfClass(6)));
    }

    // onClickListener: Go to the activity chooseFile
    public void onButtonBackToChooseFileClicked() {
        Navigation.startActivityChooseIndexCard(mData.getActivity(), mData.getChosenUser());
    }

    // onClickListener: Start the learning mode and decide which challenge activity has to be started
    public void onButtonStartLearningClicked() throws ParseException, IdNotFoundException, InvalidQuestionTypeLayoutException {
        ChallengeCollection mChallengesCurrentIndexCard = mData.getChallengesForSelectedIndexCard();
        // In case that there are IndexCards but no questions assigned
        if (mChallengesCurrentIndexCard.getSize() == 0) {
            Navigation.startActivityNoChallengesForCurrentIndex(mData.getActivity(), mData.getChosenUser());
        }
        else{
            ChallengeCollection mDueChallenges = mData.getDueChallenges();

            // Check if there are no challenges left to solve (due) and go to the end screen if true
            if(mDueChallenges.getSize() == 0) {
                Navigation.startActivityFinalEndOfChallenges(mData.getActivity(), mData.getChosenUser(), mData.getChosenFile());
            }
            // If there are challenges left to solve, decide which activity has to be started depending on the layout type of the next challenge to solve
            else {
                int mQuestionTypeLayout = mDueChallenges.getChallenge(0).getmQuestionTypeLayout();
                switch (mQuestionTypeLayout) {
                    // Start activity ChallengeFreeAnswer with needed information
                    case 1: Navigation.startActivityChallengeFreeAnswer(mData.getActivity(), mDueChallenges, 0, mData.getChosenUser(), mData.getChosenFile(), mData.getCurrentUserUserProgresses());
                        break;
                    // Start activity ChallengeImagineAnswer with needed information
                    case 2: Navigation.startActivityChallengeImagineAnswer(mData.getActivity(), mDueChallenges, 0, mData.getChosenUser(), mData.getChosenFile(), mData.getCurrentUserUserProgresses());
                        break;
                    // Start activity ChallengeMultipleChoice with needed information
                    case 3: Navigation.startActivityChallengeMultipleChoice(mData.getActivity(), mDueChallenges, 0, mData.getChosenUser(), mData.getChosenFile(), mData.getCurrentUserUserProgresses());
                        break;
                    // Throw an exception if someone has chosen a invalid layout type in index.csv from outside
                    default: throw new InvalidQuestionTypeLayoutException("FeedbackChallengeRest::ApplicationLogic::onButtonContinue");
                }
            }
        }
    }

}