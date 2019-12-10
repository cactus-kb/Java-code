package pckage1;

class Animal { }

class Bird extends Animal { }

class AnimalException extends Exception {}

class BirdException extends AnimalException {}

public class MethodOverride {
    public Animal getAnimal() throws AnimalException {
        return null;
    }
}

class MethodOverrideChild extends MethodOverride {
    @Override
    public Bird getAnimal() throws BirdException {
        return null;
    }
}
