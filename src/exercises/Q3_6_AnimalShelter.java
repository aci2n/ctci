package exercises;

import misc.MyQueue;

import java.util.LinkedList;

public class Q3_6_AnimalShelter {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        Animal dog0 = new Animal("dog0", AnimalType.DOG);
        Animal dog1 = new Animal("dog1", AnimalType.DOG);
        Animal dog2 = new Animal("dog2", AnimalType.DOG);
        Animal cat0 = new Animal("cat0", AnimalType.CAT);
        Animal cat1 = new Animal("cat1", AnimalType.CAT);
        Animal cat2 = new Animal("cat2", AnimalType.CAT);

        shelter.enqueue(dog0);
        shelter.enqueue(dog1);
        shelter.enqueue(cat0);
        shelter.enqueue(cat1);
        shelter.enqueue(dog2);
        shelter.enqueue(cat2);

        assert !shelter.isEmpty();
        assert shelter.dequeueAny() == dog0;
        assert shelter.dequeueCat() == cat0;
        assert shelter.dequeueAny() == dog1;
        assert shelter.dequeueDog() == dog2;
        assert shelter.dequeueAny() == cat1;
        assert shelter.dequeueCat() == cat2;
        assert shelter.isEmpty();
    }

    private enum AnimalType {
        DOG, CAT
    }

    private static class Animal {
        private final String name;
        private final AnimalType type;

        Animal(String name, AnimalType type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public boolean equals(Object other) {
            if (other == null || !(other instanceof Animal))
                return false;
            Animal animal = (Animal) other;
            return name.equals(animal.name) && type.equals(animal.type);
        }
    }

    private static class AnimalShelter {
        private final LinkedList<Animal> list = new LinkedList<>();
        private final MyQueue<Animal> dogQueue = new MyQueue<>();
        private final MyQueue<Animal> catQueue = new MyQueue<>();

        public void enqueue(Animal animal) {
            list.add(animal);

            switch (animal.type) {
                case DOG:
                    dogQueue.add(animal);
                    break;
                case CAT:
                    catQueue.add(animal);
                    break;
            }
        }

        public Animal dequeueAny() {
            if (list.isEmpty()) {
                throw new RuntimeException();
            }

            Animal animal = list.pop();

            switch (animal.type) {
                case DOG:
                    dogQueue.remove();
                    break;
                case CAT:
                    catQueue.remove();
                    break;
            }

            return animal;
        }

        public Animal dequeueDog() {
            if (dogQueue.isEmpty()) {
                throw new RuntimeException();
            }

            Animal dog = dogQueue.remove();
            list.remove(dog);
            return dog;
        }

        public Animal dequeueCat() {
            if (catQueue.isEmpty()) {
                throw new RuntimeException();
            }

            Animal cat = catQueue.remove();
            list.remove(cat);
            return cat;
        }

        public boolean isEmpty() {
            if (list.isEmpty()) {
                assert dogQueue.isEmpty() && catQueue.isEmpty();
                return true;
            }

            assert !dogQueue.isEmpty() || !catQueue.isEmpty();
            return false;
        }
    }
}
