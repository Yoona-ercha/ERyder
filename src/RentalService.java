import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class RentalService {

    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private String bikeID;
    private boolean locationValid;

    private RegisteredUsers currentUser;
    public static final double BASE_FARE = 3.0;

    UserRegistration userRegistration = new UserRegistration();
    BikeService bikeService = new BikeService();

    LinkedList<ActiveRental> activeRentalList = new LinkedList<>();

    public void simulateApplicationInput(RegisteredUsers user){
        this.currentUser = user;
        
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

        bikeService.reserveBike(bikeID);

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

        String bikeID = bikeService.validateLocation(location);
        return bikeID;

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

        double finalFare = currentUser.calculateFare(BASE_FARE);
        currentUser.displayUserType();
        System.out.println("Final Fare: " + finalFare);

    }

}
