package com.example.pauljs.knock;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by pauljs on 10/19/2015.
 */

@Table(name = "Alarms")
public class Alarm extends Model {
    @Column(name = "Alarm")
    public boolean isOn;

    public Alarm() {
        super();
    }

    public static boolean isOn() {
        return new Select()
                .from(Alarm.class)
                .executeSingle() != null;
    }
}
