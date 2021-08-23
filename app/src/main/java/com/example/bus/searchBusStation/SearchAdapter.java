package com.example.bus.searchBusStation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;
import com.example.bus.RouteData;
import com.example.bus.model.RouteEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * *
 * 做liklist 的viewholder
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> implements Filterable {
    private final Context context;
    private final List<RouteData> likelist = new ArrayList<>();
    private onItemClickListener clickListener;

    public SearchAdapter(Context activity) {
        this.context = activity;
    }

    /**
     * 更新清單資料
     *
     * @param routeEntityList 要更新的資料
     */
    public void updateData(List<RouteData> routeEntityList) {
        // 清空likeList
        likelist.clear();

        // 插入routeEntityList到likelist
        likelist.addAll(routeEntityList);

        // adapter更新
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public interface onItemClickListener {
        void onClickHello(String id,String name);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.likelist, parent, false);
        return new SearchViewHolder(view);
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "NotifyDataSetChanged"})
    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {


        RouteData likeitem = likelist.get(position);
        holder.rountename.setText(likeitem.getRouteName());
        holder.startstation.setText(likeitem.getDepartureStopNameZh());
        holder.endstation.setText(likeitem.getDestinationStopNameZh());
        if (likeitem.getLike()) {
            holder.imageView.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            holder.imageView.setImageResource(android.R.drawable.btn_star_big_off);
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {

            //星星標記
            @Override
            public void onClick(View view) {
                if (likeitem.getLike()) {
                    likeitem.setLike(false);
                    holder.imageView.setImageResource(android.R.drawable.btn_star_big_off);
                } else {
                    likeitem.setLike(true);
                    holder.imageView.setImageResource(android.R.drawable.btn_star_big_on);
                }
            }


        });
    }

    @Override
    public int getItemCount() {
        return likelist.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {


        private final TextView rountename, endstation, startstation;
        private final ImageView imageView;


        @SuppressLint("NotifyDataSetChanged")
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            this.rountename = itemView.findViewById(R.id.routename);
            this.startstation = itemView.findViewById(R.id.startstation);
            this.endstation = itemView.findViewById(R.id.endstation);
            this.imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    likelist.get(index);
                    clickListener.onClickHello(likelist.get(index).getRouteID(),likelist.get(index).getRouteName());


                }
            });

        }


    }
}
