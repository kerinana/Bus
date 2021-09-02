package com.example.bus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AlertDialogFragment extends androidx.fragment.app.DialogFragment{

    private View rootView;
    int min;
    String name;
    int status;

    public AlertDialogFragment(ArriveNotification data) {
        min=data.getMin();
        name=data.getRouteName();
        status=data.getStatus();

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.alertdialogfragment, null);

        Button canclebutton = rootView.findViewById(R.id.textView16);
        TextView routename = rootView.findViewById(R.id.textView14);
        TextView minArrive = rootView.findViewById(R.id.textView15);


        routename.setText(name+"號公車");
        //判斷車子狀態
        if (status == 0 ) {//狀態為正常
            if(min<3) minArrive.setText("即將到站");
            else minArrive.setText(min+"分鐘後到站");
        } else if (status== 1) { //1:'尚未發車
            minArrive.setText("尚未發車");
        }else if (status == 2) {
            minArrive.setText("交管不停靠");
        }else if (status == 3) {
            minArrive.setText("末班車已過");
        }else if (status == 4) {
            minArrive.setText("今日未營運");
        }




        canclebutton.setOnClickListener(new View.OnClickListener() {//取消
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        return rootView;
    }



}
