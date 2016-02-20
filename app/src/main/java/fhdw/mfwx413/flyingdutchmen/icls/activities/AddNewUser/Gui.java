package fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Created by edgar on 17.02.2016.
 */
public class Gui {

    private TextView mTextFieldCreateUser;
    private EditText mNameOfUser;
    private Button mButtonAbortNewUser;
    private Button mButtonSaveNewUser;


    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_add_new_user);
        mTextFieldCreateUser = (TextView) activity.findViewById(R.id.textFieldQuestion);
        mNameOfUser = (EditText) activity.findViewById(R.id.nameOfUser);
        mButtonAbortNewUser = (Button) activity.findViewById(R.id.buttonAbortNewUser);
        mButtonSaveNewUser = (Button) activity.findViewById(R.id.buttonSaveNewUser);
    }

    public EditText getmGivenAnswer() {
        return mNameOfUser;
    }
}
