package model;

import java.time.LocalDate;


public abstract class PackAnimals extends Animal {
    public PackAnimals(int id, String name, LocalDate birthDate, String commands) {
        super(id, name, birthDate, commands);
    }

    public PackAnimals() {
    }
}
