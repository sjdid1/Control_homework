package data;

import model.Animal;
import model.AnimalType;
import model.AnimalTypeCreator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataProviderSql implements DataProvider{
    public void save(String str) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()) {
                //System.out.println("Connection to Store DB successful!");
                Statement statement = conn.createStatement();
                statement.executeUpdate(str);
                System.out.println("Запись успешно добавлена!");
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex.getMessage());
        }
    }
    public List<Animal> load() {
        List<Animal> animals = new ArrayList<>();
        try {
            String sqlCommandSelect = "SELECT * FROM animals";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlCommandSelect);
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String type = resultSet.getString(3);
                    LocalDate birthdate = resultSet.getDate(4).toLocalDate();
                    String commands = resultSet.getString(5);

                    AnimalType animalType = AnimalType.CreateTypeOfAnimalFromSql(type);
                    Animal animal = AnimalTypeCreator.FindOutTypeOfAnimal(animalType);
                    animal.setId(id);
                    animal.setName(name);
                    animal.setBirthDate(birthdate);
                    animal.setCommands(commands);
                    animals.add(animal);
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex.getMessage());
        }
        return animals;
    }

    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}

