public class Main {
    public static void main(String[] args){
        ERyder bike = new ERyder("A1234" , 90 , true , 123.4);
        bike.ride();
        bike.printBikeDetails();

        ERyder bike1 = new ERyder("B5678" , 85 , true , 12.5);
        bike1.printRideDetails(30);

        ERyder bike2 = new ERyder("C9090" , 80 , true , 38.5 , "Yoona" , 1223334444);
        bike2.printRideDetails(20);

        String sent1 = "I was very satisfied with the service.";
        String sent2 = "The e-Bike is quite comfortable to ride,";
        String sent3 = "The battery life of the e-Bike is impressive.";
        String sent4 = "The customer support was helpful and responsive.";
        String sent5 = "I would recommend this e-Bike to my friends and family";

        Feedback feedback = new Feedback("Yoona" , "Soonyi" , "Syn114514@qq.com");

        feedback.analyseFeedback(true , sent1 , sent2 , sent3 , sent4 , sent5);

        System.out.println(feedback);

    }
}
