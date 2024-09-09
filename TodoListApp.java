package todolist;

import java.util.Scanner;

public class TodoListApp {
	private static Task[] tasks = new Task[10];
	private static int taskCount = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String command;

		System.out.println("Welcome to the To-Do List App!");
		while (true) {
			System.out.println("\nCommands:");
			System.out.println("1. Add Task");
			System.out.println("2. Remove Task");
			System.out.println("3. View Tasks");
			System.out.println("4. Exit");
			System.out.print("Enter command: ");
			command = scanner.nextLine();

			switch (command) {
			case "1":
				addTask(scanner);
				break;
			case "2":
				removeTask(scanner);
				break;
			case "3":
				viewTasks();
				break;
			case "4":
				System.out.println("Exiting the application...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid command. Please try again.");
			}
		}
	}

	private static void addTask(Scanner scanner) {
		if (taskCount >= tasks.length) {
			System.out.println("Task list is full. Cannot add more tasks.");
			return;
		}

		System.out.print("Enter the task description: ");
		String description = scanner.nextLine();
		System.out.print("Enter the due date (YYYY-MM-DD): ");
		String dueDate = scanner.nextLine();

		tasks[taskCount] = new Task(description, dueDate);
		taskCount++;
		System.out.println("Task added successfully.");
	}

	private static void removeTask(Scanner scanner) {
		if (taskCount == 0) {
			System.out.println("No tasks to remove.");
			return;
		}

		viewTasks();
		System.out.print("Enter the number of the task to remove: ");
		int taskNumber = Integer.parseInt(scanner.nextLine());

		if (taskNumber < 1 || taskNumber > taskCount) {
			System.out.println("Invalid task number.");
			return;
		}

		for (int i = taskNumber - 1; i < taskCount - 1; i++) {
			tasks[i] = tasks[i + 1];
		}
		tasks[taskCount - 1] = null;
		taskCount--;
		System.out.println("Task removed successfully.");
	}

	private static void viewTasks() {
		if (taskCount == 0) {
			System.out.println("No tasks to display.");
			return;
		}

		System.out.println("\nYour To-Do List:");
		for (int i = 0; i < taskCount; i++) {
			System.out.println((i + 1) + ". " + tasks[i]);
		}
	}
}
