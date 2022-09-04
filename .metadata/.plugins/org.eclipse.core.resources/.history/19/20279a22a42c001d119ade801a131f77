package com.nixartech.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {
	public static String formatInterval(final long l)
    {
        final long hr = TimeUnit.MILLISECONDS.toHours(l);
        final long min = TimeUnit.MILLISECONDS.toMinutes(l - TimeUnit.HOURS.toMillis(hr));
        final long sec = TimeUnit.MILLISECONDS.toSeconds(l - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min));
        final long ms = TimeUnit.MILLISECONDS.toMillis(l - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min) - TimeUnit.SECONDS.toMillis(sec));
        return String.format("%02d:%02d:%02d.%03d", hr, min, sec, ms);
    }
	/**
	 * 
	 * 
	 * G 	Era designator (before christ, after christ)
     * y 	Year (e.g. 12 or 2012). Use either yy or yyyy.
     * M 	Month in year. Number of M's determine length of format (e.g. MM, MMM or MMMMM)
     * d 	Day in month. Number of d's determine length of format (e.g. d or dd)
     * h 	Hour of day, 1-12 (AM / PM) (normally hh)
     * H 	Hour of day, 0-23 (normally HH)
     * m 	Minute in hour, 0-59 (normally mm)
     * s 	Second in minute, 0-59 (normally ss)
     * S 	Millisecond in second, 0-999 (normally SSS)
     * E 	Day in week (e.g Monday, Tuesday etc.)
     * D 	Day in year (1-366)
     * F 	Day of week in month (e.g. 1st Thursday of December)
     * w 	Week in year (1-53)
     * W 	Week in month (0-5)
     * a 	AM / PM marker
     * k 	Hour in day (1-24, unlike HH's 0-23)
     * K 	Hour in day, AM / PM (0-11)
     * z 	Time Zone
     * ' 	Escape for text delimiter
     * ' 	Single quote
     *
     * Pattern 	Example
     * dd-MM-yy 	31-01-12
     * dd-MM-yyyy 	31-01-2012
     * MM-dd-yyyy 	01-31-2012
     * yyyy-MM-dd 	2012-01-31
     * yyyy-MM-dd HH:mm:ss 	2012-01-31 23:59:59
     * yyyy-MM-dd HH:mm:ss.SSS 	2012-01-31 23:59:59.999
     * yyyy-MM-dd HH:mm:ss.SSSZ 	2012-01-31 23:59:59.999+0100
     * EEEEE MMMMM yyyy HH:mm:ss.SSSZ 	Saturday November 2012 10:45:42.720+0100
     * 
	 */
	public static String getTimestampAsString() {		
		String isoDatePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
		String dateString = simpleDateFormat.format(new Date());
		return dateString;
	}
	public static String getIsoDateAsString() {		
		String isoDatePattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
		String dateString = simpleDateFormat.format(new Date());
		return dateString;
	}
	public static String getISOTimesString() {		
		String isoDatePattern = "HHmmss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
		String dateString = simpleDateFormat.format(new Date());
		return dateString;
	}
}

