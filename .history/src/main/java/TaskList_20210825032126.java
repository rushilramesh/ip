import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;
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

    public Task[] taskOnDate(String date) {
        LocalDate search = LocalDate.parse(date.trim(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
        this.list.stream().filter(search.equals(obj))
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
