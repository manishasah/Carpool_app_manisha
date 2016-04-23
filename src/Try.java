/**
 * Created by manisha.sah on 21-04-2016.
 */
import java.util.*;
import java.lang.*;
import com.mongodb.*;


public class Try {
    public static void main(String args[]) {
        /*System.out.println("Name?");
        Scanner inp = new Scanner(System.in);
        String id = inp.nextLine(); */
        User u = new User();
        u.user();
    }
}
    class User {

        public static void user() {

            System.out.println("Name?");
            Scanner inp = new Scanner(System.in);
            String name = inp.nextLine();

            Offer a = new Offer();
            a.offer(name);

            /*System.out.println("Offerer:" + a.offerer);
            System.out.println("Travelling Date: " + a.travelDate);
            System.out.println("Destination: " + a.destination);
            System.out.println("Departure time: " + a.deptTime);
            System.out.println("Available Number of Seats: " + a.numOfSeats);
            System.out.println("Charged: " + a.charged);*/

            //Rider b = new Rider(name);

            //System.out.println("i ALSO EXIT" + " " + name);
        }
    }




    class Offer
    {
        static String offerer;
        static String travelDate;
        static String destination;
        static String deptTime;
        static String numOfSeats;
        static String charged;

        public static void offer(String n)
        {
            System.out.println ("     Hello"+ " "+ n);

            offerer=n;

            System.out.println("Travelling Date (dd/mm/yy)?");
            Scanner date = new Scanner(System.in);
            travelDate = date.nextLine();

            System.out.println("Destination?");
            Scanner dst = new Scanner(System.in);
            destination = dst.nextLine();

            System.out.println("Departue time (00:00/24 hrs format)?");
            Scanner time = new Scanner(System.in);
            deptTime = time.nextLine();

            System.out.println("Maximum no. of Riders?");
            Scanner seats = new Scanner(System.in);
            numOfSeats = seats.nextLine();

            System.out.println("Charged (Y/N)?");
            Scanner chrg= new Scanner(System.in);
            charged = chrg.nextLine();

            submit();
        }

        public static void submit()
        {
            MongoClient offer = new MongoClient();
            DB db = offer.getDB("offer");
            DBCollection adder = db.getCollection("adder");
            BasicDBObject info = new BasicDBObject();
            info.put("Name", offerer);
            info.put("Travelling Date",travelDate);
            info.put("Destination", destination);
            info.put("Departure time", deptTime);
            info.put("Maximum number of riders", numOfSeats);
            info.put("Charged", charged);

            adder.insert(info);

        }
    }

    /*class Rider
    {
        public Rider(String n)
        {
            System.out.println ("Hello"+ " "+ n);
        }
    }*/

//class Location{}

