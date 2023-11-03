package data;

import model.Animal;

import java.util.List;

public interface DataProvider {
    public void save(String commandString);
    public List<Animal> load();
}
