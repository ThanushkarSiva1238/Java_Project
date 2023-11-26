package LO1_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Items{
    String Product_ID, Product_Name;
    int Product_Quantity;
    float Product_Price;

    public Items(String Product_ID, String Product_Name, int Product_Quantity, float Product_Price) {
        this.Product_ID = Product_ID;
        this.Product_Name = Product_Name;
        this.Product_Quantity = Product_Quantity;
        this.Product_Price = Product_Price;
    }
}

class Order{
    String Order_Product;
    int Order_Quantity;
    float Total_Payment;

    public Order(String Order_Product, int Order_Quantity, float Total_Payment){
        this.Order_Product = Order_Product;
        this.Order_Quantity = Order_Quantity;
        this.Total_Payment = Total_Payment;
    }
}

public class SampathFC {
    public static void main(String[] args) {
        List<Items> Product_List = new ArrayList<>();
        List<Order> Order_List = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        System.out.println(">>>>> Sampath Food City (PVT) Ltd <<<<<");

        int user = 0;
        while (user != 3){
            System.out.println("1. Admin \n2. Customer \n3. Exit the Program");
            System.out.print("Choose one : ");
            user = input.nextInt();

            if (user == 1){
                System.out.println("\n+++++ Admin Interface +++++");

                for (int count = 1; count <= 3; count++){
                    System.out.print("Enter Admin ID : ");
                    String AdminID = input.next();
                    System.out.print("Enter Password : ");
                    String Password = input.next();

                    if (AdminID.equals("Admin") && Password.equals("Pass")){

                        int option = 0;
                        while (option != 5){
                            if (!Product_List.isEmpty()){
                                System.out.println("\nProduct List");
                                for (Items view:Product_List){
                                    System.out.printf("%s => %s(%d) \n\tPrice : Rs. %.2f\n", view.Product_ID, view.Product_Name, view.Product_Quantity, view.Product_Price);
                                }
                            }
                            System.out.println("\n1. Add Product \n2. Modify Product \n3. Remove Product \n4. View Customer Order \n5. Exit at Admin Interface");
                            System.out.print("Which Option : ");
                            option = input.nextInt();

                            if (option == 1){
                                System.out.println("--- Add Product ---\n");

                                char add_product = 'y';
                                while (add_product == 'y'){
                                    System.out.print("Enter Product ID : ");
                                    String ProductID = input.next().toUpperCase();
                                    System.out.print("Enter Product Name : ");
                                    String ProName = input.next();
                                    System.out.print("Enter Quantity : ");
                                    int quan = input.nextInt();
                                    System.out.print("Enter Price : ");
                                    float amount = input.nextFloat();

                                    Items add = new Items(ProductID, ProName, quan, amount);
                                    Product_List.add(add);
                                    System.out.println("Product Added Successfully...");

                                    System.out.print("Add more Product (Y/N): ");
                                    add_product = input.next().toLowerCase().charAt(0);

                                }

                            }
                            else if (option == 2) {
                                if (!Product_List.isEmpty()){
                                    System.out.println("--- Modify Product ---\n");
                                    char modify_product = 'y';
                                    while (modify_product == 'y'){
                                        System.out.print("Enter Product ID : ");
                                        String ProductID = input.next().toUpperCase();

                                        int index = -1;

                                        for (int i = 0; i < Product_List.size(); i++) {
                                            Items currentItem = Product_List.get(i);
                                            if (currentItem.Product_ID.equals(ProductID)) {
                                                index = i;
                                                break;
                                            }
                                        }

                                        if (index != -1) {
                                            Items answer = Product_List.get(index);
                                            System.out.println("1. Modify Product Name \n2. Modify Product Quantity \n3. Modify Product Price");
                                            System.out.print("Select one : ");
                                            int select = input.nextInt();

                                            if (select == 1){
                                                System.out.print("\nEnter Product Name : ");
                                                answer.Product_Name = input.next();
                                                System.out.println("Product Name Modified Successfully...");

                                            } else if (select == 2) {
                                                System.out.print("\nEnter Product Quantity : ");
                                                answer.Product_Quantity = input.nextInt();
                                                System.out.println("Product Quantity Modified Successfully...");

                                            } else if (select == 3) {
                                                System.out.print("\nEnter Product Price : ");
                                                answer.Product_Price = input.nextFloat();
                                                System.out.println("Product Price Modified Successfully...");

                                            } else {
                                                System.out.println("Invalid Input");
                                            }
                                            break;
                                        } else {
                                            System.out.println("Product ID not found.");
                                        }

                                        System.out.print("Modify more Detail (Y/N): ");
                                        modify_product = input.next().toLowerCase().charAt(0);
                                    }
                                } else {
                                    System.out.println("\tThe list of products is currently blank...");
                                }

                            }
                            else if (option == 3) {
                                if (!Product_List.isEmpty()) {
                                    System.out.println("--- Remove Product ---\n");
                                    System.out.print("Enter Product ID : ");
                                    String ProductID = input.next().toUpperCase();

                                    int index = -1;
                                    for (int i = 0; i < Product_List.size(); i++) {
                                        Items currentItem = Product_List.get(i);
                                        if (currentItem.Product_ID.equals(ProductID)) {
                                            index = i;
                                            break;
                                        }
                                    }

                                    if (index != -1) {
                                        Product_List.remove(index);
                                        System.out.println("Product Removed Successfully...");
                                    } else {
                                        System.out.println("Product ID not found.");
                                    }
                                } else {
                                    System.out.println("\tThe list of products is currently blank...");
                                }
                            }
                            else if (option == 4) {
                                if (!Order_List.isEmpty()) {
                                    System.out.println("--- View Customer Order ---\n");
                                    float Grand_Total = 0;
                                    for (Order view:Order_List){
                                        System.out.printf("%s(%d) \n\tAmount : Rs. %.2f\n", view.Order_Product, view.Order_Quantity, view.Total_Payment);
                                        Grand_Total = Grand_Total + view.Total_Payment;
                                    }
                                    System.out.printf("\n Grand Total : Rs. %.2f", Grand_Total);
                                } else {
                                    System.out.println("\tThe Order list is Empty...");
                                }
                            }
                        }
                        System.out.println(" ");
                        break;
                    }else {
                        System.out.println("AdminID or Password Incorrect :(");
                    }
                }
            }

            else if (user == 2) {
                System.out.println("\n+++++ Customer Interface +++++");

                for (int count = 1; count <= 3; count++){
                    System.out.print("Enter Customer ID : ");
                    String CustomerID = input.next();
                    System.out.print("Enter Password : ");
                    String Password = input.next();

                    if (CustomerID.equals("Customer") && Password.equals("Pass")){
                        int option = 0;
                        while (option != 4){
                            System.out.println("\n1. View Product List \n2. Order the Product \n3. View the Total Amount \n4. Exit at Customer Interface");
                            System.out.print("Which Option : ");
                            option = input.nextInt();

                            if (option == 1){
                                if (!Product_List.isEmpty()) {
                                    System.out.println("--- View Product List ---\n");

                                    for (Items view:Product_List){
                                        System.out.printf("%s => %s \n\tPrice : Rs. %.2f\n", view.Product_ID, view.Product_Name, view.Product_Price);
                                    }
                                } else {
                                    System.out.println("\tThe list of products is currently blank...");
                                }

                            }
                            else if (option == 2) {
                                if (!Product_List.isEmpty()) {
                                    System.out.println("--- Order the Product ---\n");
                                    char order_product = 'y';
                                    while (order_product == 'y') {
                                        System.out.print("Enter Product ID : ");
                                        String ProductID = input.next().toUpperCase();

                                        int index = -1;

                                        for (int i = 0; i < Product_List.size(); i++) {
                                            Items currentItem = Product_List.get(i);
                                            if (currentItem.Product_ID.equals(ProductID)) {
                                                index = i;
                                                break;
                                            }
                                        }

                                        if (index != -1) {
                                            Items answer = Product_List.get(index);
                                            System.out.print("Enter Quantity : ");
                                            int quantity = input.nextInt();

                                            if (quantity <= answer.Product_Quantity) {
                                                float Total = quantity * answer.Product_Price;
                                                answer.Product_Quantity =- quantity;
                                                Order add = new Order(answer.Product_Name, quantity, Total);
                                                Order_List.add(add);
                                                System.out.println("Product added in cart");
                                            } else {
                                                System.out.println("Low Quantity :(");
                                            }

                                        } else {
                                            System.out.println("Product ID not found.");
                                        }

                                        System.out.print("\nModify more Detail (Y/N): ");
                                        order_product = input.next().toLowerCase().charAt(0);
                                    }
                                } else {
                                    System.out.println("\tThe list of products is currently blank...");
                                }

                            }
                            else if (option == 3) {
                                System.out.println("--- View the Total Amount ---\n");

                                float grand_total = 0;
                                for (Order view:Order_List){
                                    grand_total += view.Total_Payment;
                                }
                                System.out.printf("Grand Total : Rs. %.2f\n" ,grand_total);

                            }
                        }
                        System.out.println(" ");
                        break;
                    }
                    else {
                        System.out.println("CustomerID or Password Incorrect :(");
                    }
                }
            }

            else {
                return;
            }

        }
    }
}
