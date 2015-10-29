package com.example.pauljs.knock;

import com.parse.Parse;

/**
 * Created by pauljs on 10/28/2015.
 */
public class Application extends com.activeandroid.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "7WuhMXcwmLGpVrsqftp6uJN3HbgSwSsy374ktElk", "rHRUOoaLBbCWkqvUVTlzPhUKPcIemp59IeeG7yBc");
    }
}
