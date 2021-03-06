package com.cdbhe.plana.httpdemo;

import android.content.Context;

import com.cdbhe.plib.http.common.RequestParams;
import com.cdbhe.plib.http.retrofit.RetrofitClient;

public class HttpDemoPresenter extends CommonRequestCallback{
    private IHttpDemoBiz iHttpDemoBiz;
    public HttpDemoPresenter(IHttpDemoBiz iHttpDemoBiz) {
        super(iHttpDemoBiz.getActivity());
        this.iHttpDemoBiz = iHttpDemoBiz;
    }

    public void doRequest(){
        RequestParams.getInstance().addParam("token", "18383930457");
        RetrofitClient.getInstance().doPost("api/configure/findEmployee",RequestParams.paramMap, iHttpDemoBiz, this);
    }

    @Override
    public void onSuccess(int i, Object o) {
        super.onSuccess(i, o);
        //这里是请求成功并且status为1的时候返回的data数据 data数据为Data实体中的data泛型
        iHttpDemoBiz.refreshUIData(o.toString());
    }
}
