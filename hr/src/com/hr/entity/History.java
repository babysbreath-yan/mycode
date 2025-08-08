package com.hr.entity;

public class History {
	  private int id;
	  private int employee_number;
	  private String name;
	  private String gender;
	  private String birthday;
	  private String telephone;
	  private String email;
	  private String address;
	  private String photo;
	  private String education;
	  private String in_time;
	  private String out_time;
	  private int department_number;
	  private int position_number;
	  private String status;
	  private String home;
	  private String notes;
	public History(int id, int employee_number, String name, String gender, String birthday, String telephone, String email,
			String address, String photo, String education, String in_time, String out_time, int department_number,
			int position_number, String status, String home, String notes) {
		super();
		this.id = id;
		this.employee_number = employee_number;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.photo = photo;
		this.education = education;
		this.in_time = in_time;
		this.out_time = out_time;
		this.department_number = department_number;
		this.position_number = position_number;
		this.status = status;
		this.home = home;
		this.notes = notes;
	}
	public History() {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getIn_time() {
		return in_time;
	}
	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}
	public String getOut_time() {
		return out_time;
	}
	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}
	public int getDepartment_number() {
		return department_number;
	}
	public void setDepartment_number(int department_number) {
		this.department_number = department_number;
	}
	public int getPosition_number() {
		return position_number;
	}
	public void setPosition_number(int position_number) {
		this.position_number = position_number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	  
	  
	}
