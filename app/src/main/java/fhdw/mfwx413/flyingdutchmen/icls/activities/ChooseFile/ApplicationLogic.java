package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;
import android.content.Context;
import android.util.Log;
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
    private int count;
    private ArrayList<String> indexCards = new ArrayList<>();
    private String mSelectedIndexCard;
    private ChallengeCollection mChallengesCurrentIndexCard;
    private UserProgressCollection mUserProgressForCurrentIndexCard;
    private UserProgressCollection mUserProgressForCurrentIndexCardAndCurrentUser;
    private ChallengeCollection mDueChallenges;
    private int mQuestionTypeLayout;

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
        Navigation.startActivityStartMenu(mData.getActivity());
    }

    // Added by Edgar 27.02
    public void onButtonStatisticsClicked() throws ParseException, IdNotFoundException {
        mData.setCurrentIndexCard(mData.getAllIndexCards().getIndexCardByName(mSelectedIndexCard));
        mChallengesCurrentIndexCard = mData.getChallengesForSelectedIndexCard();
        mUserProgressForCurrentIndexCard = mData.getUserProgressForCurrentIndexCard();
        mDueChallenges = mData.getDueChallengeList();
        Navigation.startActivityStatistics(mData.getActivity(), mData.getCurrentUser(), mData.getCurrentIndexCard(), mDueChallenges);
    }

    public void onButtonLogoutClicked() {
        Navigation.startActivityLogout(mData.getActivity(), mData.getCurrentUser());
    }

    public void onButtonSettingsClicked() {
        Navigation.startActivitySettingMenu(mData.getActivity(), mData.getCurrentUser());
    }

    public void onButtonStartLearningClicked() throws ParseException, IdNotFoundException {
        mData.setCurrentIndexCard(mData.getAllIndexCards().getIndexCardByName(mSelectedIndexCard));

        mChallengesCurrentIndexCard = mData.getChallengesForSelectedIndexCard();

        Log.d("ChallengeListSize: " , ""+mChallengesCurrentIndexCard.getSize());

        if (mChallengesCurrentIndexCard.getSize() == 0) {
            Navigation.startActivityNoChallengesForCurrentIndex(mData.getActivity(), mData.getCurrentUser());
        }

        try {
            mUserProgressForCurrentIndexCard = mData.getUserProgressForCurrentIndexCard();
        }
        catch (NullPointerException e) {
            //TODO Max: Vernünftiges Fehlerhandling
        }

        /**
        mUserProgressForCurrentIndexCardAndCurrentUser = mData.getUserProgressForCurrentIndexCardAndCurrentUser();
        if(mUserProgressForCurrentIndexCardAndCurrentUser.getSize() == 0) {
            //TODO Max: Vernünftiges Fehlerhandling
            //Log.d("Keine Challenges für aktuelle IndexCard und User verfügbar.", "");
        }
         */

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
                default:
                    break;
            }
        }
    }

    private void fillSpinner() {

        for(int i = 0; i < mData.getAllIndexCards().getSize(); i++) {
            indexCards.add(mData.getAllIndexCards().get(i).getmName());
        }

        // ZUM TESTEN; KANN SPÄTER WIEDER WEG
        count = indexCards.size();
        Log.d("IndexCards.size: ", "" + count);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, indexCards);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mGui.getChooseIndexCard().setAdapter(adapter);
    }

    public void onIndexCardSelected(int position){
        System.out.println(indexCards.get(position));
        mSelectedIndexCard = indexCards.get(position);
    }

}
