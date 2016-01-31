package com.jameslawler.androidsimplecards.CardList;

import com.jameslawler.androidsimplecards.IPresenter;
import com.jameslawler.androidsimplecards.Main.IMainView;
import com.jameslawler.androidsimplecards.Presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

/**
 * Created by james on 1/30/2016.
 */

public class CardListItemPresenter extends Presenter<ICardListItemView> implements IPresenter<ICardListItemView> {
    public void onCardListItemClick(String currentItem) {
        if (this.view == null) {
            return;
        }

        this.view.changeItemValue(currentItem + " - James was here");
    }
}
