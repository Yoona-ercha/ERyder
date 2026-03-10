public class Main {
    public static void main(String[] args){
        ERyder bike = new ERyder("A1234" , 90 , true , 123.4);
        bike.ride();
        bike.printBikeDetails();

        ERyder bike1 = new ERyder("B5678" , 85 , true , 12.5);
        bike1.printRideDetails(30);

        ERyder bike2 = new ERyder("C9090" , 80 , true , 38.5 , "Yoona" , 1223334444);
        bike2.printRideDetails(20);
    }
}
