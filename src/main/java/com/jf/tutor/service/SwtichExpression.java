package com.jf.tutor.service;

public class SwtichExpression implements BaseService{
	
	enum Day {SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;}
	
	@Override
	public void display() {
		System.out.println("====Calling Display=====");
		System.out.println(getDayInNumber());
		System.out.println(getDayInNumberYield());
		System.out.println(getDayInNumberYieldExp());
	}
	
	int getDayInNumber() {
		Day day = Day.MONDAY;
		return switch(day) {
		case SUNDAY,MONDAY,FRIDAY -> 6;
		case TUESDAY -> 7;
		case WEDNESDAY,THURSDAY,SATURDAY -> 8;
		default -> throw new IllegalStateException();
		};
	}
	
	int getDayInNumberYield() {
		Day day = Day.MONDAY;
		return switch(day) {
		case SUNDAY,MONDAY,FRIDAY: yield 6;
		case TUESDAY: yield 7;
		case WEDNESDAY,THURSDAY,SATURDAY: yield 8;
		default: throw new IllegalStateException();
		};
	}
	
	int getDayInNumberYieldExp() {
		Day day = Day.MONDAY;
		return switch(day) {
		case SUNDAY,MONDAY,FRIDAY -> { yield 6;}
		case TUESDAY -> { yield 7;}
		case WEDNESDAY,THURSDAY,SATURDAY-> { yield 8;}
		default-> throw new IllegalStateException();
		};
	}
}
