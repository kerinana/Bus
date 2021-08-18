package com.example.bus.busRealTime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;
import com.example.bus.RouteData;

import java.util.List;
import java.util.zip.Inflater;


/**
 * 1.recyclevie和busrealtime的連接
 * 2.連接dialog
 * */
public class BusRealTimeAdapter extends RecyclerView.Adapter<BusRealTimeAdapter.BusRealTimeViewHolder> {

    private final Context context;
    private final List<RouteData> routedata;
    private OnOpenDialogListener listener;

    public BusRealTimeAdapter(Context activity,List<RouteData> routedata,OnOpenDialogListener listener){
        this.context=activity;
        this.routedata=routedata;
        this.listener=listener;
    }
    interface OnOpenDialogListener {//應該要傳ＩＤ給他
        void onOpenDialog();
    }
    @NonNull
    @Override
    public BusRealTimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(context).inflate(R.layout.busrealtimelist, parent, false);
        return new BusRealTimeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BusRealTimeViewHolder holder, int position) {
        RouteData routeitem=routedata.get(position);
        holder.realtime.setText(" "+routeitem.getGPSTime());
        holder.station.setText((CharSequence) routeitem.getStopName());


    }

    @Override
    public int getItemCount() {
        return routedata.size();
    }

    public  class BusRealTimeViewHolder extends RecyclerView.ViewHolder{
        TextView station,realtime;
        Button go,back;

        public BusRealTimeViewHolder(@NonNull View itemView) {
            super(itemView);
            station=itemView.findViewById(R.id.station);
            realtime=itemView.findViewById(R.id.realtime);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index=getAdapterPosition();
                    RouteData routeData=routedata.get(index);

                    listener.onOpenDialog();
                }
            });


        }
    }
}
