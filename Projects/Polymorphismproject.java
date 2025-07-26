package Keywords;
class FoodItem {
    String itemId;
    String itemName;
    double unitPrice;
    int quantity;

    FoodItem(String itemId, String itemName, double unitPrice, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    public void calculateBill() {
        double subtotal = unitPrice * quantity;
        double discount = 0.0;
        if (subtotal >= 1000) {
            discount = subtotal * 0.10;
        }

        double gst = (subtotal - discount) * 0.05;
        double total = (subtotal - discount) + gst;

        displayDetails(subtotal, gst, discount, total);
    }
    public void displayDetails(double subtotal, double gst, double discount, double total) {
        System.out.println("\nFood Item Record");
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("GST: " + String.format("%.2f", gst));
        System.out.println("Discount: " + String.format("%.2f", discount));
        System.out.println("Total Bill: " + String.format("%.2f", total));
    }
}
class DineIn extends FoodItem {
    double serviceCharge;
    DineIn(String itemId, String itemName, double unitPrice, int quantity, double serviceCharge) {
        super(itemId, itemName, unitPrice, quantity);
        this.serviceCharge = serviceCharge;
    }
    @Override
    public void calculateBill() {
        double subtotal = (unitPrice * quantity) + serviceCharge;
        double discount = 0.0;

        if (subtotal >= 1000) {
            discount = subtotal * 0.10;
        }
        double gst = (subtotal - discount) * 0.05;
        double total = (subtotal - discount) + gst;

        displayDetails(subtotal, gst, discount, total);
    }
    @Override
    public void displayDetails(double subtotal, double gst, double discount, double total) {
        System.out.println("\nFood Item Record");
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Service Charge: " + serviceCharge);
        System.out.println("GST: " + String.format("%.2f", gst));
        System.out.println("Discount: " + String.format("%.2f", discount));
        System.out.println("Total Bill: " + String.format("%.2f", total));
    }
}
class Takeaway extends FoodItem {
    double packingCharge;

    Takeaway(String itemId, String itemName, double unitPrice, int quantity, double packingCharge) {
        super(itemId, itemName, unitPrice, quantity);
        this.packingCharge = packingCharge;
    }
    @Override
    public void calculateBill() {
        double subtotal = (unitPrice * quantity) + packingCharge;
        double discount = 0.0;

        if (subtotal >= 1000) {
            discount = subtotal * 0.10;
        }
        double gst = (subtotal - discount) * 0.05;
        double total = (subtotal - discount) + gst;

        displayDetails(subtotal, gst, discount, total);
    }
    @Override
    public void displayDetails(double subtotal, double gst, double discount, double total) {
        System.out.println("\nFood Item Record");
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Packing Charge: " + packingCharge);
        System.out.println("GST: " + String.format("%.2f", gst));
        System.out.println("Discount: " + String.format("%.2f", discount));
        System.out.println("Total Bill: " + String.format("%.2f", total));
    }
}

class Delivery extends FoodItem {
    double deliveryFee;
    Delivery(String itemId, String itemName, double unitPrice, int quantity, double deliveryFee) {
        super(itemId, itemName, unitPrice, quantity);
        this.deliveryFee = deliveryFee;
    }
    @Override
    public void calculateBill() {
        double subtotal = (unitPrice * quantity) + deliveryFee;
        double discount = 0.0;

        if (subtotal >= 1000) {
            discount = subtotal * 0.10;
        }
        double gst = (subtotal - discount) * 0.05;
        double total = (subtotal - discount) + gst;

        displayDetails(subtotal, gst, discount, total);
    }
    @Override
    public void displayDetails(double subtotal, double gst, double discount, double total) {
        System.out.println("\nFood Item Record");
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Delivery Fee: " + deliveryFee);
        System.out.println("GST: " + String.format("%.2f", gst));
        System.out.println("Discount: " + String.format("%.2f", discount));
        System.out.println("Total Bill: " + String.format("%.2f", total));
    }
}
public class Polymorphismproject {
    public static void main(String[] args) {
        DineIn dineIn = new DineIn("101", "Paneer Butter", 250.0, 4, 50.0);
        dineIn.calculateBill();
        Takeaway takeaway = new Takeaway("102", "Fried Rice", 180.0, 3, 20.0);
        takeaway.calculateBill();
        Delivery delivery = new Delivery("103", "Burger", 200.0, 5, 40.0);
        delivery.calculateBill();
    }
}
