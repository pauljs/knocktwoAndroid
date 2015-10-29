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

@Table(name = "Hours")
public class Hour extends Model {
    @Column(name = "Number")
    public int number;

    @Column(name = "Date")
    public Date date;

    @Column(name = "Day")
    public int day;

    public Hour() {
        super();
    }

    public Hour(int number, Date date) {
        super();
        this.number = number;
        this.date = date;
        this.day = date.getDay();
    }

    public String getFormattedString() {
        return "Date: " + date.toString() + "\nHours of Sleep: " + number;
    }

    public static Hour getByDay(Date date) {
        return new Select()
                .from(Hour.class)
                .where("Day = ?", date.getDay())
                .executeSingle();
    }

    public static List<Hour> getSortedHours() {
        return new Select()
                .from(Hour.class)
                .orderBy("Date ASC")
                .execute();
    }
}
