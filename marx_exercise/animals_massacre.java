package marx_exercise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class animals_massacre {
    
    // Access Fields
    // Field[] fields = Animal.class.getDeclaredFields();
    // String animalName = animal.getName();
    // String fieldName = fields[3].getName();
    // Boolean animalFieldValue = (Boolean) fields[3].get(animal.newInstance());
    // System.out.println(animalName + " " + fieldName + " " + animalFieldValue);
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, NoSuchFieldException, SecurityException, InvocationTargetException,
            NoSuchMethodException {

        ArrayList<Class<?>> gameObjects = generateObjects();

        Method method = Animal.class.getDeclaredMethod("canEat", String.class);
        // Raubtier, Fisch, Pflanzenfresser -> Nahrungsessende gewinnen
        System.out.println("Objects in game: " + gameObjects.size());
        for (; gameObjects.isEmpty();)
            for (int index = 0; index < gameObjects.size(); index++) {
                Class<?> animal = gameObjects.get(index);
                if (animal == Nahrung.class)
                    break;
                Boolean foundFood = false;
                Object obj = animal.newInstance();

                int lastIndexOfAnimal = gameObjects.lastIndexOf(animal) + 1;

                for (int i = lastIndexOfAnimal; i < gameObjects.size(); i++) {
                    String crrAnimalToEat = gameObjects.get(i).getCanonicalName();
                    if ((Boolean) method.invoke(obj, crrAnimalToEat)) {
                        gameObjects.remove(i);
                        foundFood = true;
                        break;
                    } else {
                        i += gameObjects.lastIndexOf(gameObjects.get(i)) - i;
                    }
                }
                if (!foundFood) {
                    gameObjects.remove(index);
                }

            }

        // ArrayList<Class<?>> copy = new ArrayList<>(gameObjects);
        // int animalIndex = 0;

        // for (Class<?> animal : copy) {
        // Boolean foundFood = false;

        // Object obj = animal.newInstance();
        // int lastIndexOfAnimal = gameObjects.lastIndexOf(animal)+1;
        // for (int index = gameObjects.lastIndexOf(gameObjects.get(lastIndexOfAnimal));
        // index < gameObjects.size(); index++) {
        // String tempAnimal =
        // gameObjects.get(gameObjects.lastIndexOf(gameObjects.get(lastIndexOfAnimal))).getCanonicalName();
        // if((Boolean) method.invoke(obj, tempAnimal) ){
        // gameObjects.remove(index);
        // foundFood = true;
        // break;
        // }
        // }
        // if(!foundFood){
        // gameObjects.remove(animalIndex);
        // }
        // animalIndex++;
        // }

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
        if (animal.equals("Fisch") || animal.equals("Pflanzenfresser") || animal.equals("Nahrung")) {
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
        if (animal.equals("Nahrung")) {
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
        if (animal.equals("Nahrung")) {
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
        if (animal.equals("Fisch")) {
            return true;
        }
        return false;
    }
}

class Nahrung extends Animal {// TODO For loop fields - 1 ||
    public Nahrung() {
    }
}

