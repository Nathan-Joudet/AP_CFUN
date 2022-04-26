package com.cfun.cfun_jfx;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ticket {
	static Date date = Calendar.getInstance().getTime();
	static SimpleDateFormat day = new SimpleDateFormat("dd/MM/yyyy");
	static String currentday = day.format(date);
	
	static long hours = Calendar.getInstance().getTimeInMillis();
	static SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
	static String currentHour = hour.format(hours);
	
	public static String currentDay;
}
