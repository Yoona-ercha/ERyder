import java.util.ArrayList;
import java.util.Scanner;

public class AdminPanel {

    ArrayList<RegisteredUsers> registeredUsersList = new ArrayList<>();
    UserService userService = new UserService();

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
                userService.addNewUsers();
            }else if(choice == 2){
                userService.viewRegisteredUsers();
            }else if(choice == 3){
                userService.removeRegisteredUsers();
            }else if(choice == 4){
                userService.updateRegisteredUsers();
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

}
