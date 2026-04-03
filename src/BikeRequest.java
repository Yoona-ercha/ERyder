import java.time.LocalDateTime;
import java.util.Queue;
import java.util.ArrayDeque;

public class BikeRequest {

    Queue<BikeRequest> queue = new ArrayDeque<>();

    private String userEmail;
    private String location;
    private LocalDateTime requestTime;

    public BikeRequest(String userEmail, String location, LocalDateTime requestTime){
        this.userEmail = userEmail;
        this.location = location;
        this.requestTime = requestTime;
    }

    public String getUserEmail(){
        return userEmail;
    }

    public String getLocation(){
        return location;
    }

    public LocalDateTime getRequestTime(){
        return requestTime;
    }

    @Override
    public String toString(){
        return userEmail + ", " + location + ", " + requestTime;
    }





}
