package storage;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import task.Task;
import task.ToDo;
import task.Deadline;
import task.Event;
import duke.DukeException;

public class Storage {
    private String filepath;
    
    public Storage(String filepath) {
        this.filepath = filepath;
    }

    public ArrayList<Task> load() throws DukeException {
        ArrayList<Task> listOfTasks = new ArrayList<>();
        try {
            File directory = new File("../../../data");
            directory.mkdir();
            File data = new File("../../../data", "duke.txt");
            data.createNewFile();
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
                String task = reader.nextLine();
                String[] vars = task.split("\\|");
                Task t;
                switch (vars[0].trim()) {
                    case "T": {
                        t = new ToDo(vars[2].trim());
                        break;
                    }
                    case "D": {
                        t = new Deadline(vars[2].trim(), vars[3].trim());
                        break;
                    }
                    case "E": {
                        t = new Event(vars[2].trim(), vars[3].trim());
                        break;
                    }
                    default: {
                        t = new ToDo("");
                        break;
                    }
                }
                if (Integer.parseInt(vars[1].trim()) == 1) {
                    t.completeItem();
                }
                listOfTasks.add(t);
            }
            reader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
        return listOfTasks;
    }
}
