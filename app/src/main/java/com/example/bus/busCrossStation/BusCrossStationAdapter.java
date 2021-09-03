package com.example.bus.busCrossStation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.DialogFragment;
import com.example.bus.R;
import com.example.bus.RouteData;

import java.util.ArrayList;
import java.util.List;

public class BusCrossStationAdapter extends RecyclerView.Adapter<BusCrossStationAdapter.BusCrossStationViewHolder> {

    List<RouteData> routedata = new ArrayList<>();
    Context context;
    private BusCrossStationAdapter.onItemClickListener clickListener;

    public interface onItemClickListener {
        void onClickHello(View view, int position, String routeid, String routename);
    }

    public void setOnItemClickListener(BusCrossStationAdapter.onItemClickListener listener) {
        this.clickListener = listener;
    }

    BusCrossStationAdapter(Context activity) {
        context = activity;
    }

    public void update(List<RouteData> reroutedata) {
        routedata.clear();
        routedata.addAll(reroutedata);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BusCrossStationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.buscrossstationlist, parent, false);
        return new BusCrossStationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusCrossStationViewHolder holder, int position) {
        RouteData routeitem = routedata.get(position);


        //判斷車子狀態
        if (routeitem.getStopStatus() == 0 ) {//狀態為正常
            //如果預估時間=0
            if(routeitem.getEstimateTime()/60 < 1){
                holder.realtime.setText("進站中");
            }
            else{
                holder.realtime.setText(" " + routeitem.getEstimateTime()/60 + "分");
            }
        } else if (routeitem.getStopStatus() == 1) { //1:'尚未發車
            if(routeitem.getEstimateTime() == 0) holder.realtime.setText("尚未發車");
            else holder.realtime.setText(" " + routeitem.getEstimateTime()/60 + "分");

        }else if (routeitem.getStopStatus() == 2) {
            holder.realtime.setText("交管不停靠");
        }else if (routeitem.getStopStatus() == 3) {
            holder.realtime.setText("末班車已過");
        }else if (routeitem.getStopStatus() == 4) {
            holder.realtime.setText("今日未營運");
        }

        //holder.realtime.setText("" + routeitem.getEstimateTime() / 60 + "分");
        holder.stationname.setText((CharSequence) routeitem.getRouteName().getZhTw());
        if(routeitem.getDirection()==0)holder.goroute.setText("往" + (CharSequence) routeitem.getDestinationStopNameZh());
        else  holder.goroute.setText("往" + (CharSequence) routeitem.getDepartureStopNameZh());
    }

    @Override
    public int getItemCount() {
        return routedata.size();
    }

    public class BusCrossStationViewHolder extends RecyclerView.ViewHolder {

        TextView realtime, stationname, goroute;

        public BusCrossStationViewHolder(@NonNull View itemView) {
            super(itemView);
            realtime = itemView.findViewById(R.id.realtime);
            stationname = itemView.findViewById(R.id.stationname);
            goroute = itemView.findViewById(R.id.goroute);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    routedata.get(index);
                    clickListener.onClickHello(view, index, routedata.get(index).getRouteID(), routedata.get(index).getRouteName().getZhTw());
                }
            });

        }

    }
}
