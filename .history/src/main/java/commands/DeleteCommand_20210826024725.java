package commands;

import ui.Ui;
import duke.DukeException;
import storage.Storage;
import task.TaskList;

public class DeleteCommand extends Command{
    private String commands;

    public DeleteCommand(String commands) {
        this.commands = commands;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        
    }
}
