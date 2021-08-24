package com.example.bus.head;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;
import com.example.bus.RouteData;
import com.example.bus.searchBusStation.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.LikeViewHolder>  {
    private final Context context;
    private final List<RouteData> likelist = new ArrayList<>();
    private LikeAdapter.onItemClickListener clickListener;
    List<RouteData> data =new ArrayList<>();


    public LikeAdapter(Context activity) {
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



    public interface onItemClickListener {
        void onClickHello(String id,String name);
    }

    public void setOnItemClickListener(LikeAdapter.onItemClickListener listener) {
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public LikeAdapter.LikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.likelist, parent, false);
        return new LikeAdapter.LikeViewHolder(view);
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "NotifyDataSetChanged"})
    @Override
    public void onBindViewHolder(@NonNull LikeAdapter.LikeViewHolder holder, int position) {


        RouteData likeitem = likelist.get(position);
        holder.rountename.setText(likeitem.getRouteName());
        holder.startstation.setText(likeitem.getDepartureStopNameZh());
        holder.endstation.setText(likeitem.getDestinationStopNameZh());

        holder.imageView.setImageResource(android.R.drawable.btn_star_big_on);


        holder.imageView.setOnClickListener(new View.OnClickListener() {


            //從SharedPreferences裡拿有的打星星的有幾個

            //星星標記
            @Override
            public void onClick(View view) {
                if (likeitem.getLike()) {//如果有打星星
                    likeitem.setLike(false);
                    holder.imageView.setImageResource(android.R.drawable.btn_star_big_off);

                }

            }


        });
    }

    @Override
    public int getItemCount() {
        return likelist.size();
    }

    public class LikeViewHolder extends RecyclerView.ViewHolder {


        private final TextView rountename, endstation, startstation;
        private final ImageView imageView;


        @SuppressLint("NotifyDataSetChanged")
        public LikeViewHolder(@NonNull View itemView) {
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
