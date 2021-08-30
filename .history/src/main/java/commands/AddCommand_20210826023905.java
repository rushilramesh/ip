package commands;

import ui.Ui;
import storage.Storage;
import task.TaskList;
import commands.TaskType;

public class AddCommand extends Command {
    private TaskType type;
    private String commands;

    public AddCommand(TaskType type, String commands ) {
        this.type = type;
        this.commands = commands;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }
}
