package model.services;

import model.entiies.CarRental;
import model.entiies.Invoice;

public class RentalService {
	
	private Double priceperDay;
	private Double pricePerhour;
	
	private TaxService  taxService;

	public RentalService(Double priceperDay, Double pricePerhour, TaxService taxService) {
	
		this.priceperDay = priceperDay;
		this.pricePerhour = pricePerhour;
		this.taxService = taxService;
	}

	public void processInvoice(CarRental carRental) {
		long t1 =carRental.getStart().getTime();
		long t2 =carRental.getFinish().getTime();
		double hours =(t2-t1)/1000/ 60/ 60;
		
		double basicPayment;
		if (hours <=12.0) {
			basicPayment = Math.ceil(hours)* pricePerhour;
		}else {
			basicPayment=Math.ceil(hours/24)*priceperDay;
		}
		double tax =taxService.tax(basicPayment);
		carRental.setIncoice(new Invoice(basicPayment,tax));
	
	}

}
