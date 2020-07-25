package model.entiies;

import java.util.Date;

public class CarRental {
	
	private Date start;
	private Date Finish; 
	
	private Vehicle vehicle;
	private Invoice incoice;
	
	public CarRental( ) {
		
	}

	public CarRental(Date start, Date finish, Vehicle vehicle) {
		
		this.start = start;
		this.Finish = finish;
		this.vehicle = vehicle;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return Finish;
	}

	public void setFinish(Date finish) {
		Finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getIncoice() {
		return incoice;
	}

	public void setIncoice(Invoice incoice) {
		this.incoice = incoice;
	}
	
}
