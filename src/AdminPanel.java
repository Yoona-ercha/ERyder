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
            System.out.println("6. View System Logs");
            System.out.println("7. Manage Pending Bike Requests");
            System.out.println("8. EXIT");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){
                RegisteredUsers newUser = userService.addNewUsers();
                RentalService rentalService = new RentalService();
                rentalService.simulateApplicationInput(newUser);
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
                ERyderLog eryderLog = new ERyderLog();
                eryderLog.viewSystemLogs();
            }else if(choice == 7){
                while(true){
                    System.out.println("1. View Queue");
                    System.out.println("2. Update Queue");
                    System.out.println("3. Exit");

                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    
                    BikeService bikeService = new BikeService();

                    if(subChoice == 1){
                        for(BikeRequest req : bikeService.queue){
                            System.out.println(req);
                        }
                    }else if(subChoice == 2){
                        if(!bikeService.queue.isEmpty()){
                            bikeService.queue.poll();
                        }
                    }else if(subChoice == 3){
                        break;
                    }else{
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            }else if(choice == 8){
                break;
            }else{
                System.out.println("Invalid choice. Please try again.");
            }

        }
        sc.close();
    }

}
