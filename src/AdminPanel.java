import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AdminPanel {

    ArrayList<RegisteredUsers> registeredUsersList = new ArrayList<>();

    public void userManagementOptions(){
        Scanner sc = new Scanner(System.in);
        
        while(true){
        
            System.out.println("Welcom to E-Ryder Administrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. Demo the Bike Rental System");
            System.out.println("6. EXIT");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){
                addNewUsers();
            }else if(choice == 2){
                viewRegisteredUsers();
            }else if(choice == 3){
                removeRegisteredUsers();
            }else if(choice == 4){
                updateRegisteredUsers();
            }else if(choice == 5){
                BikeRental bikeRental = new BikeRental();
                bikeRental.simulateApplicationInput();
            }else if(choice == 6){
                break;
            }else{
                System.out.println("Invalid choice. Please try again.");
            }

        }
        sc.close();
    }

    private void addNewUsers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many users would like to add: ");
        int newUsers = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < newUsers; i++){
            System.out.println("\nEnter details for user " + (i + 1));

            System.out.print("Full Name: ");
            String fullName = sc.nextLine();

            System.out.print("Email Address: ");
            String emailAddress = sc.nextLine();

            System.out.print("Date of Birth: ");
            String dateOfBirth = sc.nextLine();

            System.out.print("Card Number: ");
            long cardNumber = sc.nextLong();
            sc.nextLine();

            System.out.print("Card Provider: ");
            String cardProvider = sc.nextLine();

            System.out.print("Card Expiry Date: ");
            String cardExpiryDate = sc.nextLine();

            System.out.print("CVV: ");
            int cvv = sc.nextInt();
            sc.nextLine();

            System.out.print("User Type: ");
            String userType = sc.nextLine();

            String[] lastThreeTrips = new String[3];
            for(int j = 0; j < lastThreeTrips.length; j++){
                System.out.println("\nEnter details for trip " + (j + 1));

                System.out.println("Trip Date (YYYY-MM-DD): ");
                String tripDate = sc.nextLine();

                System.out.println("Source: ");
                String source = sc.nextLine();

                System.out.println("Destination: ");
                String destination = sc.nextLine();

                System.out.println("Fare(€): ");
                double fare = sc.nextDouble();
                sc.nextLine();

                System.out.println("Feedback (can be NULL): ");
                String feedback = sc.nextLine();

                StringBuilder sb = new StringBuilder();
                sb.append("Date: ").append(tripDate)
                .append(", Source: ").append(source)
                .append(", Destination: ").append(destination)
                .append(", Fare(€): ").append(fare)
                .append(", Feedback: ").append(feedback);

                lastThreeTrips[j] = sb.toString();
            }

            RegisteredUsers newUser = new RegisteredUsers(fullName, emailAddress, dateOfBirth, cardNumber, cardExpiryDate, cardProvider, cvv, userType, lastThreeTrips);

            registeredUsersList.add(newUser);
        }

        sc.close();
    }

    private void viewRegisteredUsers(){
        if(registeredUsersList.isEmpty()){
            System.out.println("No registered users to display.");
        }else{
            for(RegisteredUsers user : registeredUsersList){
                System.out.println("\nUser Details");
                System.out.println("Full Name: " + user.getFullName());
                System.out.println("Email Address: " + user.getEmailAddress());
                System.out.println("Date of Birth: " + user.getDateOfBirth());
                System.out.println("Card Number: " + user.getCardNumber());
                System.out.println("Card Expiry Date: " + user.getCardExpiryDate());
                System.out.println("Card Provider: " + user.getCardProvider());
                System.out.println("CVV: " + user.getCvv());
                System.out.println("User Type: " + user.getUserType());

                System.out.println("\nLast Three Trips");
                String[] trips = user.getLastThreeTrips();

                for(int i = 0; i < trips.length; i++){
                    System.out.println("Trips " + (i + 1) + ": " + trips[i]);
                }
            }
        }
    }

    private void removeRegisteredUsers(){
        if(registeredUsersList.isEmpty()){
            System.out.println("No registered users to remove.");
        }else{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the email address to remove:");
            String emailAddressToRemove = sc.nextLine();

            boolean found = false;
            Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();

            while(iterator.hasNext()){
                RegisteredUsers user = iterator.next();
                if(user.getEmailAddress().equals(emailAddressToRemove)){
                    iterator.remove();
                    found = true;
                    break;
                }
            }

            if(found == false){
                System.out.println("No useer found with this email address.");
            }

            sc.close();
        }
    }

    private void updateRegisteredUsers(){
        if(registeredUsersList.isEmpty()){
            System.out.println("No registered users to remove.");
        }else{
            Scanner sc = new Scanner(System.in);
            String emailAddressToUpdate = sc.nextLine();

            boolean found = false;
            RegisteredUsers registeredUser = null;

            for(int i = 0; i < registeredUsersList.size(); i++){
                RegisteredUsers user = registeredUsersList.get(i);
                if(user.getEmailAddress().equals(emailAddressToUpdate)){
                    registeredUser = user;
                    found = true;
                }
            }

            if(found == false){
                System.out.println("No user found with this email address.");
            }else{
                System.out.println("Type new full name: (Press ENTER for no change)");
                String fullName = sc.nextLine();
                if(!fullName.isEmpty()){
                    registeredUser.setFullName(fullName);
                }

                System.out.println("Type new email address: (Press ENTER for no change)");
                String emailAddress = sc.nextLine();
                if(!emailAddress.isEmpty()){
                    registeredUser.setEmailAddress(emailAddress);
                }

                System.out.println("Type new date of birth: (Press ENTER for no change)");
                String dateOfBirth = sc.nextLine();
                if(!dateOfBirth.isEmpty()){
                    registeredUser.setDateOfBirth(dateOfBirth);
                }

                System.out.println("Type new card number: (Enter '0' for no change)");
                Long cardNumber = sc.nextLong();
                sc.nextLine();
                if(cardNumber != 0){
                    registeredUser.setCardNumber(cardNumber);
                }

                System.out.println("Type new card provider: (Press ENTER for no change)");
                String cardProvider = sc.nextLine();
                if(!cardProvider.isEmpty()){
                    registeredUser.setCardProvider(cardProvider);
                }

                System.out.println("Type new card expiry date: (Press ENTER for no change)");
                String cardExpiryDate = sc.nextLine();
                if(!cardExpiryDate.isEmpty()){
                    registeredUser.setCardExpiryDate(cardExpiryDate);
                }

                System.out.println("Type new cvv: (Press '0' for no change)");
                int cvv = sc.nextInt();
                sc.nextLine();
                if(cvv != 0){
                    registeredUser.setCvv(cvv);
                }

                System.out.println("Type new user type: (Press ENTER for no change)");
                String userType = sc.nextLine();
                if(!userType.isEmpty()){
                    registeredUser.setUserType(userType);
                }
            }

            sc.close();
        }
    }

}
