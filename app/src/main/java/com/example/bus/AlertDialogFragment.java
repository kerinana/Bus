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

    public AlertDialogFragment(ArriveNotification data) {
        min=data.getMin();
        name=data.getRouteName();

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
        minArrive.setText(min+"分鐘後到站");
        canclebutton.setOnClickListener(new View.OnClickListener() {//取消
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        return rootView;
    }



}
