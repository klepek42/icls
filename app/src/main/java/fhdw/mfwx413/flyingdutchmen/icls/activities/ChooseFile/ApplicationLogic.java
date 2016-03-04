package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidQuestionTypeLayoutException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.UserProgressNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.12.2016
 */

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

    public void onStandardBackButtonClicked() {
        Navigation.startActivityLogout(mData.getActivity(), mData.getCurrentUser());
    }

    // Added by Edgar 27.02
    public void onButtonStatisticsClicked() throws ParseException, IdNotFoundException, UserProgressNotFoundException {
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

    public void onButtonLogoutClicked() {
        Navigation.startActivityLogout(mData.getActivity(), mData.getCurrentUser());
    }

    public void onButtonSettingsClicked() {
        Navigation.startActivitySettingMenu(mData.getActivity(), mData.getCurrentUser());
    }

    public void onButtonStartLearningClicked() throws ParseException, IdNotFoundException, InvalidQuestionTypeLayoutException {
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

            if(mDueChallenges.getSize() == 0) {
                Navigation.startActivityFinalEndOfChallenges(mData.getActivity(), mData.getCurrentUser(), mData.getCurrentIndexCard());
            }
            else {
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

    private void fillSpinner() {
        for(int i = 0; i < mData.getAllIndexCards().getSize(); i++) {
            indexCards.add(mData.getAllIndexCards().get(i).getmName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, indexCards);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGui.getChooseIndexCard().setAdapter(adapter);
    }

    public void onIndexCardSelected(int position){
        System.out.println(indexCards.get(position));
        mSelectedIndexCard = indexCards.get(position);
    }

}
