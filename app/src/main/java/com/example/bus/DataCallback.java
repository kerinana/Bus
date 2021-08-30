package com.example.bus;

//取得物件Callback
public interface DataCallback<T> {
    void onSuccess(T data);

    void onFailure(String errorMessage);
}
