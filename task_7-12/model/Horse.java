package model;

import java.time.LocalDate;

public class Horse extends PackAnimals{
    public Horse(int id, String name, LocalDate birthDate, String commands) {
        super(id, name, birthDate, commands);
    }

    public Horse() {
    }
}
