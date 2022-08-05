package com.example.dubaothoitiet.presenter;

import android.content.Context;

import com.example.dubaothoitiet.SQLHelper;
import com.example.dubaothoitiet.event.IGetJSon;
import com.example.dubaothoitiet.event.ISql;
import com.example.dubaothoitiet.model.Contact;
import com.example.dubaothoitiet.model.ContactNhietDo;
import com.example.dubaothoitiet.model.OpenWeatherJSon;

import java.util.ArrayList;
import java.util.List;

public class ContactPresenter {
    ISql iSqliteDemo;
    Context context;
    SQLHelper sqlHelper;

    public ContactPresenter(ISql iSqliteDemo, Context context) {
        this.iSqliteDemo = iSqliteDemo;
        this.context = context;

    }

    public void onSaveContact(int id, String cityName, int nhietDo, String icon_hn, String icon_nm, String icon_nk,
                              String nhietdo_hn, String nhietdo_nm, String nhietdo_nk, String gio, int nhietdo_cm, int doam, String apsuat){
        try {
            if(sqlHelper == null) sqlHelper = new SQLHelper(context);
            sqlHelper.insertContact(id, cityName, nhietDo, icon_hn, icon_nm, icon_nk, nhietdo_hn, nhietdo_nm, nhietdo_nk, gio, nhietdo_cm, doam, apsuat);
            iSqliteDemo.onSuccessFil();
        }catch (Exception e){
            iSqliteDemo.onMessenger(e.getMessage());
        }
    }

    public void onSaveContactNhietDo(int id, String time, int nhietdo, String icon){
        try {
            if(sqlHelper == null) sqlHelper = new SQLHelper(context);
            sqlHelper.insertContactNhietdo(id, time, nhietdo, icon);
            iSqliteDemo.onSuccessFil();
        }catch (Exception e){
            iSqliteDemo.onMessenger(e.getMessage());
        }
    }

    public void onEditContact(int id, String cityName, int nhietDo, String description, String icon_hn, String icon_nm, String icon_nk, String nhietdo_hn, String nhietdo_nm, String nhietdo_nk, String gio, int nhietdo_cm, int doam, String apsuat){
        try {
            if(sqlHelper == null) sqlHelper = new SQLHelper(context);
            sqlHelper.updateContact(new Contact(id, cityName, nhietDo, description, icon_hn, icon_nm, icon_nk, nhietdo_hn, nhietdo_nm, nhietdo_nk, gio, nhietdo_cm, doam, apsuat));
            iSqliteDemo.onSuccessFil();
        }catch (Exception e){
            iSqliteDemo.onMessenger(e.getMessage());
        }
    }


    public void onEditContactNhietDo(int id, String time, int nhietdo, String icon){
        try {
            if(sqlHelper == null) sqlHelper = new SQLHelper(context);
            sqlHelper.updateContactNhietDo(new ContactNhietDo(id, time, nhietdo, icon));
            iSqliteDemo.onSuccessFil();
        }catch (Exception e){
            iSqliteDemo.onMessenger(e.getMessage());
        }
    }

    public void onDeleteContact(int id){
        try {
            if(sqlHelper == null) sqlHelper = new SQLHelper(context);
            sqlHelper.deleteContactNhietDo(id);
            iSqliteDemo.onSuccessFil();
        }catch (Exception e){
            iSqliteDemo.onMessenger(e.getMessage());
        }
    }



}
