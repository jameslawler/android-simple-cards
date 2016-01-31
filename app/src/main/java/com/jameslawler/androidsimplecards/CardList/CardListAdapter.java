package com.jameslawler.androidsimplecards.CardList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.inject.Inject;
import com.jameslawler.androidsimplecards.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import roboguice.RoboGuice;

/**
 * Created by james on 1/31/2016.
 */
public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {
    private List<String> listItems;

    public static class ViewHolder extends RecyclerView.ViewHolder implements ICardListItemView {
        @Bind(R.id.info_text)
        public TextView infoText;

        @Inject
        CardListItemPresenter presenter;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            RoboGuice.getInjector(view.getContext()).injectMembersWithoutViews(this);
        }

        @OnClick(R.id.info_text)
        public void onInfoTextClick() {
            String itemValue = this.infoText.getText().toString();
            this.presenter.onCardListItemClick(itemValue);
        }

        @Override
        public void changeItemValue(String itemValue) {
            this.infoText.setText(itemValue);
        }
    }

    public CardListAdapter(List<String> listItems) {
        this.listItems = listItems;
    }

    @Override
    public CardListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.infoText.setText(this.listItems.get(position));
    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.presenter.bindView(holder);
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.presenter.onDestroy();
    }

    @Override
    public int getItemCount() {
        return this.listItems.size();
    }

    public void updateList(List<String> listItems) {
        this.listItems = listItems;
        this.notifyDataSetChanged();
    }
}