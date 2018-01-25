package com.mycw.perfectmvp.activity;

//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.mycw.perfectmvp.R;
//import com.mycw.perfectmvp.appinfo.WeatherBean;
//import com.mycw.perfectmvp.request.APIService;
//import com.mycw.perfectmvp.util.FieldView;
//import com.mycw.perfectmvp.util.ViewBind;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.converter.scalars.ScalarsConverterFactory;
//
///**
// * 第一步:直接打开注释代码
// * //1.平时不使用mvp的时候
// */
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    @FieldView(R.id.tv_text)
//    private TextView textView;
//    @FieldView(R.id.bt_request)
//    private Button button;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ViewBind.bind(this);
//        button.setOnClickListener(this);
//    }
//
//    private void clickRequest(String cityId) {
//        //请求接口
//        Retrofit retrofit = new Retrofit.Builder()
//                //代表root地址
//                .baseUrl("http://www.weather.com.cn/")
//                //转换工厂
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        APIService apiService =retrofit.create(APIService.class);
//
//        Call<WeatherBean> weatherBeanCall = apiService.requestWeather(cityId);
//        weatherBeanCall.enqueue(new Callback<WeatherBean>() {
//            @Override
//            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
//                textView.setText(response.body().getWeatherinfo().toString());
//            }
//
//            @Override
//            public void onFailure(Call<WeatherBean> call, Throwable t) {
//
//            }
//        });
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        if( v.getId()==R.id.bt_request){
//            clickRequest("101010100");
//        }
//    }
//}


//1-----------------------------------...................-----------------------------------------------

//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.mycw.perfectmvp.R;
//import com.mycw.perfectmvp.appinfo.WeatherBean;
//import com.mycw.perfectmvp.imp.RequestView1;
//import com.mycw.perfectmvp.presenter.RequestPresenter1;
//import com.mycw.perfectmvp.util.FieldView;
//import com.mycw.perfectmvp.util.ViewBind;
//
///**
// * 第二步：对应  1
// * 2，最简单的mvp模式,
// * 1.Activity需要实现v层接口
// * 2.Persenter需要持有v层引用和m层引用
// * 3.在实现类view中创建persenter
// */
//public class MainActivity extends AppCompatActivity implements View.OnClickListener ,RequestView1 {
//    @FieldView(R.id.tv_text)
//    private TextView textView;
//    private RequestPresenter1 presenter;
//    @FieldView(R.id.bt_request)
//    private Button button;
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ViewBind.bind(this);
//        button.setOnClickListener(this);
//        //为了第二种
//        presenter = new RequestPresenter1(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.bt_request) {
//            presenter.clickRequest("101010100");
//        }
//    }
//
//    @Override
//    public void requestLoading() {
//        textView.setText("请求中,请稍后...");
//    }
//
//    @Override
//    public void resultSuccess(WeatherBean result) {
//        //成功
//        textView.setText(result.getWeatherinfo().toString());
//    }
//
//    @Override
//    public void resultFailure(String result) {
//        //失败
//        textView.setText(result);
//    }
//}


//2-------------------------------------------------------------------------------------------------------

//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.mycw.perfectmvp.R;
//import com.mycw.perfectmvp.appinfo.WeatherBean;
//import com.mycw.perfectmvp.imp.RequestView2;
//import com.mycw.perfectmvp.presenter.RequestPresenter2;
//import com.mycw.perfectmvp.util.FieldView;
//import com.mycw.perfectmvp.util.ViewBind;
//
//
///**
// * 第三步： 2
// * 上面的问题：
// * 1.是会内存泄露，因为persenter一直持有Activity，如果一个发了一个请求，但是网络有点慢，这个时候退出Activity，那么请求回来后还是会调用
// * Activity的回调方法，这里还是因为一直持有的问题
// * 2.如果已经退出了当前界面，这个请求也没有用了，这个时候我们可以断开请求
// * <p>
// * 解决问题：
// * 1.增加绑定和解绑的方法来解决内存泄露和退出后还会回调的问题
// * 2、增加断开网络连接的方法
// */
//public class MainActivity extends AppCompatActivity implements RequestView2, View.OnClickListener {
//    @FieldView(R.id.tv_text)
//    private TextView textView;
//    private RequestPresenter2 presenter2;
//    @FieldView(R.id.bt_request)
//    private Button button;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ViewBind.bind(this);
//        button.setOnClickListener(this);
//        //为了第二种
//        presenter2 = new RequestPresenter2();
//        presenter2.attach(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.bt_request) {
//            presenter2.clickRequest("101010100");
//        }
//    }
//
//    @Override
//    public void requestLoading() {
//        textView.setText("请求中,请稍后...");
//    }
//
//    @Override
//    public void resultSuccess(WeatherBean result) {
//        //成功
//        textView.setText(result.getWeatherinfo().toString());
//    }
//
//    @Override
//    public void resultFailure(String result) {
//        //失败
//        textView.setText(result);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        presenter2.detach();
//        presenter2.interruptHttp();
//    }
//}


// 3-------------------------------------------------------------------------

//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.mycw.perfectmvp.R;
//import com.mycw.perfectmvp.appinfo.WeatherBean;
//import com.mycw.perfectmvp.imp.RequestView3;
//import com.mycw.perfectmvp.presenter.RequestPresenter3;
//import com.mycw.perfectmvp.util.FieldView;
//import com.mycw.perfectmvp.util.ViewBind;
//
//
///**
// * 第四步: 3
// * 上面的问题：
// * 1.Presenter中attach和detach每个Presenter都需要定义这个方法
// * 解决问题：
// * 抽象出basePresenter
// * 但是如果抽象出BasePresenter，那么attach方法中的view就不能写死，那么就需要泛型设计
// */
//public class MainActivity extends AppCompatActivity implements RequestView3, View.OnClickListener {
//    @FieldView(R.id.tv_text)
//    private TextView textView;
//    @FieldView(R.id.bt_request)
//    private Button button;
//    private RequestPresenter3 presenter;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ViewBind.bind(this);
//        button.setOnClickListener(this);
//        presenter=new RequestPresenter3();
//        presenter.attachMvpView(this);
//    }
//
//
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.bt_request:
//                presenter.clickRequest("101010100");
//                break;
//        }
//    }
//    @Override
//    public void requestLoading() {
//        textView.setText("请求中,请稍后...");
//    }
//
//    @Override
//    public void resultSuccess(WeatherBean result) {
//        //成功
//        textView.setText(result.getWeatherinfo().toString());
//    }
//
//    @Override
//    public void resultFailure(String result) {
//        //失败
//        textView.setText(result);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        presenter.detachMvpView();
//        presenter.interruptHttp();
//    }
//}


//-----------------------------------------------------------------------------------------


//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.mycw.perfectmvp.R;
//import com.mycw.perfectmvp.appinfo.WeatherBean;
//import com.mycw.perfectmvp.base.AbstractMvpActivity;
//import com.mycw.perfectmvp.imp.RequestView4;
//import com.mycw.perfectmvp.presenter.RequestPresenter4;
//import com.mycw.perfectmvp.util.FieldView;
//import com.mycw.perfectmvp.util.ViewBind;
//
///**
// * 第五步: 4
// * 上面的问题：
// * 1.每个Activity都需要调用attach和detach两个方法，
// * 解决问题：
// * 我们可以将他们抽到基类中
// */
//public class MainActivity extends AbstractMvpActivity<RequestView4, RequestPresenter4> implements RequestView4, View.OnClickListener {
//
//    @FieldView(R.id.tv_text)
//    private TextView textView;
//    @FieldView(R.id.bt_request)
//    private Button button;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ViewBind.bind(this);
//        button.setOnClickListener(this);
//    }
//
//    /**
//     * 创建Presenter
//     *
//     * @return RequestPresenter4
//     */
//    @Override
//    protected RequestPresenter4 createPresenter() {
//        return new RequestPresenter4();
//    }
//
//    @Override
//    public void requestLoading() {
//        textView.setText("请求中,请稍后...");
//    }
//
//    @Override
//    public void resultSuccess(WeatherBean result) {
//        //成功
//        textView.setText(result.getWeatherinfo().toString());
//    }
//
//    @Override
//    public void resultFailure(String result) {
//        //失败
//        textView.setText(result);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.bt_request:
//                getPresenter().clickRequest("101010100");
//                break;
//        }
//    }
//}

//-------------------------------------------------------------------------------------------------------


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mycw.cwlibrary.factory.CreatePresenter;
import com.mycw.cwlibrary.view.AbstractMvpAppCompatActivity;
import com.mycw.perfectmvp.R;
import com.mycw.perfectmvp.appinfo.WeatherBean;
import com.mycw.perfectmvp.demo5.RequestPresenter5;
import com.mycw.perfectmvp.demo5.RequestView5;
import com.mycw.perfectmvp.util.FieldView;
import com.mycw.perfectmvp.util.ViewBind;

@CreatePresenter(RequestPresenter5.class)
public class MainActivity extends AbstractMvpAppCompatActivity<RequestView5, RequestPresenter5> implements RequestView5, View.OnClickListener {

    @FieldView(R.id.tv_text)
    private TextView textView;
    @FieldView(R.id.bt_request)
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewBind.bind(this);
        button.setOnClickListener(this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        if (savedInstanceState != null) {
            Log.e("perfect-mvp", "MainActivity  onCreate 测试  = " + savedInstanceState.getString("test"));
        }
    }

    @Override
    public void requestLoading() {
        textView.setText("请求中,请稍后...");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("perfect-mvp", "MainActivity onSaveInstanceState 测试");
        outState.putString("test", "test_save");
    }

    @Override
    public void resultSuccess(WeatherBean result) {
        //成功
        textView.setText(result.getWeatherinfo().toString());
    }

    @Override
    public void resultFailure(String result) {
        //失败
        textView.setText(result);
    }

    @Override
    public void onClick(View v) {
        Log.e("perfect-mvp", "点击事件");
        getMvpPresenter().clickRequest("101010100");
    }
}