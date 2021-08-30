import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    private LocalDate by;

    public Deadline(String input, String by) {
        super(input);
        this.by = LocalDate.parse(by.trim(), DateTimeFormatter.ofPattern("d/M/yyyy HHmm"));
    }

    @Override
    public  String toString() {
        return "[D] " + super.toString() + "(by: " + this.by.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }
}
