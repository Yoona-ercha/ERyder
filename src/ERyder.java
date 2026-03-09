public class ERyder {
    
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    public ERyder(){
        this.bikeID = "";
        this.batteryLevel = 0;
        this.isAvailable = false;
        this.kmDriven = 0.0;
    }

    public ERyder(String bikeID , int batteryLevel , boolean isAvailable , double kmDriven){
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }

    public void ride(){
        if(isAvailable && batteryLevel>0){
            System.out.println("This bike is available.");
        }else{
            System.out.println("This bike is not available");
        }
    }

    public void printBikeDetails(){
        System.out.println("Bike ID:" + bikeID);
        System.out.println("Battery Level:" + batteryLevel + "%");
        System.out.println("Available:" + (isAvailable?"Available":"Not Available"));
        System.out.println("Distance Travelled:" + kmDriven +"km");
    }

    public String getBikeID(){
        return bikeID;
    }

    public int getBatterLevel(){
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
