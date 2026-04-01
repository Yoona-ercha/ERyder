import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class BikeRental {

    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;

    UserRegistration userRegistration = new UserRegistration();

    ActiveRental activeRental;

    LinkedList<ActiveRental> activeRentalList = new LinkedList<>();

    public void simulateApplicationInput(){
        System.out.println("This is the simulation of the e-bike rental process.");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter registered user status: (true / false)");
        isRegisteredUser = sc.nextBoolean();
        sc.nextLine();

        System.out.println("Enter user email address: ");
        emailAddress = sc.nextLine();

        System.out.println("Enter rental location: ");
        location = sc.nextLine();

        sc.close();

        System.out.println("Simulating the analysis of the rental request.");

        bikeID = analyseRequest(isRegisteredUser, emailAddress, location);

        if(locationValid == false){
            return;
        }

        System.out.println("Simulating e-bike reservation...");

        reserveBike(bikeID);

        System.out.println("Displaying the active rentals...");

        viewActiveRentals();

        System.out.println("Simulating the end of the trip...");

        removeTrip(bikeID);

        System.out.println("Displaying the active rentals after trip end...");

        viewActiveRentals();

    }

    private String analyseRequest(boolean isRegisteredUser, String emailAddress, String location){
        if(isRegisteredUser == true){
            System.out.println("Welcome back, " + emailAddress + "!");
        }else{
            System.out.println("You're not our registered user. Please consider registering.");
            userRegistration.registration();
        }

        String bikeID = validateLocation(location);
        return bikeID;

    }

    private String validateLocation(String location){
        for(Bike bike : BikeDatabase.bikes){
            if(location.equals(bike.getLocation()) && bike.isAvailable()){
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bikeID;
            }
        }

        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        locationValid = false;
        return null;

    }
    
    private void reserveBike(String bikeID){
        if(bikeID != null){
            for(Bike bike : BikeDatabase.bikes){
                if(bikeID.equals(bike.getBikeID())){
                    tripStartTime = LocalDateTime.now();
                    bike.setIsAvailable(false);
                    bike.setLastUsedTime(tripStartTime);
                    System.out.println("Reserving the bike with the (bikeID). Please following the on-screen instructions to locate the bike and start your pleasant journey.");
                    activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
                    activeRentalList.add(activeRental);
                    break;
                }
            }
        }else{
            System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
        }

    }

    private void viewActiveRentals(){
        if(activeRentalList.isEmpty()){
            System.out.println("No active rentals at the moment.");
        }else{
            for(ActiveRental rental : activeRentalList){
                System.out.println(rental);
            }
        }
    }

    private void removeTrip(String bikeID){
        Iterator<ActiveRental> iterator = activeRentalList.iterator();
        while(iterator.hasNext()){
            ActiveRental rental = iterator.next();
            if(bikeID.equals(rental.getBikeID())){
                iterator.remove();
                break;
            }
        }

        for(Bike bike : BikeDatabase.bikes){
            if(bikeID.equals(bike.getBikeID())){
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;
            }
        }

    }


}
