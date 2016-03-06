package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.io.Serializable;

/**
 * Responsibility: Jonas Krabs
 */
public class IndexCard implements Serializable{

    private final int mID;
    private final String mName;

    public IndexCard(int mID, String mName) {
        this.mID = mID;
        this.mName = mName;
    }

    public String getmName() {
        return mName;
    }

    public int getmID() {
        return mID;
    }
}
