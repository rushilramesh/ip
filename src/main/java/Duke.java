import duke.DukeException;
import duke.commands.Command;
import duke.parser.Parser;
import duke.task.TaskList;
import duke.storage.Storage;



public class Duke {

    private TaskList tasks;
    private Storage storage;
    private boolean isExit;


    /**
     * Constructor for Duke. Initialises tasklist and storage
     */
    public Duke() {
        storage = new Storage();
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            tasks = new TaskList();
        }
    }


    public String getResponse(String input) {
        String response;
        try {
            Command c = Parser.parseCommand(input);
            response = c.execute(tasks, storage);
            isExit = c.isExit;
        } catch (DukeException e) {
            response = e.getMessage();
        }
        return response;
    }
}
