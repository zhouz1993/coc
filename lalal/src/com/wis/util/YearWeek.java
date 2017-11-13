package com.wis.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class YearWeek {
	
	/**
	 * 获取上一周
	 * @param yearWeek
	 * @return
	 * @throws ParseException 
	 */
	public static String getPreYearWeek(String yearWeek) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-ww"); 
		Date date = new Date();
		date= sdf.parse(yearWeek);
		Calendar c = Calendar.getInstance();
	    //过去七天
	    c.setTime(date);
	    c.add(Calendar.DATE, - 7);
	    Date d = c.getTime();
	    String preWeek = sdf.format(d);
	    System.out.println(preWeek);
	    return preWeek;
	}

	/**
	 * 获取当前周期
	 */
	public static int getCurrentWeek(){
		Date date = new Date();
		List<Week> weekList = getWeekList(date);
		for (Week week : weekList) {
			if(week.getStart().getTime() <= date.getTime() && date.getTime() <= week.getEnd().getTime()){
				return week.getIndex()+1;
			}
		}
		return 0;
	}
	
	/**
	 * 获取当前年和月
	 */
	public static String getCurrentYearWeek(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-ww");
		return sdf.format(date);
		/*List<Week> weekList = getWeekList(date);
		for (Week week : weekList) {
			if(week.getStart().getTime() <= date.getTime() && date.getTime() <= week.getEnd().getTime()){
				return (date.getYear()+1900) + "-" +(week.getIndex()+1);
			}
		}
		return null;*/
	}
	
	@SuppressWarnings("deprecation")
	private static void setMin(Date date){
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
	}
	
	@SuppressWarnings("deprecation")
	private static void setMax(Date date){
		date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
	};
	
	@SuppressWarnings("deprecation")
	private static List<Week> getWeekList(Date date){
		long oneDay = 24 * 3600 * 1000;
		
		Date min = new Date(date.getYear(), 0, 1);
		setMin(min);
		Date max = new Date(date.getYear(),11,31);
		setMax(max);
		
		List<Week> weekList = new ArrayList<Week>();
		
		for (int i = 0; min.getTime() < max.getTime(); i++) {
			Week week = new Week();
			week.setIndex(i);
			week.setStart(min);
			if(min.getDay() > 0){
				min = new Date(min.getTime() + (6- min.getDay()) * oneDay);
			}else{
				min = new Date(min.getTime() + 6 * oneDay);
			}
			setMax(min);
			week.setEnd(min);
			weekList.add(week);
			min = new Date(min.getTime() + oneDay);
			setMin(min);
		}
		
		if(weekList.get(weekList.size()-1).getEnd().getTime() > max.getTime()){
			weekList.get(weekList.size()-1).setEnd(max);
		}
		return weekList;
	}
	
	/**
	 * 获取前一个年和月
	 */
	@SuppressWarnings("deprecation")
	public static String getLastYearWeek(){
		Date date = new Date();
		List<Week> weekList = getWeekList(date);
		for (Week week : weekList) {
			if(week.getStart().getTime() <= date.getTime() && date.getTime() <= week.getEnd().getTime()){
				return (date.getYear()+1900) + "-" +(week.getIndex()+1);
			}
		}
		return null;
	}
	
	/**
	 * 获取前一个年和月
	 */
	@SuppressWarnings("deprecation")
	public static String getLastYearWeek(Date date){
		//Date date = new Date();
		List<Week> weekList = getWeekList(date);
		for (Week week : weekList) {
			if(week.getStart().getTime() <= date.getTime() && date.getTime() <= week.getEnd().getTime()){
				return (date.getYear()+1900) + "-" +(week.getIndex());
			}
		}
		return null;
	}
}



class Week{
	
	private int index;
	private Date start;
	private Date end;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
}