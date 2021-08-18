package com.example.bus;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentManager;

public class  BusRealTimeDialogFragment extends DialogFragment {

    public BusRealTimeDialogFragment(){

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public AlertDialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        return new AlertDialog.Builder(getContext())
                .setTitle("Hi")
                .setMessage("Hello")
                .setPositiveButton("好喔", (dialogInterface, i) -> dismiss())
                .show();
    }


}
