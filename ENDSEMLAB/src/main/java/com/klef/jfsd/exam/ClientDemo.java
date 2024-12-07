package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ClientDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Scanner scanner = new Scanner(System.in);

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            boolean isRunning = true;

            while (isRunning) {
                displayMenu();
                int userChoice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                if (userChoice == 4) {
                    isRunning = false;
                    break;
                }

                processUserChoice(userChoice, session, scanner);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
            scanner.close();
        }

        System.out.println("Program terminated.");
    }

    private static void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Add Device");
        System.out.println("2. Add SmartPhone");
        System.out.println("3. Add Tablet");
        System.out.println("4. Exit");
    }

    private static void processUserChoice(int choice, Session session, Scanner scanner) {
        switch (choice) {
            case 1:
                addDevice(session, scanner);
                break;

            case 2:
                addSmartPhone(session, scanner);
                break;

            case 3:
                addTablet(session, scanner);
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private static void addDevice(Session session, Scanner scanner) {
        Device device = new Device();
        System.out.println("Enter Device ID: ");
        device.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter Device Brand: ");
        device.setBrand(scanner.nextLine());
        System.out.println("Enter Device Model: ");
        device.setModel(scanner.nextLine());
        System.out.println("Enter Device Price: ");
        device.setPrice(scanner.nextDouble());
        session.save(device);
        System.out.println("Device added successfully!");
    }

    private static void addSmartPhone(Session session, Scanner scanner) {
        SmartPhone smartPhone = new SmartPhone();
        System.out.println("Enter SmartPhone ID: ");
        smartPhone.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter SmartPhone Brand: ");
        smartPhone.setBrand(scanner.nextLine());
        System.out.println("Enter SmartPhone Model: ");
        smartPhone.setModel(scanner.nextLine());
        System.out.println("Enter SmartPhone Price: ");
        smartPhone.setPrice(scanner.nextDouble());
        scanner.nextLine();  // Consume newline
        System.out.println("Enter Camera Specification: ");
        smartPhone.setCamera(scanner.nextLine());
        System.out.println("Enter Operating System: ");
        smartPhone.setOs(scanner.nextLine());
        session.save(smartPhone);
        System.out.println("SmartPhone added successfully!");
    }

    private static void addTablet(Session session, Scanner scanner) {
        Tablet tablet = new Tablet();
        System.out.println("Enter Tablet ID: ");
        tablet.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter Tablet Brand: ");
        tablet.setBrand(scanner.nextLine());
        System.out.println("Enter Tablet Model: ");
        tablet.setModel(scanner.nextLine());
        System.out.println("Enter Tablet Price: ");
        tablet.setPrice(scanner.nextDouble());
        scanner.nextLine();  // Consume newline
        System.out.println("Enter Battery Life: ");
        tablet.setBattery(scanner.nextLine());
        System.out.println("Enter Screen Size: ");
        tablet.setScreensize(scanner.nextDouble());
        session.save(tablet);
        System.out.println("Tablet added successfully!");
    }
}
