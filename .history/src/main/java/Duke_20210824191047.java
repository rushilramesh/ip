import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _\n"
                + "|  _ \\ _   _| | _____\n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello! I'm\n" + logo + "\nHow can I help?");

        TaskList l = new TaskList();
        // int length = 0;

        start(l);

        printOutput("Bye. Hope to see you again soon!");
    }

    public static void loadFile(TaskList l) {
        try {
            File data = new File("./data/duke.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
                String task = reader.nextLine();
                String[] vars = task.split(" | ");
                int complete = Integer.parseInt(vars[1]);
                switch (vars[0]) {
                    case "T": {
                        addToDo(vars[2], l, complete);
                        break;
                    }
                    case "D": {
                        String deadline = vars[2] + "/by " + vars[3];
                        addDeadline(deadline, l, complete);
                        break;
                    }
                    case "E": {
                        String event = vars[2] + "/at " + vars[3];
                        addEvent(event, l, complete);
                        break;
                    }
                    default: {
                        break;
                    }
        }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (DukeException e) {
            System.out.println(e);
        }
    }

    public static void loadTask(String s) {
        

    }

    public static void start(TaskList l) {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            input = scanner.nextLine();
            String[] commands = input.split(" ");
            String first = commands[0];
            String rest = "";
            if (commands.length > 1) {
                rest = input.substring(first.length() + 1);
            }
            try {
                if (first.equals("bye")) {
                    break;
                }
                switch (first) {
                    case "list": {
                        printOutput(l.toString());
                        break;
                    }
                    case "done": {
                        checkDone(rest, l);
                        break;
                    }
                    case "deadline": {
                        addDeadline(rest, l, 0);
                        break;
                    }
                    case "todo": {
                        addToDo(rest, l, 0);
                        break;
                    }
                    case "event": {
                        addEvent(rest, l, 0);
                        break;
                    }
                    case "delete": {
                        if (rest.matches("\\d+")) {
                            int index = Integer.parseInt(rest) - 1;
                            if (index >= 0 || index < l.getLength()) {
                                Task task = l.deleteTask(0);
                                printOutput("Noted. I've removed this task:\n" + task + "\nNow you have " + l.getLength() + " tasks in the list.");
                            }
                        }
                        break;
                    }
                    default: {
                        blah();
                        break;
                    }
                }
            } catch (DukeException e){
                printOutput(e.getMessage());
            }

        }
    }

    public static void addToDo(String rest, TaskList l, int complete) throws DukeException {
        if (rest.length() > 0){
            ToDo td = new ToDo(rest);
            if (complete == 1) {
                td.completeItem();
            }
            l.addToList(td);
            printOutput("Got it. I've added this task:\n" + td + "\nNow you have " + l.getLength() + " tasks in the list.");
            
        } else {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }

    public static void blah() throws DukeException {
        throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public static void addDeadline(String rest, TaskList l, int complete) throws DukeException {
        System.out.println(rest);
        if (rest.length() > 0) {
            String[] details = rest.split("/by ");
            if (details.length == 1) {
                throw new DukeException("☹ OOPS!!! Add a '/by deadline'");
            } else {
                Deadline deadline = new Deadline(details[0], details[1]);
                if (complete == 1) {
                    deadline.completeItem();
                }
                l.addToList(deadline);
                printOutput("Got it. I've added this task:\n" + deadline + "\nNow you have " + l.getLength() + " tasks in the list.");
            }
        } else {
            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
        }
    }

    public static void addEvent(String rest, TaskList l, int complete) throws DukeException {
        System.out.println(rest);
        if (rest.length() > 0) {
            String[] details = rest.split("/at ");
            if (details.length == 1) {
                throw new DukeException("☹ OOPS!!! Add a '/at time of event'");
            } else {
                Event event = new Event(details[0], details[1]);
                if (complete == 1) {
                    event.completeItem();
                }
                l.addToList(event);
                printOutput("Got it. I've added this task:\n" + event + "\nNow you have " + l.getLength() + " tasks in the list.");
            }
        } else {
            throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
        }
    }

    public static void checkDone(String rest, TaskList l) throws DukeException {
        if (rest.matches("\\d+")) {
            Task item = l.getItem(Integer.parseInt(rest) - 1);
            if (item != null) {
                printOutput(item.completeItem());
            } else {
                throw new DukeException("☹ OOPS!!! Input a valid index");
            }
        } else {
            throw new DukeException("☹ OOPS!!! Input a valid index");
        }
    }


    public static void printOutput(String input) {
        String line = "-------------------------------------";
        System.out.println(line + "\n" + input + "\n" + line + "\n");
    }

}

