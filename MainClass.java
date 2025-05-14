package AutoMobileManagementSystems;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Automobile Management System----");
        AutoMobiles am = new AutoMobiles();
        am.login();
        while (true) {
            System.out.println("1.Add Table values");
            System.out.println("2.Update values");
            System.out.println("3.Delete values");
            System.out.println("4.Retrieve values");
            System.out.println("5.Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    am.add();
                    break;
                case 2:
                    am.Update();
                    break;
                case 3:
                    try {
                        am.delete();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    am.display();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
