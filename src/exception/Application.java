package exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

/**
 *
 * @author Felipe
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Romm Number: ");
        int number = sc.nextInt();
        System.out.print("CheckIn date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("CheckOut date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");

        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println();
            System.out.print("Reservation: " + reservation);
            System.out.println("Enter data to update the reservation: ");
            System.out.print("CheckIn date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("CheckOut date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();

            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDate(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }

            sc.close();
        }
    }
}
