package com.hr.entity;

public class Attendance {
	private int id;
	private int employee_number;
	private String day;
	private String time_type;
	private String start_time;
	private String start_type;
	private String end_time;
	private String end_type;
	private String work_type;
	private String notes;
	public Attendance(int id, int employee_number, String day, String time_type, String start_time, String start_type,
			String end_time, String end_type, String work_type, String notes) {
		super();
		this.id = id;
		this.employee_number = employee_number;
		this.day = day;
		this.time_type = time_type;
		this.start_time = start_time;
		this.start_type = start_type;
		this.end_time = end_time;
		this.end_type = end_type;
		this.work_type = work_type;
		this.notes = notes;
	}
	public Attendance() {
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
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime_type() {
		return time_type;
	}
	public void setTime_type(String time_type) {
		this.time_type = time_type;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getStart_type() {
		return start_type;
	}
	public void setStart_type(String start_type) {
		this.start_type = start_type;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getEnd_type() {
		return end_type;
	}
	public void setEnd_type(String end_type) {
		this.end_type = end_type;
	}
	public String getWork_type() {
		return work_type;
	}
	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
