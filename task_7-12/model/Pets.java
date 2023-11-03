package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public abstract class Pets extends Animal {
    public Pets(int id, String name, LocalDate birthDate, String commands) {
        super(id, name, birthDate, commands);
    }

    public Pets() {
    }
}
