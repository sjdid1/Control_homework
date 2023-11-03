package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public abstract class Animal implements Comparable<Animal>{
    protected int id;
    protected String name;
    protected LocalDate birthDate;
    protected String commands;

    public Animal(int id, String name, LocalDate birthDate, String commands) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public Animal() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return String.format("%-4d%-12s%-8s%-12s%-15s", getId(),
                getName(),
                getClass().getSimpleName(),
                getBirthDate().toString(),
                getCommands());

    }

    @Override
    public int compareTo(Animal animal) {
        return this.getBirthDate().compareTo(animal.getBirthDate());
    }

}