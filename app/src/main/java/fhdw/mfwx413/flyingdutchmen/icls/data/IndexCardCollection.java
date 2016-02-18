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

    private ArrayList<IndexCard> mIndexCardList;


    public IndexCardCollection() {
        mIndexCardList = new ArrayList<IndexCard>();
    }

    public IndexCard getIndexCard (int indexCardId){
        return mIndexCardList.get(indexCardId);
        //Schleife reinbauen, die die IndexCardCollection auf den übergebeben Key durchsucht und
        // die entsprechende IndexCard zurückgibt
    }

    public void addIndexCard(IndexCard indexCard){
        mIndexCardList.add(indexCard);
    }

}
