package commands;

import ui.Ui;
import duke.DukeException;
import storage.Storage;
import task.TaskList;
import task.Task;

public class DeleteCommand extends Command{
    private String commands;

    public DeleteCommand(String commands) {
        this.commands = commands;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (commands.matches("\\d+")) {
            int index = Integer.parseInt(commands) - 1;
            if (index >= 0 && index < commands.getLength()) {
                Task task = l.deleteTask(0);
                printOutput("Noted. I've removed this task:\n" + task + "\nNow you have " + l.getLength() + " tasks in the list.");
                // updateFile(l);
            } else {
                throw new DukeException("☹ OOPS!!! Input a valid index"); 
            }
        } else {
            throw new DukeException("☹ OOPS!!! Input a valid index");
        }
    }
}
