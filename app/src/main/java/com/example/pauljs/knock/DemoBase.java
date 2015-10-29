
package com.example.pauljs.knock;

import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Baseclass of all Activities of the Demo Application.
 * 
 * @author Philipp Jahoda
 */
public abstract class DemoBase extends FragmentActivity {

    protected static String[] mMonths = new String[] {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public static String getMonthName(int num) {
        return mMonths[num];
    }

    public static String[] getXAxisLabels() {
        List<Hour> hours = getSortedHours();
        String[] labels = new String[hours.size()];
        for(int i = 0; i < hours.size(); i++) {
            Date date = hours.get(i).date;
            String strDate = getMonthName(date.getMonth()) + "  " + date.getDay();
            labels[i] = strDate;
        }
        return labels;
    }

    public static List<Hour> getSortedHours() {
        List<Hour> hours = Hour.getSortedHours();
        for(int i = 1; i < hours.size(); i++) {
            Date prev_date = hours.get(i - 1).date;
            Date cur_date = hours.get(i).date;
            if(prev_date.getDay() == cur_date.getDay() && prev_date.getMonth() == cur_date.getMonth() && prev_date.getYear() == cur_date.getYear()) {
                hours.remove(i - 1);
                i--;
            }
        }
        return hours;
    }

    public static List<Float> getAverageHours() {
        List<Hour> hours = getSortedHours();
        List<Float> averages = new ArrayList<Float>();
        float average = 0;
        for(int i = 0; i < hours.size(); i++) {
            float sum = average * i;
            sum += hours.get(i).number;
            average = sum / (i + 1);
            averages.add(average);
        }
        return averages;
    }

    protected String[] mParties = new String[] {
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
//    }
}
