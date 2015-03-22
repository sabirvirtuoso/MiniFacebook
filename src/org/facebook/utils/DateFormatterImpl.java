package org.facebook.utils;

/**
 * Created by Tanveer on 3/11/2015.
 */
public class DateFormatterImpl implements DateFormatter {

    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    @Override
    public String returnCurrentDate() {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat(dateFormat);
        String currentDateTime = sdf.format(dt);

        return currentDateTime;
    }
}
