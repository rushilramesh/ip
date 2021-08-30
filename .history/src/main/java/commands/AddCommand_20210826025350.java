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
                    ui.printOutput("Got it. I've added this task:\n" + td + "\nNow you have " + tasks.getLength() + " tasks in the list.");
                    storage.updateFile(tasks);
                } else {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }
            }
            case DEADLINE: {
                if (commands.length() > 0) {
                    try{
                        String[] details = commands.split("/by ");
                        if (details.length == 1) {
                            throw new DukeException("☹ OOPS!!! Add a '/by deadline'");
                        } else {
                            Deadline deadline = new Deadline(details[0], details[1]);
                            tasks.addToList(deadline);
                            ui.printOutput("Got it. I've added this task:\n" + deadline + "\nNow you have " + tasks.getLength() + " tasks in the list.");
                            storage.updateFile(tasks);
                        }
                    } catch (DateTimeParseException e) {
                        throw new DukeException("☹ OOPS!!! The date of the deadline is poorly formatted (d/MM/yyyy or d/MM/yyyy HHmm)"); 
                    }
                    
                } else {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                }
            }
            case EVENT: {

            }
            default: {
                break;
            }
        }
    }
}
