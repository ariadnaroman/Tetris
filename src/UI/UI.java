package UI;

import Controller.DFS;
import Controller.GBFS;
import Controller.SearchMethod;
import Domain.Table;

import java.util.Random;
import java.util.Scanner;

public class UI {
    SearchMethod<Table> searchMethod;

    public UI() {
    }

    public UI(SearchMethod<Table> searchMethod) {
        this.searchMethod = searchMethod;
    }

    public void setSearchMethod(SearchMethod<Table> searchMethod) {
        this.searchMethod = searchMethod;
    }

    public void readDataMenu() {
        System.out.println();
        System.out.println("Select a search method(DFS/GBFS): ");
        Scanner scanner = new Scanner(System.in);
        String amCitit = scanner.next();
        if (amCitit.equals("DFS")) {
            System.out.println("Select n (between 4 and 6):");
            int n = scanner.nextInt();
            System.out.println("Select m (between 4 and 6):");
            int m = scanner.nextInt();
            if (n<4 || n>6 || m<4 || m>6) {
                System.out.println("Try again.");
                readDataMenu();
                return;
            }
            setSearchMethod(new DFS(n,m));
        } else if (amCitit.equals("GBFS")){
            System.out.println("Select n (greater than 4):");
            int n = scanner.nextInt();
            System.out.println("Select m (greater than 4):");
            int m = scanner.nextInt();
            if (n<4 || m<4) {
                System.out.println("Try again.");
                readDataMenu();
                return;
            }
            setSearchMethod(new GBFS(n,m));
        } else {
            System.out.println("DFS or GBFS!!!");
            System.out.println("Try again.");
            readDataMenu();
        }
    }

    public void showMainMenu() {
        while (true) {
            System.out.println();
            System.out.println("T E T R I S");
            System.out.println();
            System.out.println("Do you want the data to be randomly chosed? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String amCitit = scanner.next();
            if (amCitit.equals("Y")) {
                Random random = new Random();
                if (random.nextInt() % 2 == 0) {
                    Random random1 = new Random();
                    int n = random1.nextInt(3) + 4;
                    Random random2 = new Random();
                    int m = random2.nextInt(3) + 4;
                    setSearchMethod(new DFS(n, m));
                } else {
                    Random random1 = new Random();
                    int n = random1.nextInt(6) + 5;
                    Random random2 = new Random();
                    int m = random2.nextInt(6) + 5;
                    setSearchMethod(new GBFS(n, m));
                }
            } else if (amCitit.equals("N"))
            {
                readDataMenu();
            } else {
                System.out.println("(Y/N).");
                System.out.println("Try again...");
                showMainMenu();
            }

            Table table = searchMethod.search();
            System.out.println();
            System.out.println("The result is: ");
            System.out.println(table);
            System.out.println();
        }
    }
}
