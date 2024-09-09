package todolist;


public class Task {
	private String description;
	private String dueDate;
	private int priority; // Added priority field

	public Task(String description, String dueDate, int priority) {
		this.description = description;
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Task: " + description + ", Due: " + dueDate + ", Priority: " + priority;
	}
}

