package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.util.ArrayList;

 /**
 * Responsibility Jonas Krabs
 * This Class defines a Collection of indexCards and gives the opportunity to add
 * an indexCard and to get a specific one
 */
public class IndexCardCollection {

    private IndexCard merrorIndexCard;
    private ArrayList<IndexCard> mIndexCardList;


    public IndexCardCollection() {
        mIndexCardList = new ArrayList<IndexCard>();
    }

    //method requires the id of a concrete indexCard as key
    //this is not the id of the current indexCardCollection but the id, that is deposit in the csv
    public IndexCard getIndexCard (int key){
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
        //Todo Jonas: Den Fall behandeln, was passiert, wenn ein Key übergeben wird, der nicht existiert
    }

    public void addIndexCard(IndexCard indexCard){
        mIndexCardList.add(indexCard);
    }

}
