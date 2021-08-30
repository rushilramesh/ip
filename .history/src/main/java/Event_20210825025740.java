import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDate at;

    public Event(String input, String at) {
        super(input);
        this.at = LocalDate.parse(at.trim(), DateTimeFormatter.ofPattern("d/MM/yyyy HHmm"));
        if (this.at.isBefore(LocalDate.now())) {
            super.completeItem();
        }
    }

    @Override
    public  String toString() {
        return "[E] " + super.toString() + "(at: " + this.at.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }
}