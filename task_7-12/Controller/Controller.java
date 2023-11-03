package Controller;

import service.AnimalServiceImpl;
import data.DataProviderSql;
import view.View;

import java.util.Scanner;

public class Controller {
    AnimalServiceImpl animalService;
    View view;
    DataProviderSql dataProviderSql;
    Scanner in = new Scanner(System.in);

    public Controller() {
        this.animalService = new AnimalServiceImpl();
        this.view = new View();
        this.dataProviderSql = new DataProviderSql();
    }

    public void start() {
        view.menu();
        String stateMenu;
        while (true) {
            System.out.print("Выберите пункт меню: ");
            stateMenu = in.nextLine();
            switch (stateMenu) {
                // Список всех животных
                case "1" -> animalService.getList();
                // Добавление животного
                case "2" -> {
                    view.addAnimalMenu();
                    animalService.createAnimal();
                }
                // Список по дате рождения
                case "3" -> animalService.getByDate();
                // Добавление команд
                case "4" -> animalService.addCommands();
                // Список команд
                case "5" -> animalService.listOfCommands();
                //Вывод общего количества животных
                case "6" -> animalService.totalNumber();
                // Выход
                case "7" -> System.exit(0);
                case "help" -> view.menu();
                default -> System.out.print("Введен некорректный пункт меню!\n");
            }
        }
    }
}

