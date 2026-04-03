import java.util.LinkedList;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Queue;
import java.util.ArrayDeque;

public class BikeService {

    private String emailAddress;
    private LocalDateTime tripStartTime;
    private boolean locationValid;

    UserRegistration userRegistration = new UserRegistration();
    LinkedList<ActiveRental> activeRentalList = new LinkedList<>();
    RentalService rentalService = new RentalService();
    Queue<BikeRequest> queue = new ArrayDeque<>();

    public void reserveBike(String bikeID){
        if(bikeID != null){
            for(Bike bike : BikeDatabase.bikes){
                if(bikeID.equals(bike.getBikeID())){
                    tripStartTime = LocalDateTime.now();
                    bike.setIsAvailable(false);
                    bike.setLastUsedTime(tripStartTime);
                    System.out.println("Reserving the bike with the (bikeID). Please following the on-screen instructions to locate the bike and start your pleasant journey.");
                    ActiveRental activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
                    activeRentalList.add(activeRental);
                    break;
                }
            }
        }else{
            System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
            String location = "";
            BikeRequest request = new BikeRequest(emailAddress, location, LocalDateTime.now());
            queue.offer(request);
        }

    }

    public void viewActiveRentals(){
        if(activeRentalList.isEmpty()){
            System.out.println("No active rentals at the moment.");
        }else{
            for(ActiveRental rental : activeRentalList){
                System.out.println(rental);
            }
        }
    }

    public String validateLocation(String location){
        for(Bike bike : BikeDatabase.bikes){
            if(location.equals(bike.getLocation()) && bike.isAvailable()){
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bike.getBikeID();
            }
        }

        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        locationValid = false;
        return null;

    }

    public void removeTrip(String bikeID){
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

        if(!queue.isEmpty()){
            BikeRequest nextRequest = queue.poll();
            String nextBikeID = validateLocation(nextRequest.getLocation());
            if(nextBikeID != null){
                reserveBike(nextBikeID);
            }
        }

    }

}
