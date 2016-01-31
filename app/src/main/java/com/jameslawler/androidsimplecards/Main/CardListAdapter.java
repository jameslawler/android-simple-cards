package com.jameslawler.androidsimplecards.Main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jameslawler.androidsimplecards.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import roboguice.inject.InjectView;

/**
 * Created by james on 1/31/2016.
 */
public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {
    private List<String> listItems;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.info_text)
        public TextView infoText;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.info_text)
        public void onInfoTextClick() {
            this.infoText.setText("James was here");
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
    public int getItemCount() {
        return this.listItems.size();
    }

    public void updateList(List<String> listItems) {
        this.listItems = listItems;
        this.notifyDataSetChanged();
    }
}