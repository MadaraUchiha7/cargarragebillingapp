import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarGarrageBillingApp {
    public static void main(String[] args) throws IOException {
        GarrageService garrageService = new GarrageService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        System.out.println("_____________________________Automobi_______________________________");
        while(true){
            System.out.println("1. Add Customer");
            System.out.println("2. Offer Services");
            System.out.println("3. Exit");
            System.out.println("Enter your Choice: ");
            int choice = 0;
            try {
                choice = sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Enter a Valid Integer!");
                return;
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter Customer Name: ");
                    String name = br.readLine();
                    System.out.println("Enter Phone Number: ");
                    String phone = sc.next();
                    System.out.println("Enter Car Number: ");
                    String carNum = sc.next();
                    System.out.println("Enter Car Model: ");
                    String model = br.readLine();
                    garrageService.addCustomer(name, phone, carNum, model);
                    break;
                case 2:
                    System.out.println("Enter Car Number: ");
                    String CarNo = sc.next();
                    garrageService.createInvoice(CarNo);
                    break;
                case 3:
                    System.out.println("Exiting.............Thank You!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice! Try Again.");

            }


        }
    }
}
