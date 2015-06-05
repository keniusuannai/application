package com.tage.util;

import java.util.Calendar;

public class DateUtil {
	/**
	 * 是否是闰年
	 * 
	 * @param year
	 * @return
	 */
	public static boolean judge(int year) {
		boolean yearleap = (year % 400 == 0) || (year % 4 == 0)
				&& (year % 100 != 0);
		return yearleap;
	}

	/**
	 * 判断当前月份的天数
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getdays(int year, int month) {
		boolean yearleap = judge(year);
		int day;
		if (yearleap && month == 2) {
			day = 29;
		} else if (!yearleap && month == 2) {
			day = 28;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = 30;
		} else {
			day = 31;
		}
		return day;
	}

	/**
	 * 获取当前年月
	 * 
	 * @return
	 */
	public static int[] getYYMM() {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		return new int[]{year,month};

	}
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
	    int day = cal.get(Calendar.DATE);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int year = cal.get(Calendar.YEAR);
	    int dow = cal.get(Calendar.DAY_OF_WEEK);
	    int dom = cal.get(Calendar.DAY_OF_MONTH);
	    int doy = cal.get(Calendar.DAY_OF_YEAR);

	    System.out.println("Current Date: " + cal.getTime());
	    System.out.println("Day: " + day);
	    System.out.println("Month: " + month);
	    System.out.println("Year: " + year);
	    System.out.println("Day of Week: " + dow);
	    System.out.println("Day of Month: " + dom);
	    System.out.println("Day of Year: " + doy);
	    System.out.println(getYYMM());
	}
}