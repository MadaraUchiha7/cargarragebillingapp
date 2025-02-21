import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private Customer customer;
    private List<Service> serviceList;
    private double totalAmount;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.serviceList = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void AddService(Service service){
        serviceList.add(service);
        totalAmount = totalAmount + service.getPrice();
    }

    public void PrintInvoice(){
        System.out.println("__________________________INVOICE__________________________");
        System.out.println("Customer: " + customer.getName() + " | Phone: " + customer.getPhone());
        System.out.println("Car: " + customer.getCar().getModel() + " | Car Number: " + customer.getCar().getCarNumber());
        System.out.println("Services: ");
        for(Service service: serviceList){
            System.out.println("# " + service.getName() + " : " + " ₹ " + service.getPrice());
        }
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("_________________________THANK YOU__________________________");
    }

}
