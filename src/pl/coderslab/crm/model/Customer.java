package pl.coderslab.crm.model;

import java.sql.Date;

public class Customer {
	private int id;
	private String name;
	private String surname;
	private Date dateOfBirth;
	private int vehicleId;

	public Customer(int id, String name, String surname, Date dateOfBirth, int vehicleId) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.vehicleId = vehicleId;
	}

	public Customer(String name, String surname, Date dateOfBirth, int vehicleId) {
		super();
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.vehicleId = vehicleId;
	}

	public Customer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth
				+ ", vehicleId=" + vehicleId + "]";
	}

}
