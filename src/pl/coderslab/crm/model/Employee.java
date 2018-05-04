package pl.coderslab.crm.model;

public class Employee {
	private int id;
	private String name;
	private String surname;
	private String address;
	private String phoneNumber;
	private String note;
	private double costOfManHour;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getCostOfManHour() {
		return costOfManHour;
	}

	public void setCostOfManHour(double costOfManHour) {
		this.costOfManHour = costOfManHour;
	}

	public Employee() {
	}

	public Employee(int id, String name, String surname, String address, String phoneNumber, String note,
			double costOfManHour) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.note = note;
		this.costOfManHour = costOfManHour;
	}

	public Employee(String name, String surname, String address, String phoneNumber, String note,
			double costOfManHour) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.note = note;
		this.costOfManHour = costOfManHour;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", note=" + note + ", costOfManHour=" + costOfManHour + "]";
	}

}
