package pl.coderslab.crm.model;

public class OrderStatus {

	private int id;
	private String status;

	public OrderStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public OrderStatus() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + "]";
	}

}
