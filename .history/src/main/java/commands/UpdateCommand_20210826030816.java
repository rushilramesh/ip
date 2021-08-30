package commands;

import task.TaskList;
import ui.Ui;
import duke.DukeException;
import storage.Storage;
import task.Task;

public class UpdateCommand extends Command {
    private String commands;

    public UpdateCommand(String commands) {
        this.commands = commands;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (commands.matches("\\d+")) {
            Task item = l.getItem(Integer.parseInt(commands) - 1);
            if (item != null) {
                printOutput(item.completeItem());
            } else {
                throw new DukeException("☹ OOPS!!! Input a valid index");
            }
        } else {
            throw new DukeException("☹ OOPS!!! Input a valid index");
        }
    }
    
}
