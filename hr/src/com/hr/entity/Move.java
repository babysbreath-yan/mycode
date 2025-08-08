package com.hr.entity;

public class Move {
private int id;
private int employee_number;
private int before;
private int after;
private String time;
private String manager;
private String notes;
public Move(int id, int employee_number, int before, int after, String time, String manager, String notes) {
	super();
	this.id = id;
	this.employee_number = employee_number;
	this.before = before;
	this.after = after;
	this.time = time;
	this.manager = manager;
	this.notes = notes;
}
public Move() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getEmployee_number() {
	return employee_number;
}
public void setEmployee_number(int employee_number) {
	this.employee_number = employee_number;
}
public int getBefore() {
	return before;
}
public void setBefore(int before) {
	this.before = before;
}
public int getAfter() {
	return after;
}
public void setAfter(int after) {
	this.after = after;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getManager() {
	return manager;
}
public void setManager(String manager) {
	this.manager = manager;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
public Move(int employee_number, int before, int after, String time, String manager, String notes) {
	super();
	this.employee_number = employee_number;
	this.before = before;
	this.after = after;
	this.time = time;
	this.manager = manager;
	this.notes = notes;
}

}
