package model;

import java.time.LocalDate;

public class Dog extends Pets {

    public Dog(int id, String name, LocalDate birthDate, String commands) {
        super(id, name, birthDate, commands);
    }

    public Dog() {
    }
}