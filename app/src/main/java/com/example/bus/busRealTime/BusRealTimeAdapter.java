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
import com.example.bus.model.RouteEntity;
import com.example.bus.searchBusStation.SearchAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


/**
 * 1.recyclevie和busrealtime的連接
 * 2.連接dialog
 */
public class BusRealTimeAdapter extends RecyclerView.Adapter<BusRealTimeAdapter.BusRealTimeViewHolder> {


    private final Context context;
    private final String Routeid;
    private OnOpenDialogListener listener;
    private List<RouteData> routedata = new ArrayList<>();
   // private onItemClickListener clickListener;

    public void UpDateRoute(List<RouteData> queryResult) {
        routedata.clear();
        routedata.addAll(queryResult);
        notifyDataSetChanged();
    }

    public BusRealTimeAdapter(Context activity, String Routeid, OnOpenDialogListener listener) {
        this.context = activity;
        this.Routeid = Routeid;
        this.listener = listener;
    }

    interface OnOpenDialogListener {//應該要傳ＩＤ給他

        void onOpenDialog(String id, String name, String station, int directionid);
    }

    @NonNull
    @Override
    public BusRealTimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.busrealtimelist, parent, false);
        return new BusRealTimeViewHolder(view);

    }

    /**
     * 把stop和抵達時間連接view
     */
    @Override
    public void onBindViewHolder(@NonNull BusRealTimeViewHolder holder, int position) {


        RouteData routeitem = routedata.get(position);

        //判斷車子狀態
        if (routeitem.getStopStatus() == 0 ) {//狀態為正常
            //如果預估時間=0
            if(routeitem.getEstimateTime() < 1){
                holder.realtime.setText("進站中");
            }
            else{
                holder.realtime.setText(" " + routeitem.getEstimateTime() + "分");
            }
        } else if (routeitem.getStopStatus() == 1) { //1:'尚未發車
            if(routeitem.getEstimateTime() == 0) holder.realtime.setText("尚未發車");
            else holder.realtime.setText(" " + routeitem.getEstimateTime() + "分");

        }else if (routeitem.getStopStatus() == 2) {
            holder.realtime.setText("交管不停靠");
        }else if (routeitem.getStopStatus() == 3) {
            holder.realtime.setText("末班車已過");
        }else if (routeitem.getStopStatus() == 4) {
            holder.realtime.setText("今日未營運");
        }

        holder.station.setText(routeitem.getStopName().getZhTw());


    }

    @Override
    public int getItemCount() {
        return routedata.size();
    }

    public class BusRealTimeViewHolder extends RecyclerView.ViewHolder {
        TextView station, realtime;
        Button go, back;

        public BusRealTimeViewHolder(@NonNull View itemView) {
            super(itemView);
            station = itemView.findViewById(R.id.station);
            realtime = itemView.findViewById(R.id.realtime);

            //做dialog的連接
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    RouteData routeData = routedata.get(index);
                    listener.onOpenDialog(routeData.getStopID(),routeData.getStopName().getZhTw(),routeData.getStationID(),routeData.getDirection());//打開dialog
                }
            });


        }
    }
}
