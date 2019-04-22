package com.ferechamitbeyli.instagramparsecloseexample;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("J4lWBl4IEzujR5wTRVWYs3fggY4F0EdNsswB8NzD")
                        .clientKey("8Y4C33ltfiugnh600kxd9pZxMsYbbMLTjgiUQbTU")
                        .server("https://parseapi.back4app.com/")
                        .build());

    }
}
