package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

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

    public ApplicationLogic(Data data, Gui gui, Context context) {
        mData = data;
        mGui = gui;
        this.context = context;
        initialUpdateDataToGui();
        fillSpinner();
    }

    private void initialUpdateDataToGui() {

    }

    // Added by Edgar 27.02
    public void onButtonStatisticsClicked() {
        Log.d("CurrentindexCard: ", "" + mData.getCurrentIndexCard());
        Log.d("CurrentUser: ", "" + mData.getCurrentUser());
        Navigation.startActivityStatistics(mData.getActivity(), mData.getCurrentUser(), mData.getCurrentIndexCard());
    }

    public void onButtonLogoutClicked() {
        //TODO Max: Abmelden-Fragment
        Navigation.startActivityStartMenu(mData.getActivity());
    }

    public void onButtonSettingsClicked() {
        Navigation.startActivitySettingMenu(mData.getActivity(), mData.getCurrentUser());
    }

    public void onButtonStartLearningClicked() {
        // getIndexCard erwartet int, es ist aber nur String als Übergabeparameter vorhanden (s.IndexCardCollection)
        //mData.setCurrentIndexCard(mData.getAllIndexCards().getIndexCard(mSelectedIndexCard));

        mChallengesCurrentIndexCard = mData.getChallengesForSelectedIndexCard();
        if(mChallengesCurrentIndexCard == null) {
            //TODO Max: Vernünftiges Fehlerhandling
            //Log.d("Keine Challenges für aktuelle IndexCard verfügbar.", "");
        }

        mUserProgressForCurrentIndexCard = mData.getUserProgressForCurrentIndexCard();
        if(mUserProgressForCurrentIndexCard == null) {
            //TODO Max: Vernünftiges Fehlerhandling
        }

        mUserProgressForCurrentIndexCardAndCurrentUser = mData.getUserProgressForCurrentIndexCardAndCurrentUser();
        if(mUserProgressForCurrentIndexCardAndCurrentUser == null) {
            //TODO Max: Vernünftiges Fehlerhandling
        }


        //Navigation.startActivityEditUser(mData.getActivity(), mData.getCurrentUser());

        //TODO Max: Aufruf der Methoden des DueChallenges Algorithmus. Wenn DueChallenges-Liste leer, dann EndeScreen

        //Pascal Heß: There were changes in the class "Navigation". Now the method needs more parameters for being correctly called.
        //Therefore the next commented line needs to be adapted.
        //Navigation.startActivityChallengeFreeAnswer(mData.getActivity());
    }

    private void fillSpinner() {

        for(int i = 0; i < mData.getAllIndexCards().getSize(); i++) {
            indexCards.add(mData.getAllIndexCards().get(i).getmName());
        }

        // ZUM TESTEN; KANN SPÄTER WIEDER WEG
        count = indexCards.size();
        Log.d("users.size: ", "" + count);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, indexCards);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mGui.getChosenFile().setAdapter(adapter);
    }

    public void onUserSelected(int position){
        System.out.println(indexCards.get(position));
        mSelectedIndexCard = indexCards.get(position);
    }

}
