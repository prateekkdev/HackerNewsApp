package com.prateek.hackernewsapp.ui.news.home;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prateek.hackernewsapp.R;
import com.prateek.hackernewsapp.databinding.SearchListItemBinding;
import com.prateek.hackernewsapp.network.dto.Hit;
import com.prateek.hackernewsapp.ui.news.details.DetailsActivity;

import java.util.List;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {

    private List<Hit> searchHitList;

    public SearchResultAdapter() {

    }

    public void updateData(List<Hit> searchHitList) {
        this.searchHitList = searchHitList;
        this.notifyDataSetChanged();
    }

    @Override
    public SearchResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_list_item, parent, false);
        SearchResultAdapter.ViewHolder viewHolder = new SearchResultAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hit searchHit = searchHitList.get(position);
        holder.listItemBinding.searchItemTitle.setText(searchHit.getTitle());
        holder.listItemBinding.searchItemAuthor.setText(searchHit.getAuthor());

        holder.listItemBinding.searchItemCardViews.setOnClickListener(view -> switchDetailsActivity(holder.listItemBinding.searchItemAuthor.getContext(), searchHit.getUrl()));
    }

    public void switchDetailsActivity(Context context, String url) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(DetailsActivity.DETAILS_URL_KEY, url);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (searchHitList != null) {
            return searchHitList.size();
        }

        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        SearchListItemBinding listItemBinding;

        public ViewHolder(View itemView) {
            super(itemView);
            listItemBinding = DataBindingUtil.bind(itemView);
        }
    }
}