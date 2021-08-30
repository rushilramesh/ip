import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDate at;
    public Event(String input, String at) {
        super(input);
        this.at = LocalDate.parse(at.trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm"));
    }

    @Override
    public  String toString() {
        return "[E] " + super.toString() + "(at: " + this.at.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }
}