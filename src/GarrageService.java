import java.util.*;

public class GarrageService {
     private Map<String, Customer> customers;
     private List<Service> availableServices;

    public GarrageService() {

        this.customers = new HashMap<>();
        this.availableServices = new ArrayList<>();
        loadServices();
    }

    public  void loadServices(){
        availableServices.add(new Service("Car Wash", 500));
        availableServices.add(new Service("Oil Change", 700));
        availableServices.add(new Service("Wheel Alignment", 300));
        availableServices.add(new Service("Tyre Replacement", 3000));
        availableServices.add(new Service("Puncture", 50));

    }

    public void addCustomer(String name, String phone, String carNumber, String model){
        Car car = new Car(carNumber, model);
        Customer customer = new Customer(name, phone, car);
        customers.put(carNumber, customer);
        System.out.println("Customer added Successfully!");
    }

    public void createInvoice(String carNumber){
        if(!customers.containsKey(carNumber)){
            System.out.println("No Customer Found with car number: " + carNumber);
            return;
        }
        Scanner sc = new Scanner(System.in);
        Customer customer = customers.get(carNumber);
        Invoice invoice = new Invoice(customer);
        System.out.println("Available Services: ");
        for(int i = 0; i < availableServices.size(); i++){
            System.out.println((i + 1) + " " +  availableServices.get(i).getName() + " - ₹ " + availableServices.get(i).getPrice());
        }

        while(true){
            System.out.print("Enter Service Number to add or press 0 to finish : ");
            int choice = sc.nextInt();
            if(choice == 0) break;
            if(choice > 0 && choice <= availableServices.size()){
                invoice.AddService(availableServices.get(choice - 1));
                System.out.println("Service Done!");
            }
            else{
                System.out.println("Invalid Choice!");
            }
        }
        invoice.PrintInvoice();
    }
}
