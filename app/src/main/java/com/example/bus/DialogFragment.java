package com.example.bus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DialogFragment extends androidx.fragment.app.DialogFragment {


    private View rootView;
    private onItemClickListener clickListener;

    public DialogFragment() {


    }



    public interface onItemClickListener {
        void onClickstarttime(View view, int position);
        void onClickscrossbus(View view, int position);
    }
    public void setOnItemClickListener(DialogFragment.onItemClickListener listener) {
        this.clickListener = listener;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);//刪除空白
        rootView = inflater.inflate(R.layout.dialoglist, null);

        int position=1;//假資料

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
                clickListener.onClickstarttime(view,position);
            }
        });

        cross.setOnClickListener(new View.OnClickListener() {//經此站公車
            @Override
            public void onClick(View view) {
                clickListener.onClickscrossbus(view,position);

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
