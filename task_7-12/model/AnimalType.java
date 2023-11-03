package model;

public enum AnimalType {
    Cat,
    Dog,
    Hamster,
    Horse,
    Camel,
    Donkey;

    public static AnimalType getAnimalTypeByNumber(int number) {

        return switch (number) {
            case 1 -> AnimalType.Cat;
            case 2 -> AnimalType.Dog;
            case 3 -> AnimalType.Hamster;
            case 4 -> AnimalType.Horse;
            case 5 -> AnimalType.Camel;
            case 6 -> AnimalType.Donkey;
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }

    public static AnimalType CreateTypeOfAnimalFromSql(String typeFromSql) {
        return switch (typeFromSql) {
            case "Cat" -> AnimalType.Cat;
            case "Dog" -> AnimalType.Dog;
            case "Hamster" -> AnimalType.Hamster;
            case "Camel" -> AnimalType.Camel;
            case "Horse" -> AnimalType.Horse;
            case "Donkey" -> AnimalType.Donkey;
            default -> throw new IllegalStateException("Unexpected value: " + typeFromSql);
        };
    }
}