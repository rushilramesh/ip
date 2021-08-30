import java.util.ArrayList;
import java.util.stream.*;

public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
       this.list = new ArrayList<>();
    }

    public void addToList(Task input) {
        list.add(input);
    }

    public Task getItem(int index) {
        if (this.list.size() <= index || index < 0) {
            return null;
        }
        return this.list.get(index);
    }

    public int getLength() {
        return this.list.size();
    }

    public Task deleteTask(int index) {
        return this.list.remove(index);
    }

    public String format() {
        String x =  "";
        for (Task task : this.list) {
            x += task.toString() + "\n";
        }
        
        return x;
    }
    @Override
    public String toString() {
        String l = "Here are the tasks on your list:";
        for (Task s : list) {
            l += "\n" + (list.indexOf(s) + 1) + ". " + s;
        }
        return l;
    }
}
