package commands;

import task.TaskList;
import ui.Ui;
import storage.Storage;

public class ExitCommand  extends Command {
    public ExitCommand() {
        this.isExit = true;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        
    }
}
