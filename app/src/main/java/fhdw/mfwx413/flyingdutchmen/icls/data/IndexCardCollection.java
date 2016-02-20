package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.util.ArrayList;

/**
 * Created by Krabs on 18.02.2016.
 * das ist eine testklasse... ich kann noch nicht absehen, ob wir sie wirklich brauchen
 * solange das einlesen aus den csv-Dateien noch nicht realisiert ist, ist sie aber auf jeden Fall
 * notwendig
 * Im Moment gehe ich aber stark davon aus, dass wir die Klasse brauchen werden
 */
public class IndexCardCollection {

    private IndexCard merrorIndexCard;
    private ArrayList<IndexCard> mIndexCardList;


    public IndexCardCollection() {
        mIndexCardList = new ArrayList<IndexCard>();
    }

    //method requires the id of a concrete index card as key
    public IndexCard getIndexCard (int key){
        //return mIndexCardList.get(indexCardId);
        int i;
        for ( i = 0; i < mIndexCardList.size(); i++)
        {
            if (mIndexCardList.get(i).getmID() == key)
            {
                return mIndexCardList.get(i);
            }
        }
        //nur um den Fall abzufangen, dass der übergebene key nicht existiert
        //muss definitiv noch geändert werden!!!
        return merrorIndexCard;
        //Todo: was passiert, wenn der übergebene key nicht existiert?
    }

    public void addIndexCard(IndexCard indexCard){
        mIndexCardList.add(indexCard);
    }

}
