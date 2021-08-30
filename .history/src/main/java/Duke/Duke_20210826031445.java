package duke;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import task.Deadline;
import task.Event;
import task.Task;
import task.TaskList;
import task.ToDo;
import ui.Ui;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }
    public static void main(String[] args) {
        String logo = " ____        _\n"
                + "|  _ \\ _   _| | _____\n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello! I'm\n" + logo + "\nHow can I help?");

        // TaskList l = new TaskList();
        // // int length = 0;
        // loadFile(l);
        // run(l); 
    }

    // public static void loadFile(TaskList l) {
    //     try {
    //         File directory = new File("../../../data");
    //         directory.mkdir();
    //         File data = new File("../../../data", "duke.txt");
    //         data.createNewFile();
    //         Scanner reader = new Scanner(data);
    //         while (reader.hasNextLine()) {
    //             String task = reader.nextLine();
    //             String[] vars = task.split("\\|");
    //             Task t;
    //             switch (vars[0].trim()) {
    //                 case "T": {
    //                     t = new ToDo(vars[2].trim());
    //                     break;
    //                 }
    //                 case "D": {
    //                     t = new Deadline(vars[2].trim(), vars[3].trim());
    //                     break;
    //                 }
    //                 case "E": {
    //                     t = new Event(vars[2].trim(), vars[3].trim());
    //                     break;
    //                 }
    //                 default: {
    //                     t = new ToDo("");
    //                     break;
    //                 }
    //             }
    //             if (Integer.parseInt(vars[1].trim()) == 1) {
    //                 t.completeItem();
    //             }
    //             l.addToList(t);
    //         }
    //         reader.close();
    //     } catch (FileNotFoundException e) {
    //         System.out.println(e.getMessage());
    //     } catch (IOException e) {
    //         System.out.println(e.getMessage());
    //     }
    // }

    // public static void updateFile(TaskList l) {
    //     try {
    //         System.out.println("Hello");
    //         FileWriter writer = new FileWriter("../../../../data/duke.txt", false);
    //         writer.write(l.format());
    //         writer.close();
    //     } catch (IOException e) {
    //         System.out.println(e.getMessage());
    //     }    
    // }

    public static void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
    }

   
}
