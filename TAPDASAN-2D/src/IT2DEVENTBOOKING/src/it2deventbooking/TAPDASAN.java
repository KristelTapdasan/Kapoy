package it2deventbooking;

import it2eventbooking.config;
import java.util.Scanner;


public class IT2DEVENTBOOKING {

    public static void main(String[] args) {
   
        Scanner sc = new Scanner (System.in);
        String response;
        do{
        
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.println("Enter Action: ");
        int action = sc.nextInt();
        IT2DEVENTBOOKING customer = new IT2DEVENTBOOKING();

        switch(action){
            case 1:
                customer.addeventplanner();
                break;
            case 2:
                customer.vieweventplanner();

                break;
              
        }
        System.out.println("Do you want to continue? (yes/no)");
        response = sc.next();
    }while(response.equalsIgnoreCase("yes"));
    System.out.println("Thank You, See you soonest!");
    
    }

    public void addeventplanner(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("First Name: ");
        String fname = sc.next();
        System.out.print("Date: ");
        String date = sc.next();
        System.out.print("Location: ");
        String loc = sc.next();
        System.out.print("Attendees: ");
        String attn = sc.next();

        String sql = "INSERT INTO tbl_eventplanner (e_fname, e_date, e_location, e_attendees) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, fname, date, loc, attn);


    }
   
    private void vieweventplanner() {
        config conf = new config();
        String votersQuery = "SELECT * FROM tbl_eventplanner";
        String[] votersHeaders = {"E_ID", "E_FNAME", "E_DATE", "E_LOCATION", "E_ATTENDEES"};
        String[] votersColumns = {"E_id", "e_fname", "e_date", "e_location", "e_attendees"};

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }

    
    }
    

    
    

