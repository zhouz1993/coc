package com.wis.testCase;

import java.util.Calendar;
import java.util.Scanner;

public class replacenbsp {
	/**

	* @param args

	*/

	public static void main(String[] args) {

	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

	System.out.print("请输入日期，格式为yyyy-MM: ");

	String s = scanner.nextLine();

	if(!s.matches("\\d{4}-\\d{2}")){

	System.out.println("日期格式输入错误");

	System.exit(0);

	}

	int count = 0;

	int month = Integer.parseInt(s.substring(5, 7));

	Calendar cal = Calendar.getInstance();

	cal.set(Calendar.YEAR, Integer.parseInt(s.substring(0, 4)));

	cal.set(Calendar.MONTH,  month - 1);

	cal.set(Calendar.DATE, 1);

	while(cal.get(Calendar.MONTH) < month){

	int day = cal.get(Calendar.DAY_OF_WEEK);

	if(!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)){

	count++;

	}

	cal.add(Calendar.DATE, 1);

	}

	System.out.println(count);

	System.out.println(getWorkDays(2017,02));
	
	}
	
	
	
	
	public static int getWorkDays(int year, int month) {
        int days = 0;
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        int maxDay = c.getActualMaximum(Calendar.DATE);
        for (int i = 0; i < maxDay; i++) {
            if (c.get(Calendar.DAY_OF_WEEK) != 6
                    && c.get(Calendar.DAY_OF_WEEK) != 7) {
                days++;
            }
            c.add(Calendar.DATE, 1);
        }
        return days;
    }
}
