package com.wis.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class YearMonth {
	/**
	 * 计算当前日期所在月的上个月
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getPreYearMonth(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(date)); // 设置时间
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月 
		String preYearMonth = sdf.format(calendar.getTime());//当前日期的上个月
		return preYearMonth;
	}
	
	/**
	 * 计算当前日期所在月的下个月
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getNextYearMonth(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(date)); // 设置时间
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1); // 设置为上一个月 
		String preYearMonth = sdf.format(calendar.getTime());//当前日期的上个月
		return preYearMonth;
	}
	
	/**
	 * 两个日期之间相差的月数
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static int getMonthSpace(String date1, String date2) throws ParseException {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
        result = (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12 + c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        return result == 0 ? 1 : Math.abs(result);
    }
	
}