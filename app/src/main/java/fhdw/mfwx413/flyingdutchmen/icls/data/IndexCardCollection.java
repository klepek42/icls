package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.util.ArrayList;

import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;

/**
 * Responsibility Jonas Krabs
 * This Class defines a Collection of indexCards and gives the opportunity to add
 * an indexCard and to get a specific one
 */
public class IndexCardCollection {

    private ArrayList<IndexCard> mIndexCardList;


    public IndexCardCollection() {
        mIndexCardList = new ArrayList<IndexCard>();
    }

    //method requires the id of a concrete indexCard as key
    //this is not the id of the current indexCardCollection but the id, that is deposit in the csv
    public IndexCard getIndexCard (int key) throws IdNotFoundException {
        int i;
        IndexCard foundIndexCard;
        foundIndexCard = new IndexCard(-1,"");
        for ( i = 0; i < mIndexCardList.size(); i++)
        {
            if (mIndexCardList.get(i).getmID() == key)
            {
                foundIndexCard =  mIndexCardList.get(i);
                break;
            }
        }

        if (foundIndexCard.getmID() == -1){
            throw new IdNotFoundException("IndexCardCollection::getIndexCard: Ungültiger Key für IndexCard: " + key);
        }

        return foundIndexCard;
    }

    public void addIndexCard(IndexCard indexCard){
        mIndexCardList.add(indexCard);
    }

    public int getSize() {
        return mIndexCardList.size();
    }

    public IndexCard get(int index){
        return mIndexCardList.get(index);
    }

}
