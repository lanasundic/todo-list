#import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> tasks = new ArrayList<>();
        boolean running = true;

        while(running) {
            System.out.println("\n--- TO-DO LIST ---");
            System.out.println("1. Dodaj zadatak");
            System.out.println("2. Prikazi sve zadatke");
            System.out.println("3. Obrisi zadatak");
            System.out.println("4. Izlaz");
            System.out.println("Izaberi opciju:");

            int choice = scanner.nextInt();
            scanner.nextLine();     //ocisti novi red

            switch(choice) {
                case 1:
                    System.out.println("Unesi zadatak: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Zadatak dodat!");
                    break;

                case 2:
                    System.out.println("\n--- SVI ZADACI ---");
                    if(tasks.isEmpty()) {
                        System.out.println("Nema zadataka.");
                    } else {
                        for(int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("Unesi broj zadatka za brisanje: ");
                    int index = scanner.nextInt() - 1;

                    if(index >= 0 && index < tasks.size()) {
                        System.out.println("Zadatak '" + tasks.get(index) + "' obrisan!");
                        tasks.remove(index);
                    } else {
                        System.out.println("Pogresan broj zadatka.");
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Dovidjenja!");
                    break;
                default:
                    System.out.println("Nepoznata opcija, pokusaj ponovo.");
            }
        }
        scanner.close();
    }
}
