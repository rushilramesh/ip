package commands;

import ui.Ui;
import storage.Storage;
import task.TaskList;
import task.ToDo;
import task.Deadline;
import task.Event;
import commands.TaskType;
import duke.DukeException;

public class AddCommand extends Command {
    private TaskType type;
    private String commands;

    public AddCommand(TaskType type, String commands ) {
        this.type = type;
        this.commands = commands;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException{
        switch (type) {
            case TO_DO: {
                if (commands.length() > 0){
                    ToDo td = new ToDo(commands);
                    tasks.addToList(td);
                    printOutput("Got it. I've added this task:\n" + td + "\nNow you have " + tasks.getLength() + " tasks in the list.");
                    storage.updateFile(tasks);
                } else {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }
            }
            case DEADLINE: {

            }
            case EVENT: {

            }
            default: {
                break;
            }
        }
    }
}
