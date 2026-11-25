import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        // Activity 1: Add tasks and display task list
        System.out.println("====== ADD TASKS ======");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Task " + (i + 1) + ": ");
            String task = scanner.nextLine();
            tasks.add(task);
        }

        System.out.println("\n====== TASK LIST ======");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        // Activity 2.1: Save all tasks into task.txt
        String fileName = "task.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
            System.out.println("\nTasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }

        // Activity 2.2 & 2.3: Read from task.txt and display loaded tasks
        System.out.println("\n====== TASKS LOADED FROM FILE ======");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading tasks: " + e.getMessage());
        }

        scanner.close();
    }
}