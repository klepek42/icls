package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.util.ArrayList;

import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IndexCardNotFoundException;

/**
 * Responsibility Jonas Krabs
 */
public class IndexCardCollection {

    private final ArrayList<IndexCard> mIndexCardList;

    public IndexCardCollection() {
        //noinspection Convert2Diamond
        mIndexCardList = new ArrayList<IndexCard>();
    }

    //get a specific IndexCard in the collection
    //the key specifies the IndexCard by representing an IndexCardId that is saved in the csv
    //the method runs through the collection searching for an IndexCard whose id fits to the key
    public IndexCard getIndexCardByKey(int key) throws IdNotFoundException {
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
            //if there was no IndexCard found, whose id fits to the key the method throws an exception
            throw new IdNotFoundException("IndexCardCollection::getIndexCardByKey: Ungültiger Key für IndexCard: " + key);
        }

        return foundIndexCard;
    }


    //get a specific IndexCard in the collection
    //the name specifies the IndexCard by representing a name that is saved in the csv
    //the method runs through the collection searching for an IndexCard whose name fits to the given name
    //if there are several indexCards with the same name (this should not be the case) the method will return the first one in the collection
    public IndexCard getIndexCardByName (String name) throws IndexCardNotFoundException {
        int i;
        IndexCard foundIndexCard;
        foundIndexCard = new IndexCard(-1,"");
        for (i = 0; i < mIndexCardList.size(); i++) {
            if (mIndexCardList.get(i).getmName().equals(name)) {
                foundIndexCard = mIndexCardList.get(i);
                break;
            }
        }

        if (foundIndexCard.getmID() == -1){
            //if there was no IndexCard found whose name fits to the given name the method throws an exception
            throw new IndexCardNotFoundException("IndexCardCollection::getIndexCardByName: Keine IndexCard mit folgendem Namen vorhanden: " + name);
        }

        return foundIndexCard;
    }

    public void addIndexCard(IndexCard indexCard){
        mIndexCardList.add(indexCard);
    }

    public int getSize() {
        return mIndexCardList.size();
    }

    //get an IndexCard from a specific position of the collection
    //the id specifies the position of the IndexCard in the collection
    public IndexCard get(int id){
        return mIndexCardList.get(id);
    }
}