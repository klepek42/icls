package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IndexCardNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidQuestionTypeLayoutException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.UserProgressNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by edgar on 13.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 20.02.2016
 * Updated by Max on 21.02.2016
 * Updated by Max on 22.02.2016
 * Updated by Max on 24.02.2016
 * Updated by Max on 27.02.2016
 * Updated by Max on 01.03.2016
 */

// application logic connects the data with the gui and defines the exact events after an user-interaction
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private Context context;
    private ArrayList<String> indexCards = new ArrayList<>();
    private String mSelectedIndexCard;
    private ChallengeCollection mChallengesCurrentIndexCard;
    private UserProgressCollection mUserProgressForCurrentIndexCard;
    private ChallengeCollection mDueChallenges;

    public ApplicationLogic(Data data, Gui gui, Context context) {
        mData = data;
        mGui = gui;
        this.context = context;
        initialUpdateDataToGui();
        fillSpinner();
    }

    private void initialUpdateDataToGui() {

    }

    // calls the activity logout and transmits the current user
    public void onStandardBackButtonClicked() {
        Navigation.startActivityLogout(mData.getActivity(), mData.getCurrentUser());
    }

    // starts the calculation of due challenges and transmits it to the statistic activity
    public void onButtonStatisticsClicked() throws ParseException, IndexCardNotFoundException, UserProgressNotFoundException, IdNotFoundException {
        mData.setCurrentIndexCard(mData.getAllIndexCards().getIndexCardByName(mSelectedIndexCard));
        mChallengesCurrentIndexCard = mData.getChallengesForSelectedIndexCard();
        // In case that there are IndexCards but no questions assigned
        if (mChallengesCurrentIndexCard.getSize() == 0) {
            Navigation.startActivityNoChallengesForCurrentIndex(mData.getActivity(), mData.getCurrentUser());
        }
        else{
            try {
                mUserProgressForCurrentIndexCard = mData.getUserProgressForCurrentIndexCard();
            }
            catch (UserProgressNotFoundException e) {
                e.printStackTrace();
            }
            mDueChallenges = mData.getDueChallengeList();
            Navigation.startActivityStatistics(mData.getActivity(), mData.getCurrentUser(), mData.getCurrentIndexCard(), mDueChallenges);
        }
    }

    // calls the activity logout and transmits the current user
    public void onButtonLogoutClicked() {
        Navigation.startActivityLogout(mData.getActivity(), mData.getCurrentUser());
    }

    // calls the activity settings and transmits the current user
    public void onButtonSettingsClicked() {
        Navigation.startActivitySettingMenu(mData.getActivity(), mData.getCurrentUser());
    }

    // starts the calculation of due challenges and transmits it to the next activity
    public void onButtonStartLearningClicked() throws ParseException, IndexCardNotFoundException, InvalidQuestionTypeLayoutException, IdNotFoundException {
        int mQuestionTypeLayout;
        mData.setCurrentIndexCard(mData.getAllIndexCards().getIndexCardByName(mSelectedIndexCard));

        mChallengesCurrentIndexCard = mData.getChallengesForSelectedIndexCard();
        // In case that there are IndexCards but no questions assigned
        if (mChallengesCurrentIndexCard.getSize() == 0) {
            Navigation.startActivityNoChallengesForCurrentIndex(mData.getActivity(), mData.getCurrentUser());
        }
        else{
            try {
                mUserProgressForCurrentIndexCard = mData.getUserProgressForCurrentIndexCard();
            }
            catch (UserProgressNotFoundException e) {
                e.printStackTrace();
            }

            mDueChallenges = mData.getDueChallengeList();

            // if there are no due challenges for the selected IndexCard, it calls the activity final-end-of-challenges and transmits the current user and selected IndexCard
            if(mDueChallenges.getSize() == 0) {
                Navigation.startActivityFinalEndOfChallenges(mData.getActivity(), mData.getCurrentUser(), mData.getCurrentIndexCard());
            }
            else {
                // depending on the first due challenge the linked layout-type calls the correct activity and transmits the duechallenges, the index of the first challenge from ChallengeCollection, the current IndexCard and the current UserProgress
                mQuestionTypeLayout = mDueChallenges.getChallenge(0).getmQuestionTypeLayout();
                switch (mQuestionTypeLayout) {
                    case 1: Navigation.startActivityChallengeFreeAnswer(mData.getActivity(), mDueChallenges, 0, mData.getCurrentUser(), mData.getCurrentIndexCard(), mData.getCurrentUserUserProgresses());
                        break;
                    case 2: Navigation.startActivityChallengeImagineAnswer(mData.getActivity(), mDueChallenges, 0, mData.getCurrentUser(), mData.getCurrentIndexCard(), mData.getCurrentUserUserProgresses());
                        break;
                    case 3: Navigation.startActivityChallengeMultipleChoice(mData.getActivity(), mDueChallenges, 0, mData.getCurrentUser(), mData.getCurrentIndexCard(), mData.getCurrentUserUserProgresses());
                        break;
                    default: throw new InvalidQuestionTypeLayoutException("FeedbackChallengeRest::ApplicationLogic::onButtonContinue");
                }
            }
        }
    }

    // fill the spinner with all IndexCards that were collected in the data class
    private void fillSpinner() {
        for(int i = 0; i < mData.getAllIndexCards().getSize(); i++) {
            indexCards.add(mData.getAllIndexCards().get(i).getmName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, indexCards);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGui.getChooseIndexCard().setAdapter(adapter);
    }

    // set selected IndexCard from Spinner
    public void onIndexCardSelected(int position){
        System.out.println(indexCards.get(position));
        mSelectedIndexCard = indexCards.get(position);
    }

}
