package view;

import model.AuthenticPhone;
import model.HandPhone;
import model.Phone;
import service.PhoneService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static PhoneService phoneService = new PhoneService();

    public static void main(String[] args) {
        while(true){
            System.out.println("----- Menu -----");
            System.out.println("1. Create");
            System.out.println("2. Display");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Exit");

            int choice = getChoice();

            switch (choice){
                case 1:
                    create();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void create() {
        System.out.println("1. Authentic\n2. Hand");
        int choice = getChoice();

        System.out.print("Name:");
        String name = scanner.nextLine();
        System.out.print("Price:");
        Double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Manufacture:");
        String manufacturer = scanner.nextLine();

        if(choice == 1){
            System.out.print("Grantee By Year:");
            int granteeByYear = Integer.parseInt(scanner.nextLine());
            System.out.print("Grantee By Code:");
            String code = scanner.nextLine();
            AuthenticPhone authentic = new AuthenticPhone(0, name, price, manufacturer, granteeByYear, code);
            phoneService.create(authentic);
        }
        else{
            System.out.print("Country:");
            String country = scanner.nextLine();
            System.out.print("Status:");
            String status = scanner.nextLine();
            HandPhone hand = new HandPhone(0, name, price, manufacturer, country, status);
            phoneService.create(hand);
        }
        System.out.println("Created successfully");

    }

    private static void display() {
        List<Phone> phones = phoneService.findAll();

        for (int i = 0; i < phones.size(); i++) {
            System.out.println(phones.get(i));
        }
    }

    private static void delete() {
        display();
        System.out.println("Enter id to delete:");
        System.out.print("Id:");
        int id =Integer.parseInt(scanner.nextLine());
        phoneService.delete(id);
        System.out.println("Deleted successfully");
    }

    private static void search() {
        System.out.print("Input name to search:");
        String name = scanner.nextLine();
        List<Phone> phones = phoneService.search(name);

        if(phones.size() > 0){
            for (int i = 0; i < phones.size(); i++) {
                System.out.println(phones.get(i));
            }
        }
        else{
            System.out.println("Empty list");
        }
    }

    private static int getChoice(){
        System.out.print("Enter your choice:");
        return  Integer.parseInt(scanner.nextLine());
    }
}
