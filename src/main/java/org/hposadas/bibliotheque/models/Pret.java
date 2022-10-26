package org.hposadas.bibliotheque.models;

import java.util.ArrayList;
import java.util.List;

public class Pret {

    //attributes d'instance
    List<ItemPret> prets;

    //constructor

    public Pret() {
        this.prets = new ArrayList<>();
    }


    //getters & setters

    public List<ItemPret> getPrets() {
        return prets;
    }

    public void addItemPret(ItemPret itemPret) {
            this.prets.add(itemPret);
    }

    public void prolongerPret(ItemPret itemPret){
        int prets = itemPret.getProlongements();
        if (prets == 0) {
            itemPret.setProlongements(itemPret.getProlongements() + 1);
        }
    }
}
