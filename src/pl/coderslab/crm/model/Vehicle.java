package pl.coderslab.crm.model;

import java.sql.Date;

public class Vehicle {
	private int id;
	private String model;
	private String mark;
	private Date yearOfProduction;
	private String registrationNumber;
	private Date dateOfTheNextTechnicalInspection;

	public Vehicle(int id, String model, String mark, Date yearOfProduction, String registrationNumber,
			Date dateOfTheNextTechnicalInspection) {
		super();
		this.id = id;
		this.model = model;
		this.mark = mark;
		this.yearOfProduction = yearOfProduction;
		this.registrationNumber = registrationNumber;
		this.dateOfTheNextTechnicalInspection = dateOfTheNextTechnicalInspection;
	}

	public Vehicle(String model, String mark, Date yearOfProduction, String registrationNumber,
			Date dateOfTheNextTechnicalInspection) {
		super();
		this.model = model;
		this.mark = mark;
		this.yearOfProduction = yearOfProduction;
		this.registrationNumber = registrationNumber;
		this.dateOfTheNextTechnicalInspection = dateOfTheNextTechnicalInspection;
	}

	public Vehicle() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Date getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(Date yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getDateOfTheNextTechnicalInspection() {
		return dateOfTheNextTechnicalInspection;
	}

	public void setDateOfTheNextTechnicalInspection(Date dateOfTheNextTechnicalInspection) {
		this.dateOfTheNextTechnicalInspection = dateOfTheNextTechnicalInspection;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", mark=" + mark + ", yearOfProduction=" + yearOfProduction
				+ ", registrationNumber=" + registrationNumber + ", dateOfTheNextTechnicalInspection="
				+ dateOfTheNextTechnicalInspection + "]";
	}

}
