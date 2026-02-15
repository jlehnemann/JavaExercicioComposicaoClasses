package application;

import entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine(), dtf1);

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        Order order = new Order(LocalDateTime.now(), status, client);

        System.out.print("How many items to this order? ");
        Integer itemsInOrder = sc.nextInt();
        sc.nextLine();

        for (int i=1; i<itemsInOrder+1; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            sc.nextLine();
            System.out.print("Quantity: ");
            Integer productQuantity = sc.nextInt();
            sc.nextLine();

            OrderItem orderItem = new OrderItem(productQuantity, new Product(productName, productPrice));
            order.addItem(orderItem);
        }

        System.out.println(order);






    }
}
