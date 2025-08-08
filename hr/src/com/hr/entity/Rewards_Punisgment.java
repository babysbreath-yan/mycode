package com.hr.entity;

public class Rewards_Punisgment {
	  private int id;
	 private int employee_number;
	 private String  type;
	 private String  reason;
	 private String  money;
	 private String  time;
	 private String  manager;
	 private String  notes;
	public Rewards_Punisgment(int id, int employee_number, String type, String reason, String money, String time,
			String manager, String notes) {
		super();
		this.id = id;
		this.employee_number = employee_number;
		this.type = type;
		this.reason = reason;
		this.money = money;
		this.time = time;
		this.manager = manager;
		this.notes = notes;
	}
	public Rewards_Punisgment() {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
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
	 
	}
