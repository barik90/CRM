package pl.coderslab.crm.model;

import java.sql.Date;

public class Orders {
	private int id;
	private Date dateOfAcceptRepair;
	private Date plannedStartDateOfTheRepair;
	private Date dateOfRepairStarted;
	private int employee_id;
	private String descriptionOfTheProblem;
	private String descriptionRepair;
	private int status_id;
	private int vehicle_id;
	private double repairCost;
	private double partsCost;
	private double costOfManHour;
	private int quantityOfManHour;

	public Orders(int id, Date dateOfAcceptRepair, Date plannedStartDateOfTheRepair, Date dateOfRepairStarted,
			int employee_id, String descriptionOfTheProblem, String descriptionRepair, int status_id, int vehicle_id,
			double repairCost, double partsCost, double costOfManHour, int quantityOfManHour) {
		super();
		this.id = id;
		this.dateOfAcceptRepair = dateOfAcceptRepair;
		this.plannedStartDateOfTheRepair = plannedStartDateOfTheRepair;
		this.dateOfRepairStarted = dateOfRepairStarted;
		this.employee_id = employee_id;
		this.descriptionOfTheProblem = descriptionOfTheProblem;
		this.descriptionRepair = descriptionRepair;
		this.status_id = status_id;
		this.vehicle_id = vehicle_id;
		this.repairCost = repairCost;
		this.partsCost = partsCost;
		this.costOfManHour = costOfManHour;
		this.quantityOfManHour = quantityOfManHour;
	}

	public Orders(Date dateOfAcceptRepair, Date plannedStartDateOfTheRepair, Date dateOfRepairStarted, int employee_id,
			String descriptionOfTheProblem, String descriptionRepair, int status_id, int vehicle_id, double repairCost,
			double partsCost, double costOfManHour, int quantityOfManHour) {
		super();
		this.dateOfAcceptRepair = dateOfAcceptRepair;
		this.plannedStartDateOfTheRepair = plannedStartDateOfTheRepair;
		this.dateOfRepairStarted = dateOfRepairStarted;
		this.employee_id = employee_id;
		this.descriptionOfTheProblem = descriptionOfTheProblem;
		this.descriptionRepair = descriptionRepair;
		this.status_id = status_id;
		this.vehicle_id = vehicle_id;
		this.repairCost = repairCost;
		this.partsCost = partsCost;
		this.costOfManHour = costOfManHour;
		this.quantityOfManHour = quantityOfManHour;
	}

	public Orders() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfAcceptRepair() {
		return dateOfAcceptRepair;
	}

	public void setDateOfAcceptRepair(Date dateOfAcceptRepair) {
		this.dateOfAcceptRepair = dateOfAcceptRepair;
	}

	public Date getPlannedStartDateOfTheRepair() {
		return plannedStartDateOfTheRepair;
	}

	public void setPlannedStartDateOfTheRepair(Date plannedStartDateOfTheRepair) {
		this.plannedStartDateOfTheRepair = plannedStartDateOfTheRepair;
	}

	public Date getDateOfRepairStarted() {
		return dateOfRepairStarted;
	}

	public void setDateOfRepairStarted(Date dateOfRepairStarted) {
		this.dateOfRepairStarted = dateOfRepairStarted;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getDescriptionOfTheProblem() {
		return descriptionOfTheProblem;
	}

	public void setDescriptionOfTheProblem(String descriptionOfTheProblem) {
		this.descriptionOfTheProblem = descriptionOfTheProblem;
	}

	public String getDescriptionRepair() {
		return descriptionRepair;
	}

	public void setDescriptionRepair(String descriptionRepair) {
		this.descriptionRepair = descriptionRepair;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public double getRepairCost() {
		return repairCost;
	}

	public void setRepairCost(double repairCost) {
		this.repairCost = repairCost;
	}

	public double getPartsCost() {
		return partsCost;
	}

	public void setPartsCost(double partsCost) {
		this.partsCost = partsCost;
	}

	public double getCostOfManHour() {
		return costOfManHour;
	}

	public void setCostOfManHour(double costOfManHour) {
		this.costOfManHour = costOfManHour;
	}

	public int getQuantityOfManHour() {
		return quantityOfManHour;
	}

	public void setQuantityOfManHour(int quantityOfManHour) {
		this.quantityOfManHour = quantityOfManHour;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", dateOfAcceptRepair=" + dateOfAcceptRepair + ", plannedStartDateOfTheRepair="
				+ plannedStartDateOfTheRepair + ", dateOfRepairStarted=" + dateOfRepairStarted + ", employee_id="
				+ employee_id + ", descriptionOfTheProblem=" + descriptionOfTheProblem + ", descriptionRepair="
				+ descriptionRepair + ", status_id=" + status_id + ", vehicle_id=" + vehicle_id + ", repairCost="
				+ repairCost + ", partsCost=" + partsCost + ", costOfManHour=" + costOfManHour + ", quantityOfManHour="
				+ quantityOfManHour + "]";
	}

}
