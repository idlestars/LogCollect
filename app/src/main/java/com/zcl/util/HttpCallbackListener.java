package com.zcl.util;

/**
 * Created by 夜未央 on 2016/7/18.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
