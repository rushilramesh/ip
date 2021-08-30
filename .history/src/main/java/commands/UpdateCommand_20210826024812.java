package commands;

import task.TaskList;
import ui.Ui;
import duke.DukeException;
import storage.Storage;

public class UpdateCommand extends Command {
    private String commands;

    public UpdateCommand(String commands) {
        this.commands = commands;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        
    }
    
}
