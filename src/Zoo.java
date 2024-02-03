public class Zoo {
    Animal[] animals;
    String name;
    String city;
    int nbrCages;
    int animalCount;

    public Zoo(String name, String city, int nbrCages) {
        animals = new Animal[nbrCages];
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        this.animalCount = 0;
    }

    //instruction 8
    public void displayZoo() {
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of cages: " + nbrCages);
    }

    //instruction 9
    @Override
    public String toString() {
        return ("Nom du zoo : " + name + "\nVille : " + city + "\nNombre de cages : " + nbrCages);
    }

    //instruction 10
    /*
    public boolean addAnimal(Animal animal) {

        if (animalCount < nbrCages) {
            animals[animalCount++] = animal;
            return true;
        } else {
            System.out.println("Le zoo est plein, impossible d'ajouter plus d'animaux.");
            return false;
        }
    }
    */

    //instruction 11
    public void displayAnimals() {
        System.out.println("- Animaux dans le zoo " + name + ":");
        for (int i = 0; i < animalCount; i++) {
            System.out.println((i + 1) + ". " + animals[i].toString());
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    //instruction 12
    public boolean addAnimal(Animal animal) {
        if (animalCount == nbrCages) {
            return false;
        }

        if (searchAnimal(animal) != -1) {
            return false;
        }

        animals[animalCount++] = animal;
        return true;
    }

    //instruction 13
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index != -1) {
            for (int i = index; i < animalCount - 1; i++) {
                animals[i] = animals[i + 1];
            }
            animals[animalCount - 1] = null;
            animalCount--;
            return true;
        } else {
            return false;
        }
    }
}