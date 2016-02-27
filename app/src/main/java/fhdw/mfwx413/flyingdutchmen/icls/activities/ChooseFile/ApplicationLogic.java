package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.12.2016
 */

public class ApplicationLogic implements AdapterView.OnItemSelectedListener {

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
        Navigation.startActivityStatistics(mData.getActivity(), mData.getCurrentUser(), mData.getmCurrentIndex());
    }

    public void onButtonLogoutClicked() {
        //TODO Max: Abmelden-Fragment
        Navigation.startActivityStartMenu(mData.getActivity());
    }

    public void onButtonSettingsClicked() {
        Navigation.startActivitySettingMenu(mData.getActivity());
        Navigation.startActivityEditUser(mData.getActivity(), mData.getCurrentUser());
    }

    public void onButtonStartLearningClicked() {
        //TODO Max: Start Lernmodus mit fälligen Fragen oder Ende-Screen
        // getIndexCard erwartet int, es ist aber nur String als Übergabeparameter vorhanden
        //mData.setmCurrentIndex(mData.getmAllIndexCards().getIndexCard());
        //mData.setmCurrentIndex(mData.getmAllIndexCards().getIndexCard(mSelectedIndexCard));
        //Navigation.startActivityEditUser(mData.getActivity(), mData.getCurrentUser());
        Navigation.startActivityChallengeFreeAnswer(mData.getActivity());
    }

    private void fillSpinner() {

        for(int i = 0; i < mData.getmAllIndexCards().getSize(); i++) {
            indexCards.add(mData.getmAllIndexCards().get(i).getmName());
        }

        // ZUM TESTEN; KANN SPÄTER WIEDER WEG
        count = indexCards.size();
        Log.d("users.size: ", "" + count);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, indexCards);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mGui.getChosenFile().setAdapter(adapter);
        mGui.getChosenFile().setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(indexCards.get(position));
        mSelectedIndexCard = indexCards.get(position);
        // Bei Auswahl ein IndexCard Objekt rausfischen und irgendwie als mCurrentIndex für Data und Bundle übergeben
        // mSelectedIndexCard ist leider nur ein String und kein IndexCard
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Spinner is always filled init of activity, therefore method doesnt need to be filled
    }

}
