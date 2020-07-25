package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entiies.CarRental;
import model.entiies.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc =new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Enter Rental data: ");
		System.out.println("car Model:");
		String carModel=sc.nextLine();
		System.out.println("Pickuo(dd/MM/yyyy hh:ss):");
		Date start =sdf.parse(sc.nextLine());
		System.out.println("Return(dd/MM/yyyy hh:ss):");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
			
		System.out.println("Enter proc per hour:");
		double pricePerhour= sc.nextDouble();
		System.out.println("Enter price day:");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerDay, pricePerhour, new BrazilTaxService());
		
		rentalService.processInvoice(cr);
		
		
		System.out.println("INVOICE:");
		System.out.println("Basic Payment:"+String.format("%.2f",cr.getIncoice().getBasicPayment()));
		System.out.println("Tax"+String.format("%.2f",cr.getIncoice().getTax()));
		System.out.println("Total payment"+String.format("%.2f",cr.getIncoice().getTotalPayment()));
		
				
				sc.close();
	}

}