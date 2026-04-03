import java.time.LocalDateTime;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

public class ERyderLog {

    Deque<ERyderLog> stack = new ArrayDeque<>();
    BikeRental bikeRental = new BikeRental();

    private String log = "BR156";
    private String event = "Bike with " + bikeRental.getBikeID() + " was rented by from " + bikeRental.getLocation() ;
    private LocalDateTime timeStamp = LocalDateTime.now();

    {stack.push(this);}

    public String getLog(){
        return log;
    }

    public String getEvent(){
        return event;
    }

    public LocalDateTime getTimeStamp(){
        return timeStamp;
    }

    @Override
    public String toString(){
        return log + " - " + event + " - " + timeStamp;
    }

    public void viewSystemLogs(){
        Iterator<ERyderLog> iterator = stack.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
