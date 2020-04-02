package com.techworks.frameworktest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.techworks.eatmubaraklibrary.EatMubarakWidget;
import com.techworks.eatmubaraklibrary.UserInfo;

public class MainActivity extends AppCompatActivity {

    private int intentCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LocalBroadcastManager.getInstance(this).registerReceiver(analyticsReceiver, new IntentFilter("EM_ANALYTICS"));

        Button btn_stg_res = findViewById(R.id.btn_stg_res);
        btn_stg_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserContact("+923212121081");           // User's Phone Number
                userInfo.setUserEmail("usama@appsnado.com");        // User's Email Address
                userInfo.setUserName("Devs Appsnado");              // User's Name
                Intent i = EatMubarakWidget.Builder.getBuilder()
                        .setUserInfo(userInfo)                      // User Information Object
                        .setLocation(67.0642024, 24.8786511) // Set Location (Longitude , Latitude)
                        .setApiKey("your_api_key")
                        .setTimeOut(30)                             // Set Time in Seconds
                        .build(MainActivity.this);          // Your Current Context
                startActivityForResult(i, intentCode);
            }
        });

        Button btn_stg_menu = findViewById(R.id.btn_stg_menu);
        btn_stg_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserContact("+923212121081");           // User's Phone Number
                userInfo.setUserEmail("usama@appsnado.com");        // User's Email Address
                userInfo.setUserName("Devs Appsnado");              // User's Name
                Intent i = EatMubarakWidget.Builder.getBuilder()
                        .setUserInfo(userInfo)                      // User Information Object
                        .setLocation(67.0642024, 24.8786511) // Set Location (Longitude , Latitude)
                        .setApiKey("your_api_key")
                        .setBranchId(203)
                        .setTimeOut(30)
                        .build(MainActivity.this);          // Your Current Context
                startActivityForResult(i, intentCode);
            }
        });

        Button btn_stg_order = findViewById(R.id.btn_stg_order);
        btn_stg_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserContact("+923212121081");           // User's Phone Number
                userInfo.setUserEmail("usama@appsnado.com");        // User's Email Address
                userInfo.setUserName("Devs Appsnado");              // User's Name
                Intent i = EatMubarakWidget.Builder.getBuilder()
                        .setUserInfo(userInfo)                      // User Information Object
                        .setLocation(67.0642024, 24.8786511) // Set Location (Longitude , Latitude)
                        .setApiKey("your_api_key")
                        .getOrderList(true)
                        .setTimeOut(30)
                        .build(MainActivity.this);          // Your Current Context
                startActivityForResult(i, intentCode);
            }
        });

        Button btn_live_res = findViewById(R.id.btn_live_res);
        btn_live_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserContact("+923212121081");           // User's Phone Number
                userInfo.setUserEmail("usama@appsnado.com");        // User's Email Address
                userInfo.setUserName("Devs Appsnado");              // User's Name
                Intent i = EatMubarakWidget.Builder.getBuilder()
                        .setUserInfo(userInfo)                      // User Information Object
                        .setLocation(67.0642024, 24.8786511) // Set Location (Longitude , Latitude)
                        .setApiKey("your_api_key")
                        .setStaging(false)
                        .setTimeOut(30)
                        .build(MainActivity.this);          // Your Current Context
                startActivityForResult(i, intentCode);
            }
        });

        Button btn_live_menu = findViewById(R.id.btn_live_menu);
        btn_live_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserContact("+923212121081");           // User's Phone Number
                userInfo.setUserEmail("usama@appsnado.com");        // User's Email Address
                userInfo.setUserName("Devs Appsnado");              // User's Name
                Intent i = EatMubarakWidget.Builder.getBuilder()
                        .setUserInfo(userInfo)                      // User Information Object
                        .setLocation(67.0642024, 24.8786511) // Set Location (Longitude , Latitude)
                        .setApiKey("your_api_key")
                        .setBranchId(203)
                        .setStaging(false)                          // Staging By Default
                        .setTimeOut(30)
                        .build(MainActivity.this);          // Your Current Context
                startActivityForResult(i, intentCode);
            }
        });

        Button btn_live_order = findViewById(R.id.btn_live_order);
        btn_live_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserContact("+923212121081");           // User's Phone Number
                userInfo.setUserEmail("usama@appsnado.com");        // User's Email Address
                userInfo.setUserName("Devs Appsnado");
                Intent i = EatMubarakWidget.Builder.getBuilder()
                        .setUserInfo(userInfo)                      // User Information Object
                        .setLocation(67.0642024, 24.8786511) // Set Location (Longitude , Latitude)
                        .setApiKey("your_api_key")
                        .setStaging(false)
                        .getOrderList(true)
                        .setTimeOut(30)
                        .build(MainActivity.this);          // Your Current Context
                startActivityForResult(i, intentCode);
            }
        });
    }

    private BroadcastReceiver analyticsReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getBundleExtra("EVENT_LOGIN") != null) {
                String userName = intent.getBundleExtra("EVENT_LOGIN").getString("UserName");
                String userPhone = intent.getBundleExtra("EVENT_LOGIN").getString("UserPhone");
                String timeStamp = intent.getBundleExtra("EVENT_LOGIN").getString("TimeStamp");
                //Add your code...
                Log.i("broadCastCallBack", "\nuserName -> " + userName + "\nuserPhone -> "
                        + userPhone + "\ntimeStamp -> " + timeStamp);

            } else if (intent.getBundleExtra("EVENT_BEGINCHECKOUT") != null) {
                String restName = intent.getBundleExtra("EVENT_BEGINCHECKOUT").getString("RestName");
                String branchAddress = intent.getBundleExtra("EVENT_BEGINCHECKOUT").getString("BranchAddress");
                String userName = intent.getBundleExtra("EVENT_BEGINCHECKOUT").getString("UserName");
                String userPhone = intent.getBundleExtra("EVENT_BEGINCHECKOUT").getString("UserPhone");
                String subtotal = intent.getBundleExtra("EVENT_BEGINCHECKOUT").getString("Subtotal");
                String timeStamp = intent.getBundleExtra("EVENT_BEGINCHECKOUT").getString("TimeStamp");
                //Add your code...
                Log.i("broadCastCallBack", "\nuserName -> " + userName + "\nuserPhone -> "
                        + userPhone + "\ntimeStamp -> " + timeStamp + "\nrestName -> " + restName
                        + "\nbranchAddress -> " + branchAddress + "\nsubtotal -> " + subtotal);

            } else if (intent.getBundleExtra("EVENT_RESTAURANTVIEWED") != null) {
                String restName = intent.getBundleExtra("EVENT_RESTAURANTVIEWED").getString("RestName");
                String branchAddress = intent.getBundleExtra("EVENT_RESTAURANTVIEWED").getString("BranchAddress");
                String userName = intent.getBundleExtra("EVENT_RESTAURANTVIEWED").getString("UserName");
                String userPhone = intent.getBundleExtra("EVENT_RESTAURANTVIEWED").getString("UserPhone");
                String timeStamp = intent.getBundleExtra("EVENT_RESTAURANTVIEWED").getString("TimeStamp");
                //Add your code...
                Log.i("broadCastCallBack", "\nuserName -> " + userName + "\nuserPhone -> "
                        + userPhone + "\ntimeStamp -> " + timeStamp + "\nrestName -> " + restName
                        + "\nbranchAddress -> " + branchAddress);

            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == intentCode){
                String orderId = data.getStringExtra("orderId");
                String amount = data.getStringExtra("orderAmount");
                String restaurantName = data.getStringExtra("restaurantName");
                String deliveryAddress = data.getStringExtra("deliveryAddress");
                String deliveryEta = data.getStringExtra("deliveryEta");
                String isCod = data.getStringExtra("isCod");
                String discountAmount = data.getStringExtra("discountAmount");
                String discountCode = data.getStringExtra("discountCode");
                Log.i("activityCallBack", "\norderId -> " + orderId + "\namount -> "
                        + amount + "\nrestaurantName -> " + restaurantName + "\ndeliveryAddress -> " + deliveryAddress
                        + "\ndeliveryEta -> " + deliveryEta + "\nisCod -> " + isCod + "\ndiscountAmount -> " + discountAmount + "\ndiscountCode -> " + discountCode);

                LocalBroadcastManager.getInstance(this).unregisterReceiver(analyticsReceiver);
                //Add your code
            }
        }

    }
}
