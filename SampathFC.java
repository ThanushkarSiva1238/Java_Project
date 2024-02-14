package LO1_Project;

import java.util.*;

// This is an item class
class Items {
    // Attributes
    String Product_ID, Product_Name;
    int Product_Quantity;
    float Product_Price;

    // Constructor
    public Items(String Product_ID, String Product_Name, int Product_Quantity, float Product_Price) {
        // Here, the product's input value are stored in attributes.
        this.Product_ID = Product_ID;
        this.Product_Name = Product_Name;
        this.Product_Quantity = Product_Quantity;
        this.Product_Price = Product_Price;
    }
}

//  This is an order class
class Order {
    // Attributes
    String Order_ID, Order_Product;
    int Order_Quantity;
    float Total_Payment;

    // Constructor
    public Order(String Order_ID, String Order_Product, int Order_Quantity, float Total_Payment) {
        // Here, the order product's input value are stored in attributes.
        this.Order_ID = Order_ID;
        this.Order_Product = Order_Product;
        this.Order_Quantity = Order_Quantity;
        this.Total_Payment = Total_Payment;
    }
}

// This is main class
public class SampathFC {

    List<Items> Product_List = new ArrayList<>();
    List<Order> Order_List = new ArrayList<>();
    Scanner input = new Scanner(System.in); // This is a scanner class used to get user input.

    public void addProduct(){
        // Start of addProduct Method
        System.out.println("\n--- Add Product ---");
        char add_product = 'y'; // This line helps to the while loop.

        // This while loop helps to add more products. (Line : 43-78)
        while (add_product == 'y') {
            System.out.print("\nEnter Product ID : ");
            String ProductID = input.next().toUpperCase();

            int index = -1; // This line considers choosing the side of the if condition.

            // This for loop helps identify whether the product already exists or not in the product list. (Line : 51-57)
            for (int i = 0; i < Product_List.size(); i++) {
                Items currentItem = Product_List.get(i);
                if (currentItem.Product_ID.equals(ProductID)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                System.out.println("This product is already on the list.");
            } else {
                // Adding a new product
                System.out.print("Enter Product Name : ");
                String ProductName = input.next();
                System.out.print("Enter Quantity : ");
                int quantity = input.nextInt();
                System.out.print("Enter Price : ");
                float price = input.nextFloat();

                Items add = new Items(ProductID, ProductName, quantity, price); // This line adds products to the items constructor.
                Product_List.add(add); // This line adds that constructor (Line 70) to the product list.
                System.out.println("Product Added Successfully...");
            }

            System.out.print("Do you want to add more products? (Y/N): ");
            add_product = input.next().toLowerCase().charAt(0); // This input line helps to loop the while or end while.
            // End of addProduct Method
        }
    }

    public void modifyProduct(){
        // Start of modifyProduct Method
        if (!Product_List.isEmpty()) {
            System.out.println("\n--- Modify Product ---");
            char modify_product = 'y';

            // This while loop helps to modify each product's details. (Line : 98-144)
            while (modify_product == 'y') {
                System.out.print("\nEnter Product ID : ");
                String ProductID = input.next().toUpperCase();

                int index = -1;

                // This for loop helps identify whether the product already exists or not in the product list. (Line : 105-111)
                for (int i = 0; i < Product_List.size(); i++) {
                    Items currentItem = Product_List.get(i);
                    if (currentItem.Product_ID.equals(ProductID)) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    Items answer = Product_List.get(index); // This line represents the product's details
                    int select = 0;
                    while (select != 4){
                        System.out.println("1. Modify Product Name \n2. Modify Product Quantity \n3. Modify Product Price \n4. Leave from here");
                        System.out.print("Select one (No): ");
                        select = input.nextInt();

                        // This selection method (IF Condition) shows modify each product's details. (Line : 120-137)
                        if (select == 1) {
                            System.out.print("\nEnter Product Name : ");
                            answer.Product_Name = input.next();
                            System.out.println("Product Name Modified Successfully...\n");

                        } else if (select == 2) {
                            System.out.print("\nEnter Product Quantity : ");
                            answer.Product_Quantity = input.nextInt();
                            System.out.println("Product Quantity Modified Successfully...\n");

                        } else if (select == 3) {
                            System.out.print("\nEnter Product Price : ");
                            answer.Product_Price = input.nextFloat();
                            System.out.println("Product Price Modified Successfully...\n");

                        }
                    }
                } else {
                    System.out.println("Product ID not found.");
                }

                System.out.print("\nDo you want to modify other products? (Y/N): "); // This input line helps to loop the while or end while.
                modify_product = input.next().toLowerCase().charAt(0);
            }
        } else {
            System.out.println("\tThe list of products is currently blank...");
        }
        // End of modifyProduct Method
    }

    public void removeProduct(){
        // Start of removeProduct Method
        if (!Product_List.isEmpty()) {
            System.out.println("--- Remove Product ---\n");
            System.out.print("Enter Product ID : ");
            String ProductID = input.next().toUpperCase();

            int index = -1;

            // This for loop helps identify whether the product already exists or not in the product list. (Line : 162-168)
            for (int i = 0; i < Product_List.size(); i++) {
                Items currentItem = Product_List.get(i);
                if (currentItem.Product_ID.equals(ProductID)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                Product_List.remove(index); // This line removes the product details from the product list.
                System.out.println("Product Removed Successfully...");
            } else {
                System.out.println("Product ID not found.");
            }
        } else {
            System.out.println("\tThe list of products is currently blank...");
        }
        // End of removeProduct Method
    }

    public void ViewOrderProduct(){
        // Start of viewOrderProduct Method
        if (!Order_List.isEmpty()) {
            System.out.println("\n--- View Customer Order ---");
            float Grand_Total = 0;

            // This for loop displays the order items and payment details from order array list. (Line : 186-189)
            for (Order view : Order_List) {
                System.out.printf("%s(%d) \n\tAmount : Rs. %.2f\n", view.Order_Product, view.Order_Quantity, view.Total_Payment);
                Grand_Total = Grand_Total + view.Total_Payment;
            }
            System.out.printf("\n Grand Total : Rs. %.2f\n", Grand_Total);
        } else {
            System.out.println("\n\tThe Order list is Empty...");
        }
        // End of viewOrderProduct Method
    }

    public void viewProduct(){
        // Start of viewProduct Method
        if (!Product_List.isEmpty()) {
            System.out.println("\n--- Product List ---");
            // This for loop displays the product item details from product array list. (Line : 201-203)
            for (Items view : Product_List) {
                System.out.printf("%s => %s(%d) \n\tUnit Price : Rs. %.2f\n", view.Product_ID, view.Product_Name, view.Product_Quantity, view.Product_Price);
            }
        }else {
            System.out.println("\nThe list of products is currently blank...");
        }
        // End of viewProduct Method
    }

    public void orderProduct(){
        // Start of orderProduct Method
        if (!Product_List.isEmpty()) {
            System.out.println("\n--- Order the Product ---");
            char order_product = 'y';

            // This while loop helps to order more products. (Line : 215-297)
            while (order_product == 'y') {
                System.out.print("\nEnter Product ID : ");
                String ProductID = input.next().toUpperCase();
                int choice = 0;

                // This for loop helps to check each order item. (Line : 221-264)
                for (int i = 0; i < Order_List.size(); i++){
                    Order orderItem = Order_List.get(i);

                    // This part works to modify the already-existing order's quantity. (Line : 226-261)
                    // This if condition helps identify whether the product already exists or not in the order list.
                    if (orderItem.Order_ID.equals(ProductID)){
                        choice = 1;
                        System.out.println("The product is already in the cart. You can change the quantity.");
                        System.out.print("You want to change (Y/N): ");
                        char change = input.next().toLowerCase().charAt(0);

                        if (change == 'y'){
                            for (Items currentItem : Product_List) {
                                // This concept works like this: (Line : 237-258)
                                if (currentItem.Product_ID.equals(ProductID)) {
                                    Items answer = Product_List.get(i);

                                    // First, the previous order quantity is added to the default product quantity. (Line : 241)
                                    answer.Product_Quantity += orderItem.Order_Quantity;

                                    // Second, get the new quantity and compare it with the product quantity. If the new quantity is less than the product quantity, (Line : 244-257)
                                    System.out.print("Enter new quantity : ");
                                    int quantity = input.nextInt();

                                    if (quantity <= answer.Product_Quantity) {
                                        // Third, decrease the product quantity by the new quantity. (Line : 249)
                                        answer.Product_Quantity -= quantity;

                                        // Fourth, store this new quantity in that order list. (Line : 252)
                                        orderItem.Order_Quantity = quantity;
                                        orderItem.Total_Payment = quantity * answer.Product_Price;
                                        System.out.println("Product added in cart");
                                    } else {
                                        System.out.println("Low Quantity :(");
                                    }
                                }
                            }
                        }
                        else {
                            break;
                        }
                    } else{
                        continue;
                    }
                }

                // This part works to order the product and adds to order list. (Line : 272-302)
                if (choice == 0) {

                    int index = -1;

                    // This for loop helps to get each product's details.
                    for (int x = 0; x < Product_List.size(); x++) {
                        Items currentItem = Product_List.get(x);
                        if (currentItem.Product_ID.equals(ProductID)) {
                            index = x;
                            break;
                        }
                    }

                    if (index != -1) {
                        Items answer = Product_List.get(index);
                        System.out.print("Enter Quantity : ");
                        int quantity = input.nextInt();

                        // This if condition compare the order quantity and product quantity. (Line : 291-299)
                        if (quantity <= answer.Product_Quantity) {
                            float Total = quantity * answer.Product_Price;
                            answer.Product_Quantity -= quantity;
                            Order add = new Order(ProductID, answer.Product_Name, quantity, Total); // This line adds order products to the order constructor.
                            Order_List.add(add); // This line adds that constructor (Line 294) to the order list.
                            System.out.println("Product added in cart");
                        } else {
                            System.out.println("Low Quantity :(");
                        }

                    } else {
                        System.out.println("Product ID not found.");
                    }
                }

                System.out.print("\nDo you want to order more products? (Y/N): ");
                order_product = input.next().toLowerCase().charAt(0);
            }
        } else {
            System.out.println("\tThe list of products is currently blank...");
        }
        // End of orderProduct Menthod
    }


    public static void main(String[] args) {

        SampathFC method = new SampathFC(); // This is an object. This is used to retrieve the methods.
        System.out.println(">>>>> Sampath Food City (PVT) Ltd <<<<<");

        int user = 0;
        while (user != 3) {

            // This 323rd line shows the error exception method. (Line : 324-407)
            try {
                Scanner input = new Scanner(System.in); // This is a scanner class used to get user input.
                System.out.println("\n1 - Admin \n2 - Customer \n3 - Exit the Program");
                System.out.print("Choose one (No): ");
                user = input.nextInt();

                // This IF condition used to choose the user type. (Line : 329-407)
                if (user == 1) {
                    System.out.println("\n+++++ Admin Interface +++++");

                    // This for loop is used to control the times for the login process. (Line : 335-370)
                    for (int count = 1; count <= 3; count++) {
                        System.out.print("Enter Admin ID : ");
                        String AdminID = input.next();
                        System.out.print("Enter Password : ");
                        String Password = input.next();

                        // This IF condition verifies the administrator. (Line : 342-370)
                        if (AdminID.equals("Admin") && Password.equals("Pass")) {

                            int option = 0;
                            while (option != 5) {

                                method.viewProduct(); // Method calling...

                                System.out.println("\n1. Add Product \n2. Modify Product \n3. Remove Product \n4. View Customer Order \n5. Exit at Admin Interface");
                                System.out.print("Which Option (No): ");
                                option = input.nextInt();

                                if (option == 1) {
                                    method.addProduct(); // Method Calling...

                                } else if (option == 2) {
                                    method.modifyProduct(); // Method Calling...

                                } else if (option == 3) {
                                    method.removeProduct(); // Method Calling...

                                } else if (option == 4) {
                                    method.ViewOrderProduct(); // Method Calling...
                                }
                            }
                            break;
                        } 
                        else {
                            System.out.println("AdminID or Password Incorrect :(");
                        }

                    }
                } else if (user == 2) {
                    System.out.println("\n+++++ Customer Interface +++++");

                    // This for loop is used to control the times for the login process. (Line : 376-406)
                    for (int count = 1; count <= 3; count++) {
                        System.out.print("Enter Customer ID : ");
                        String CustomerID = input.next();
                        System.out.print("Enter Password : ");
                        String Password = input.next();

                        // This IF condition verifies the customer type. (Line : 383-405)
                        if (CustomerID.equals("Customer") && Password.equals("Pass")) {
                            int option = 0;
                            while (option != 4) {
                                System.out.println("\n1. View Product List \n2. Order the Product \n3. View the Total Amount \n4. Exit at Customer Interface");
                                System.out.print("Which Option (No): ");
                                option = input.nextInt();

                                if (option == 1) {
                                    method.viewProduct(); // Method Calling...

                                } else if (option == 2) {
                                    method.orderProduct(); // Method Calling...

                                } else if (option == 3) {
                                    method.ViewOrderProduct(); // Method Calling...
                                }
                            }
                            break;
                        } else {
                            System.out.println("CustomerID or Password Incorrect :(");
                        }
                    }
                } else {
                    System.out.println("+++ Thank you +++");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please, Enter Number\n");
            }
        }
    }
}