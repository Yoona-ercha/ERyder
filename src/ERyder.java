public class ERyder {
    
    private static final String COMPANY_NAME = "ERyder";
    private static final double BASE_FARE = 1.0;
    private static final double PER_MINUTE_FARE = 0.5;

    private final String LINKED_ACCOUNT;
    private final long LINKED_PHONE_NUMBER;

    private int totalUsageInMinutes;
    private double totalFare;

    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    public ERyder(){
        LINKED_ACCOUNT = "YOUDOG";
        LINKED_PHONE_NUMBER = 244466666;
    }

    public ERyder(String bikeID , int batteryLevel , boolean isAvailable , double kmDriven){
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        LINKED_ACCOUNT = "YOUNAME";
        LINKED_PHONE_NUMBER = 1234567890;
    }

    public ERyder(String bikeID , int batteryLevel , boolean isAvailable , double kmDriven , String linkedAccount , long linkedPhoneNumber){
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        LINKED_ACCOUNT = linkedAccount;
        LINKED_PHONE_NUMBER = linkedPhoneNumber;

    }

    public void ride(){
        if(isAvailable && batteryLevel>0){
            System.out.println("This bike is available.");
        }else{
            System.out.println("This bike is not available");
        }
    }

    public void printBikeDetails(){
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level:"  + batteryLevel + "%");
        System.out.println("Available: " + (isAvailable?"Available":"Not Available"));
        System.out.println("Distance Travelled: " + kmDriven +"km");
    }

    public void printRideDetails(int usageInMinutes){
        calculateFare(usageInMinutes);

        System.out.println("Ride Details: ");
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone NUmber :" + LINKED_PHONE_NUMBER);
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Usage Time: " + usageInMinutes + "minutes");
        System.out.println("Total Fare: " + totalFare);
    }

    private double calculateFare(int usageInMinutes){
        totalFare = BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
        return totalFare;
    }

    public String getBikeID(){
        return bikeID;
    }

    public int getBatteryLevel(){
        return batteryLevel;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

    public double getKmDriven(){
        return kmDriven;
    }

    public void setBikeID(String bikeID){
        this.bikeID = bikeID;
    }

    public void setBatteryLevel(int batteryLevel){
        this.batteryLevel = batteryLevel;
    }

    public void setAvailable(boolean available){
        isAvailable = available;
    }

    public void setKmDriven(double kmDriven){
        this.kmDriven = kmDriven;
    }
    
}
