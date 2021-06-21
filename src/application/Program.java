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
			
			String error = reservation.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Error in reservetaion: " + error);
				
			}else {
					System.out.println("Reservetion: " + reservation);
				}
			}

		}
		sc.close();
	}
}
