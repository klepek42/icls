package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

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
        //TODO Max: Start Lernmodus mit fälligen Fragen oder Ende-Screen
        // getIndexCard erwartet int, es ist aber nur String als Übergabeparameter vorhanden
        // Erster Parameter ist auf Grund der IndexCard.csv ein int als ID, dann erst Name.

        //mData.setCurrentIndexCard(mData.getAllIndexCards().getIndexCard(mSelectedIndexCard));
        //Navigation.startActivityEditUser(mData.getActivity(), mData.getCurrentUser());
        Navigation.startActivityChallengeFreeAnswer(mData.getActivity());
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
