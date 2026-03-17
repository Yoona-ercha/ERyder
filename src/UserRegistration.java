import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class UserRegistration {
    public static final double VIP_DISCOUNT_UNDER_18_BIRTHDAY = 25.0;
    public static final double VIP_DISCOUNT_UNDER_18 = 20.0;
    public static final double VIP_BASE_FEE = 100.0;

    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardProvider;
    private String cardExpiryDate;
    private double feeToCharge;
    private int cvv;
    private String userType;

    private boolean emailValid = false;
    private boolean minorAndBirthday = false;
    private boolean minor = false;
    private boolean ageValid = false;
    private boolean cardNumberValid = false;
    private boolean cardStillValid = false;
    private boolean validCVV = false;

    public void registration(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcom to the ERyder Registration.");
    System.out.println("Here are your teo options:");
    System.out.println("1. Register as a Regular User");
    System.out.println("2. Register as a VIP User");
    System.out.println("Please enter your choice(1 or 2)");

    int choice = sc.nextInt();
    sc.nextLine();

    if(choice == 1){
        userType = "Regular User";
    }else if(choice == 2){
        userType = "VIP User";
    }else{
        System.out.println("Invalid choice.");
    }

    System.out.println("Fall name:");
    fullName = sc.nextLine();

    System.out.println("Email address:");
    emailAddress = sc.nextLine();

    System.out.println("Check your address's validity...");
    emailValid = analyseEmail(emailAddress);

    System.out.println("Date of birth (YYYY-MM-DD):");
    dateOfBirth = sc.nextLine();

    System.out.println("Check your age validity...");
    LocalDate dob = LocalDate.parse(dateOfBirth);
    ageValid = anaylseAge(dob);

    System.out.println("Card number:");
    cardNumber = sc.nextLong();
    sc.nextLine();

    System.out.println("Check your card number's validity...");
    cardNumberValid = analyseCardNumber(cardNumber);

    System.out.println("Card expiry Date (MM/YY):");
    cardExpiryDate = sc.nextLine();

    System.out.println("Check your card is still validity...");
    cardStillValid = anaylseCardExpiryDate(cardExpiryDate);

    System.out.println("CVV:");
    cvv = sc.nextInt();
    sc.nextLine();

    System.out.println("Check CVV's validity...");
    validCVV = analyseCVV(cvv);

    finalCheckpoint();

    sc.close();

    }

    private boolean analyseEmail(String emailAddress){
        if(emailAddress.contains("@") && emailAddress.contains(".")){
            System.out.println("Email is valid.");
            return true;
        }else{
            System.out.println("Invalid email address. Going back to the start of the registration.");
            registration();
        }
        return true;
    }

    private boolean anaylseAge(LocalDate dob){
        LocalDate now = LocalDate.now();
        int age = Period.between(dob , now).getYears();
        boolean isBirthday = (dob.getMonth() == now.getMonth()) && (dob.getDayOfMonth() == now.getDayOfMonth());

        if(userType.equals("VIP User")){
            if(isBirthday == true && age > 12 && age <= 18){
                System.out.println("Happy Birthday!");
                System.out.println("You get 25% dicount on the VIP subscription fee for being born today and being under 18!");
                minorAndBirthday = true;
            }else if(isBirthday == false && age > 12 && age <=18){
                System.out.println("You get 20% discount on the VIP subscription fee for being under 18!");
                minor = true;
            }
        }

        if(age <= 12 || age >120){
            System.out.println("Looks like you are either too young or already dead. Sorry, you can't be our user. Have a nice day!");
            System.exit(0);
        }

        return true;
    }

    private boolean analyseCardNumber(long cardNumber){
        String cardNumStr = Long.toString(cardNumber);
        int firstTwoDigits = Integer.parseInt(cardNumStr.substring(0 , 2));
        int firstFourDigits = Integer.parseInt(cardNumStr.substring(0 , 4));

        if(cardNumStr.length() == 13 || cardNumStr.length() == 15 && cardNumStr.startsWith("4")){
            cardProvider = "VISA";
        }else if(cardNumStr.length() == 16 && ((firstTwoDigits >= 51 && firstFourDigits <=55) || (firstFourDigits >= 2221 && firstFourDigits <=2720))){
            cardProvider = "MasterCard";
        }else if(cardNumStr.length() == 15 && (cardNumStr.startsWith("34") || cardNumStr.startsWith("37"))){
            cardProvider = "American Express";
        }else{
            System.out.println("Sorry, but we accept only VISA, MasterCard, or AmericanExpress cards. Please try again with a valid card. Going back to the start of the registration.");
            registration();
        }

        return true;

    }

    private boolean anaylseCardExpiryDate(String cardExpiryDate){
        int month = Integer.parseInt(cardExpiryDate.substring(0 , 2));
        int year = Integer.parseInt(cardExpiryDate.substring(3 , 5)) + 2000;

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();

        if(year > currentYear || (year == currentYear && month >= currentMonth)){
            System.out.println("The card is still valid.");
            return true;
        }else{
            System.out.println("Sorry, your card has expired. Please use a different card. Going back to the start for the registration process.");
            registration();
        }

        return true;

    }

    private boolean analyseCVV(int cvv){
        String cvvStr = Integer.toString(cvv);
        if((cardProvider.equals("American Express") && cvvStr.length() == 4) || (cardProvider.equals("VISA") && cvvStr.length() == 3) || cardProvider.equals("MasterCard") && cvvStr.length() == 3){
            System.out.println("Card CVV is valid.");
            return true;
        }else{
            System.out.println("Invalid CVV for the given card. Going back to the start of the registration process.");
            registration();
        }

        return true;

    }

    private void  finalCheckpoint(){
        if(emailValid && ageValid && cardNumberValid && cardStillValid && validCVV){
            chargeFees();
        }else{
            System.out.println("Sorry, your registration was unsuccessful due to the following reason(s):");

            if(emailValid == false){
            System.out.println("Invalid email address.");
            }
        
            if(ageValid == false){
                System.out.println("Invalid age.");
            }
        
            if(cardNumberValid == false){
                System.out.println("Invalid card number.");
            }
        
            if(cardStillValid == false){
                System.out.println("Card has expired.");
            }
        
            if(validCVV == false){
                System.out.println("Invalid CVV.");
            }

            System.out.println("Going back to the start of the registration process.");
            registration();
        }
    }

    private void chargeFees(){
        if(minorAndBirthday == true){
            feeToCharge = VIP_BASE_FEE * (1 - 0.25);
        }else if(minor == true){
            feeToCharge = VIP_BASE_FEE * (1 - 0.2);
        }else{
            feeToCharge = VIP_BASE_FEE;
        }

        String cardNumStr = Long.toString(cardNumber);
        String lastFourDigits = cardNumStr.substring(cardNumStr.length() - 4);

        System.out.println("Thank you for your payment.");
        System.out.println("A fee of " + feeToCharge + " has been charged to your card ending with " + lastFourDigits);
    }

    @Override
    public String toString(){
        String cardNumStr = Long.toString(cardNumber);
        String censoredPart = cardNumStr.substring(0 , cardNumStr.length() - 4).replaceAll("." , "*");
        String lastFourDigits = cardNumStr.substring(cardNumStr.length() - 4);
        String censoredNumber = censoredPart + lastFourDigits;

        return "Registration successful! Here are your details:\n" 
        + "User Type: " + userType + "\n" 
        + "Full Name: " + fullName + "\n" 
        + "Email Address: " + emailAddress + "\n" 
        + "Date of Birth: " + dateOfBirth + "\n" 
        + "Card Number: " + censoredNumber + "\n" 
        + "Card Provider: " + cardProvider + "\n" 
        + "Card Expiry Date: " + cardExpiryDate;
    }

}
