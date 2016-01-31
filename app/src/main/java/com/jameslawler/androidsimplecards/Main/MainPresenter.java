package com.jameslawler.androidsimplecards.Main;

import com.jameslawler.androidsimplecards.IPresenter;
import com.jameslawler.androidsimplecards.Presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

/**
 * Created by james on 1/30/2016.
 */

@Singleton
public class MainPresenter extends Presenter<IMainView> implements IPresenter<IMainView> {
    List<String> cardListItems;

    @Override
    public void resetState() {
        super.resetState();
        this.cardListItems = new ArrayList<>();
    }

    public void addListItem(String item) {
        if (this.view == null) {
            return;
        }

        this.cardListItems.add(item);

        this.view.showCardList(this.cardListItems);
    }

    public void populateList() {
        if (this.view == null) {
            return;
        }

        this.cardListItems.add("hello");
        this.cardListItems.add("world");
        this.cardListItems.add("and");
        this.cardListItems.add("Rita");

        this.view.showCardList(this.cardListItems);
    }
}
