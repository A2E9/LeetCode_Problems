package marx_exercise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

//bad code -> Nahrung inheriting Animal && canEat(String) checking Animal by String
//chnage animals sequence || only one specie can eat per round
//problrm raubtier eats all fish and there nomore or very small amount for vogel to survive left

public class animals_massacre {

    // Access Fields
    // Field[] fields = Animal.class.getDeclaredFields();
    // String animalName = animal.getName();
    // String fieldName = fields[3].getName();
    // Boolean animalFieldValue = (Boolean) fields[3].get(animal.newInstance());
    // System.out.println(animalName + " " + fieldName + " " + animalFieldValue);

    public static void displayCountObjects(ArrayList<Class<?>> gameObjects) throws InterruptedException {
        AtomicInteger atomicRaubtier = new AtomicInteger(0);
        AtomicInteger atomicVogel = new AtomicInteger(0);
        AtomicInteger atomicFisch = new AtomicInteger(0);
        AtomicInteger atomicPflanzenfr = new AtomicInteger(0);
        AtomicInteger atomicNahrung = new AtomicInteger(0);

        System.out.println();

        gameObjects.forEach((animalT) -> {
            if (animalT.getSimpleName().equals("Raubtier"))
                atomicRaubtier.incrementAndGet();
            else if (animalT.getSimpleName().equals("Vogel"))
                atomicVogel.incrementAndGet();
            else if (animalT.getSimpleName().equals("Fisch"))
                atomicFisch.incrementAndGet();
            else if (animalT.getSimpleName().equals("Pflanzenfresser"))
                atomicPflanzenfr.incrementAndGet();
            else if (animalT.getSimpleName().equals("Nahrung"))
                atomicNahrung.incrementAndGet();
        });
        System.out.println("Raubtiere: " + atomicRaubtier);
        System.out.println("Vogel: " + atomicVogel);
        System.out.println("Fisch: " + atomicFisch);
        System.out.println("Pflanzenfresser: " + atomicPflanzenfr);

        System.out.println("Nahrung: " + atomicNahrung);
        // Thread.sleep(4000);
        System.out.println();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, NoSuchFieldException, SecurityException, InvocationTargetException,
            NoSuchMethodException, InterruptedException {

        ArrayList<Class<?>> gameObjects = generateObjects();

        Method canEatAnimal = Animal.class.getDeclaredMethod("canEat", String.class);

        System.out.println("Spawning.\n");
        Thread.sleep(500);
        System.out.println("Spawning..\n");
        Thread.sleep(500);
        System.out.println("Spawning...\n");
        Thread.sleep(500);

        displayCountObjects(gameObjects);

        System.out.println("\nGame begins!");

        for (; (!gameObjects.isEmpty());) { // if nahrung only left -> exit
            if (((gameObjects.contains(Vogel.class)) || (gameObjects.contains(Raubtier.class))) //MAYBE BUG
                    && (gameObjects.contains(Nahrung.class))) { // Nahrungsfresser left -> exit

                System.out.println("\n\tNew Round\n");

                for (int index = 0; index < gameObjects.size(); index++) {
                    Class<?> animal = gameObjects.get(index);

                    if (animal == Nahrung.class) // Nahrung cannot eat
                        break;

                    Boolean foundFood = false;
                    Object hunter = animal.newInstance();

                    int lastIndexOfAnimal = gameObjects.lastIndexOf(animal) + 1;

                    for (int i = lastIndexOfAnimal; i < gameObjects.size(); i++) {
                        String animalToEat = gameObjects.get(i).getSimpleName();
                        if ((Boolean) canEatAnimal.invoke(hunter, animalToEat)) {// hunter eating
                            gameObjects.remove(i);
                            foundFood = true;
                            System.out.println(animal.getSimpleName() + " ate " + animalToEat + ".");
                            Thread.sleep(100);
                            break;
                        } else {
                            i += gameObjects.lastIndexOf(gameObjects.get(i)) - i; // last index of next animal
                        }
                    }
                    if (foundFood == false) {
                        gameObjects.remove(index);
                        index--; // stay on same index cz removed
                        System.out.println(animal.getSimpleName() + " died.");
                        Thread.sleep(100);
                    }

                }
            } else // Nahrungsesser left
                break;
        }

        System.out.println("\nAnimals survived:");

        displayCountObjects(gameObjects);
    }

    public static ArrayList<Class<?>> generateObjects() {
        ArrayList<Class<?>> animals = new ArrayList<Class<?>>();

        animals.addAll(randomAnimals(Raubtier.class));
        animals.addAll(randomAnimals(Vogel.class));
        animals.addAll(randomAnimals(Fisch.class));
        animals.addAll(randomAnimals(Pflanzenfresser.class));

        int size = animals.size();
        for (int i = size; i < size + 15; i++) { // 15 Nahrung
            animals.add(i, Nahrung.class);
        }
        return animals;
    }

    public static ArrayList<Class<?>> randomAnimals(Class<?> animal) {
        ArrayList<Class<?>> animals = new ArrayList<Class<?>>();
        Random rn = new Random();
        int random = 5 + rn.nextInt(9 - 5 + 1);
        int index = 0;
        for (; index < random; index++) {
            animals.add(index, animal);
        }

        return animals;
    }
}

abstract class Animal {
    public boolean eatsFisch = false;
    public boolean eatsPflanzenfresser = false;
    public boolean eatsVogel = false;
    public boolean eatsNahrung = false;

    public boolean canEat(String animal) {
        return false;
    }
}

class Raubtier extends Animal {
    public Raubtier() {
        eatsFisch = true;
        eatsPflanzenfresser = true;
        eatsNahrung = true;
    }

    public boolean canEat(String animal) {
        if (animal.equals("Fisch") || animal.equals("Pflanzenfresser") || animal.equals("Nahrung")) { //
            return true;
        }
        return false;
    }
}

class Fisch extends Animal {
    public Fisch() {
        eatsNahrung = true;
    }

    public boolean canEat(String animal) {
        if (animal.equals("Nahrung")) { // animal.equals("Nahrung")
            return true;
        }
        return false;
    }
}

class Pflanzenfresser extends Animal {
    public Pflanzenfresser() {
        eatsNahrung = true;
    }

    public boolean canEat(String animal) {
        if (animal.equals("Nahrung")) { // animal.equals("Nahrung")
            return true;
        }
        return false;
    }
}

class Vogel extends Animal {
    public Vogel() {
        eatsFisch = true;
    }

    public boolean canEat(String animal) {
        if (animal.equals("Fisch")) { // animal.equals("Fische")
            return true;
        }
        return false;
    }
}

class Nahrung extends Animal {// TODO For loop fields - 1 ||
    public Nahrung() {
    }
}
