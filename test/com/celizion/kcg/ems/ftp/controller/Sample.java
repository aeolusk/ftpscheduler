package com.celizion.kcg.ems.ftp.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

public class Sample {
	@Test
	void testSkipHoliday() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar calc = Calendar.getInstance();
		calc.set(Calendar.YEAR, 2021);
		calc.set(Calendar.MONTH, Calendar.JANUARY);
		calc.set(Calendar.DAY_OF_MONTH, 1);
		calc.set(Calendar.HOUR_OF_DAY, 12);
		calc.set(Calendar.MINUTE, 0);
		calc.set(Calendar.SECOND, 0);
		
		int START_MONEY = 1000000;
		int PAY_DAILY = 4200;

		int loanRemain = START_MONEY;
		double totalLoan = 0.0D;
		int totalPay = 0;

		System.out.println("start date = " + formatter.format(calc.getTime()));
		for (int i = 0; i < 365; i++) {
			int dayOfWeek = calc.get(Calendar.DAY_OF_WEEK); 
			if(dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) {
				totalLoan += loanRemain;
				calc.add(Calendar.DAY_OF_YEAR, 1);
				continue;
			}

			totalPay += PAY_DAILY;
			loanRemain -= PAY_DAILY;
			totalLoan += loanRemain;
			
			calc.add(Calendar.DAY_OF_YEAR, 1);
		}

		double avrLoan = totalLoan / 365;

		System.out.println("final date = " + formatter.format(calc.getTime()));
		System.out.println(String.format("lone average is %.2f, interest = %d, interest rate is = %.2f", avrLoan,
				totalPay, (totalPay * 1.0D - START_MONEY) / avrLoan));
	}
	
	@Test
	void testOnceOnMonday() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar calc = Calendar.getInstance();
		calc.set(Calendar.YEAR, 2021);
		calc.set(Calendar.MONTH, Calendar.JANUARY);
		calc.set(Calendar.DAY_OF_MONTH, 1);
		calc.set(Calendar.HOUR_OF_DAY, 12);
		calc.set(Calendar.MINUTE, 0);
		calc.set(Calendar.SECOND, 0);
		
		int START_MONEY = 1000000;
		int PAY_DAILY = 21000;

		int loanRemain = START_MONEY;
		double totalLoan = 0.0D;
		int totalPay = 0;

		System.out.println("start date = " + formatter.format(calc.getTime()));
		for (int i = 0; i < 365; i++) {
			int dayOfWeek = calc.get(Calendar.DAY_OF_WEEK); 
			if(dayOfWeek != Calendar.MONDAY) {
				totalLoan += loanRemain;
				calc.add(Calendar.DAY_OF_YEAR, 1);
				continue;
			}

			totalPay += PAY_DAILY;
			loanRemain -= PAY_DAILY;
			totalLoan += loanRemain;
			
			calc.add(Calendar.DAY_OF_YEAR, 1);
		}

		double avrLoan = totalLoan / 365;

		System.out.println("final date = " + formatter.format(calc.getTime()));
		System.out.println(String.format("lone average is %.2f, interest = %d, interest rate is = %.2f", avrLoan,
				totalPay, (totalPay * 1.0D - START_MONEY) / avrLoan));
	}
	
}
