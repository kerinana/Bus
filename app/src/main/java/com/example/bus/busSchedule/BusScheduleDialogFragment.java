package com.example.bus.busSchedule;
 import android.os.Bundle;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.Button;
import android.widget.LinearLayout;

 import androidx.annotation.NonNull;
 import androidx.annotation.Nullable;

 import com.example.bus.DialogFragment;
 import com.example.bus.R;

public class BusScheduleDialogFragment extends DialogFragment {
        private Button three, five, seven,eleven,btn_cancel;
        private LinearLayout layout;
        private View rootView;
        private onItemClickListener clickListener;


    public  interface onItemClickListener{  //busrealtime要做的事的方法
        void onClickthree(View view, int position);
        void onClickfive(View view, int position);
        void onClickseven(View view, int position);
        void onClickeleven(View view, int position);

    }
    public void setOnItemClickListener(BusScheduleDialogFragment.onItemClickListener listener){//放耳朵
        this.clickListener=listener;

    }
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);

            rootView = inflater.inflate(R.layout.alertmenue, null);
            three =rootView.findViewById(R.id.three);
            five = (Button) rootView.findViewById(R.id.five);
            seven = (Button) rootView.findViewById(R.id.seven);
            eleven = (Button) rootView.findViewById(R.id.eleven);
            btn_cancel = (Button) rootView.findViewById(R.id.btn_cancel);

////新增按鈕監聽
            three.setOnClickListener(new View.OnClickListener(){//三分鐘
                @Override
                public void onClick(View view) {     //裡面做判斷時間（小於三分鐘就跳）dialog

                }
            });


            five.setOnClickListener(new View.OnClickListener(){//五分鐘
                @Override
                public void onClick(View view) {//裡面做判斷時間（小於5分鐘就跳）dialog

                }
            });
            seven.setOnClickListener(new View.OnClickListener(){//七分鐘
                @Override
                public void onClick(View view) {//裡面做判斷時間（小於7分鐘就跳）dialog

                }
            });
            eleven.setOnClickListener(new View.OnClickListener(){//十一分鐘
                @Override
                public void onClick(View view) {//裡面做判斷時間（小於11分鐘就跳）dialog

                }
            });
            btn_cancel.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
            return rootView;
        }

    //看看在幹嘛
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.three:
                    break;
                case R.id.five:
                    break;
                case R.id.seven:
                    break;
                case R.id.eleven:
                    break;
                case R.id.btn_cancel:
                    dismiss();
                    break;
                default:
                    break;
            }
//            finish();
            dismiss();
        }
    }