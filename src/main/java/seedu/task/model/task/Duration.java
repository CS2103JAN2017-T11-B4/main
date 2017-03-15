package seedu.task.model.task;

import java.util.Calendar;
import java.util.Objects;

import seedu.task.commons.exceptions.IllegalValueException;
import seedu.task.model.util.DateParser;

public class Duration {
    Calendar start;
    Calendar end;

    /**
     * Validates given duration.
     *
     * @throws IllegalValueException if given duration string is invalid.
     */
    public Duration(String start, String end) throws IllegalValueException {
        assert start != null && end != null;
        this.start = DateParser.parse(start);
        this.end = DateParser.parse(end);
    }

    public Calendar getStart() {
        return this.start;
    }

    public void setStart(String start) throws IllegalValueException {
        this.start = DateParser.parse(start);
    }

    Calendar getEnd() {
        return this.start;
    }

    void setEnd(String end) throws IllegalValueException {
        this.end = DateParser.parse(end);
    }

    String getStartString() {
        return DateParser.toString(this.start);
    }

    String getEndString() {
        return DateParser.toString(this.end);
    }

    @Override
    public String toString() {
        return "Start: " + DateParser.toString(this.start) + " End: " + DateParser.toString(this.end);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Duration // instanceof handles nulls
                && this.start.equals(((Duration) other).start) // state check
                && this.start.equals(((Duration) other).end)); // state check
    }

    @Override
    public int hashCode() {
        return Objects.hash(start.hashCode(), end.hashCode());
    }

}