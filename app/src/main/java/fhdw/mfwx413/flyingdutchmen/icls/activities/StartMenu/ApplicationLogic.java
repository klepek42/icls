package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import fhdw.mfwx413.flyingdutchmen.icls.data.csvImport;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Created by edgar on 17.02.2016
 * Responsibility: Max
 * Updated by Max on 20.02.2016
 * Updated by Edgar on 21.02.2016
 */
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private int count;
    private Context context;
    public static ArrayList<String> users = new ArrayList<>();

    public ApplicationLogic(Data data, Gui gui, Context context) {
        mData = data;
        mGui = gui;
        this.context = context;
        initialUpdateDataToGui();
        fillSpinner();
    }

    private void initialUpdateDataToGui() {
    }

    public void onButtonAddUserClicked() {
        Navigation.startActivityAddNewUser(mData.getActivity());
    }

    public void onButtonConfirmUserClicked() {
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getCurrentUser());
    }

    public void onButtonEditUserClicked() {
        Navigation.startActivityEditUser(mData.getActivity(), mData.getCurrentUser());
    }

    // Added by Edgar Klepek
    // Fill the spinner with data given by users.csv and show it
    private void fillSpinner() {
        users = csvImport.importUserCsv(context);
        // ZUM TESTEN; KANN SPÄTER WIEDER WEG
        count = users.size();
        Log.d("users.size: ", "" + count);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mGui.getChooseUser().setAdapter(adapter);
    }

}