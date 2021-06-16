package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservetaion;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check In date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check Out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservetion: Check-out must be after check-in date");
		} else {
			Reservetaion reservation = new Reservetaion(number, checkIn, checkOut);
			System.out.println("Reservetion: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Check In date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check Out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservetion dates for update must be future dates");
			}else if(!checkOut.after(checkIn)){
				System.out.println("Error in reservetion: Check-out must be after check-in date");
			}else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservetion: " + reservation);
			}
		}
		
		
		sc.close();
	}
}
