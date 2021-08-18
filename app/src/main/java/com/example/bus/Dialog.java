package com.example.bus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.bus.busRealTime.BusRealTime;
import com.example.bus.busStartTime.BusStartTime;

public class Dialog extends DialogFragment {


    private View rootView;

    public Dialog() {


    }
//
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
////        super.onCreateDialog(savedInstanceState);
////
////        return new AlertDialog.Builder(getContext())
////                .setTitle("Hi")
////                .setMessage("Hello")
////                .setPositiveButton("好喔", (dialogInterface, i) -> dismiss())
////                .show();
//    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);//刪除空白
        rootView = inflater.inflate(R.layout.dialoglist, null);

        Button canclebutton=rootView.findViewById(R.id.cancel);
        Button starttime=rootView.findViewById(R.id.button2);
        Button cross=rootView.findViewById(R.id.button3);
        Button alert=rootView.findViewById(R.id.button4);

        canclebutton.setOnClickListener(new View.OnClickListener() {//取消
            @Override
            public void onClick(View view) {
                //Intent intent=inflater.inflate(Dialog.this,)
                dismiss();
            }
        });

        starttime.setOnClickListener(new View.OnClickListener() {//發車時刻
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BusRealTime.class, BusStartTime.class);
                startActivity(intent);
                getActivity();

            }
        });

        cross.setOnClickListener(new View.OnClickListener() {//經此站公車
            @Override
            public void onClick(View view) {
                //Intent intent=inflater.inflate(Dialog.this,)

            }
        });

        alert.setOnClickListener(new View.OnClickListener() {//到站提醒
            @Override
            public void onClick(View view) {
                //Intent intent=inflater.inflate(Dialog.this,)

            }
        });



        return rootView;
    }

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}
