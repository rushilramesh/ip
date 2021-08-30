import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDate at;

    public Event(String input, String at) {
        super(input);
        int space = at.indexOf(" ");
        String format = space > 0 ? "d/MM/yyyy HHmm" : "d/MM/yyyy"; 
        this.at = LocalDate.parse(at.trim(), DateTimeFormatter.ofPattern(format));
        if (this.at.isBefore(LocalDate.now())) {
            super.completeItem();
        }
    }

    public LocalDate getDate() {
        return this.at;
    }

    @Override
    public  String toString() {
        return "[E] " + super.toString() + "(at: " + this.at.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }
}