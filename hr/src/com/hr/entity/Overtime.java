package com.hr.entity;

public class Overtime {
private int id;
private int department_number;
private int employee_number;
private String day;
private String start_time;
private String end_time;
private String notes;
public Overtime(int id, int department_number, int employee_number, String day, String start_time, String end_time,
		String notes) {
	super();
	this.id = id;
	this.department_number = department_number;
	this.employee_number = employee_number;
	this.day = day;
	this.start_time = start_time;
	this.end_time = end_time;
	this.notes = notes;
}
public Overtime() {
	super();
	// TODO Auto-generated constructor stub
}
public Overtime(int department_number, int employee_number, String day, String start_time, String end_time,
		String notes) {
	super();
	this.department_number = department_number;
	this.employee_number = employee_number;
	this.day = day;
	this.start_time = start_time;
	this.end_time = end_time;
	this.notes = notes;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getDepartment_number() {
	return department_number;
}
public void setDepartment_number(int department_number) {
	this.department_number = department_number;
}
public int getEmployee_number() {
	return employee_number;
}
public void setEmployee_number(int employee_number) {
	this.employee_number = employee_number;
}
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
public String getStart_time() {
	return start_time;
}
public void setStart_time(String start_time) {
	this.start_time = start_time;
}
public String getEnd_time() {
	return end_time;
}
public void setEnd_time(String end_time) {
	this.end_time = end_time;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}

}
