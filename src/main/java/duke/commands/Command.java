package duke.commands;

import duke.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;



public abstract class Command {
    /**
     * Indicates if the command is an exit command.
     */
    public boolean isExit = false;

    /**
     * Executes the user's command.
     *
     * @param tasks Current tasklist.
     * @param storage Storage object which updates the local file.
     * @throws DukeException
     */
    abstract public String execute(TaskList tasks, Storage storage) throws DukeException;
}
