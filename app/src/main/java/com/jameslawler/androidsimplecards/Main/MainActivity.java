package com.jameslawler.androidsimplecards.Main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.jameslawler.androidsimplecards.R;
import com.jameslawler.androidsimplecards.RoboPresenterActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboPresenterActivity<MainPresenter> implements IMainView {
    @InjectView(R.id.card_list)
    private RecyclerView cardList;

    @InjectView(R.id.card_list_item_value)
    private EditText cardListItemValue;

    private LinearLayoutManager cardListLayoutManager;
    private CardListAdapter cardListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.cardList.setHasFixedSize(true);
        this.cardListLayoutManager = new LinearLayoutManager(this);
        this.cardList.setLayoutManager(this.cardListLayoutManager);
        this.cardListAdapter = new CardListAdapter(new ArrayList<String>());
        this.cardList.setAdapter(this.cardListAdapter);

        this.presenter.populateList();
    }

    @OnClick(R.id.card_list_add)
    public void onCardListAddClick() {
        String cardListItemValue = this.cardListItemValue.getText().toString();

        this.presenter.addListItem(cardListItemValue);
    }

    @Override
    public void showCardList(List<String> listItems) {
        this.cardListAdapter.updateList(listItems);
    }
}
