package commands;

import task.TaskList;
import ui.Ui;
import storage.Storage;

public abstract class Command {
    public static String COMMAND_WORD;
    abstract public void execute(TaskList tasks, Ui ui, Storage storage);
}
