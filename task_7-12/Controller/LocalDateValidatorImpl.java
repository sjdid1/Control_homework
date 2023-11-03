package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateValidatorImpl implements LocalDateValidator{
    private DateTimeFormatter dateTimeFormatter;

    public LocalDateValidatorImpl(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }
    @Override
    public boolean isValid(String dateStr) {
        try {
            LocalDate.parse(dateStr, this.dateTimeFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}