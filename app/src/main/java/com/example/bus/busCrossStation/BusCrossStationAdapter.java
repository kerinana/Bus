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

import java.util.List;

public class BusCrossStationAdapter extends RecyclerView.Adapter<BusCrossStationAdapter.BusCrossStationViewHolder>{

    List<RouteData> routedata;
    Context context;
    private BusCrossStationAdapter.onItemClickListener clickListener;
    public interface onItemClickListener {
        void onClickHello(View view, int position);
    }
    public void setOnItemClickListener(BusCrossStationAdapter.onItemClickListener listener) {
        this.clickListener = listener;
    }
    BusCrossStationAdapter(Context activity, List<RouteData> routedata){
        context=activity;
        this.routedata=routedata;
    }
    @NonNull
    @Override
    public BusCrossStationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.buscrossstationlist,parent,false);
        return  new BusCrossStationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusCrossStationViewHolder holder, int position) {
        RouteData routeitem=routedata.get(position);
        holder.realtime.setText(" "+routeitem.getGPSTime());
        holder.stationname.setText((CharSequence) routeitem.getRouteName());
        holder.goroute.setText((CharSequence) routeitem.getStopName());
    }

    @Override
    public int getItemCount() {
        return routedata.size();
    }

    public class BusCrossStationViewHolder extends RecyclerView.ViewHolder{

        TextView realtime,stationname,goroute;
        int t=1;//假
        public BusCrossStationViewHolder(@NonNull View itemView){
            super(itemView);
             realtime=itemView.findViewById(R.id.realtime);
             stationname=itemView.findViewById(R.id.stationname);
             goroute=itemView.findViewById(R.id.goroute);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index=getAdapterPosition();
                    routedata.get(index);
                    clickListener.onClickHello(view, index);
                }
            });

        }

    }
}
