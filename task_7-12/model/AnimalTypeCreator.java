package model;


public class AnimalTypeCreator {
    public static Animal FindOutTypeOfAnimal (AnimalType animalType) {
        return switch (animalType) {
            case Cat -> new Cat();
            case Dog -> new Dog();
            case Hamster -> new Hamster();
            case Camel -> new Camel();
            case Horse -> new Horse();
            case Donkey -> new Donkey();
        };
    }

}
