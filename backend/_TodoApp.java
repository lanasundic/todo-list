package backend;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> tasks = new ArrayList<>();
        boolean running = true;

        while(running) {
            System.out.println("\n--- TO-DO LIST ---");
            System.out.println("1. Add task");
            System.out.println("2. List all tasks");
            System.out.println("3. Delete task");
            System.out.println("4. Exit");
            System.out.println("Chose the option:");

            int choice = scanner.nextInt();
            scanner.nextLine();     //ocisti novi red

            switch(choice) {
                case 1:
                    System.out.println("Write a task: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Task has been added!");
                    break;

                case 2:
                    System.out.println("\n--- ALL TASKS ---");
                    if(tasks.isEmpty()) {
                        System.out.println("These are no tasks...");
                    } else {
                        for(int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter the task number to delete: ");
                    int index = scanner.nextInt() - 1;

                    if(index >= 0 && index < tasks.size()) {
                        System.out.println("Task '" + tasks.get(index) + "' has been deleted!");
                        tasks.remove(index);
                    } else {
                        System.out.println("Wrong number of the task.");
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Unknown option, try again.");
            }
        }
        scanner.close();
    }
}


/*Da bi browser(frontend) mogao da "prica" sa backendom, potrebno je da backend:
 * 1. radi kao web server
 * 2. ima API rute(kao "puteve" na koje frontend moze da salje zahtjeve - npr. /add, /list, /delete)
 * 
 * Znaci, umjesto Scanner u konzoli, moj backend treba da:
 * koristi Spark Java(ili Spring Boot, ali Spart je laksi...),
 * napravim male "rute" kao /add, /tasks, /delete
 * 
 * Frontend ce: slati poruke na te rute(npr. fetch() u js) i prikazivati rezultate korisniku
 * 
 */