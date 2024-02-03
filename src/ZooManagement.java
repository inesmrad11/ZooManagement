import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        //instruction 1
        int nbrCages = 20;
        String zooName = "my zoo";
        //System.out.println(zooName + " comporte " + nbrCages + " cages.");

        //instruction 2
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Veuillez entrer le nombre de cages (maximum 25) : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Veuillez entrer un nombre entier pour le nombre de cages : ");
                scanner.next();
            }
            nbrCages = scanner.nextInt();
        } while (nbrCages > 25 || nbrCages <= 0);
        scanner.nextLine();
        System.out.println("Veuillez entrer le nom du zoo : ");
        zooName = scanner.nextLine();
        scanner.close();

        //insctruction 3
        System.out.println(zooName + " comporte " + nbrCages + " cages.");


        //instruction 5
        // Création d'un animal (un lion)
        /*
        Animal lion = new Animal();
        lion.family = "félin";
        lion.name = "Lion";
        lion.age = 10;
        lion.isMammal = true;

        // Création du zoo (myZoo)
        Zoo myZoo = new Zoo();
        myZoo.name = "MyZoo";
        myZoo.city = "Tunis";
        myZoo.nbrCages = 3;
         */

        //instruction 6
        /*
        Avec l'utilisation des constructeurs paramétrés,
         l'initialisation des attributs des objets Animal et Zoo
         se fait en une seule ligne ce qui rend le code plus concis
         et plus lisible.
         */

        //instruction 7
        Zoo myZoo = new Zoo(zooName, "Tunis", nbrCages);
        Animal lion = new Animal("félin", "Lion", 10, true);
        Animal kangaroo = new Animal("Kangourou", "Kangou", 2, true);
        Animal snake = new Animal("Serpent", "Python", 3, false);

        //instruction 8
        //System.out.println("* Afficher le Zoo :");
        //la méthode displayZoo()
        //myZoo.displayZoo();

        //System.out.println(myZoo);
        //System.out.println(myZoo.toString());

        //Que remarquez-vous ?
        /*Je remarque que System.out.println(myZoo)
         et System.out.println(myZoo.toString()) n'affichent
         pas les informations du zoo comme prévu.
         Au lieu de cela, ils renvoient
         l'adresse mémoire de l'objet myZoo. */

        //instruction 10
        // Ajouter des animaux au zoo
        boolean resultat1 = myZoo.addAnimal(lion);
        boolean resultat2 = myZoo.addAnimal(kangaroo);
        boolean resultat3 = myZoo.addAnimal(snake);

        // Ajouter plus d'animaux que d'espaces disponibles
        boolean resultat4 = myZoo.addAnimal(new Animal("Oiseau", "Perroquet", 5, true));
        boolean resultat5 = myZoo.addAnimal(new Animal("Poisson", "Poisson rouge", 2, false));

        // Afficher les résultats
        System.out.println("\n * Résultats de l'ajout :");
        System.out.println("Résultat de l'ajout du lion : " + resultat1);
        System.out.println("Résultat de l'ajout du kangourou : " + resultat2);
        System.out.println("Résultat de l'ajout du serpent : " + resultat3);
        System.out.println("Résultat de l'ajout du perroquet : " + resultat4);
        System.out.println("Résultat de l'ajout du poisson rouge : " + resultat5);

        /*
        lorsqu'on dépasse la capacité le résultat
        d'ajout est false
        (on n'a pas pu ajouter ces autres animaux)
         */

        //instruction 11
        System.out.println("\n ** AFFICHER **");
        System.out.println(myZoo);
        // Affichage des animaux dans le zoo
        myZoo.displayAnimals();

        //instruction 12
        System.out.println("\n ** RECHERCHE **");
        int index1 = myZoo.searchAnimal(lion);
        if (index1 != -1) {
            System.out.println("L'animal " + lion.getName() + " est présent dans le zoo dans la cage numéro : " + (index1 + 1));
        } else {
            System.out.println("L'animal " + lion.getName() + " n'est pas présent dans le zoo.");
        }

        Animal lion2 = new Animal("félin", "Lion", 10, true);
        int index2 = myZoo.searchAnimal(lion2);
        if (index2 != -1) {
            System.out.println("L'animal " + lion2.getName() + " est présent dans le zoo dans la cage numéro : " + (index2 + 1) );
        } else {
            System.out.println("L'animal " + lion2.getName() + " n'est pas présent dans le zoo.");
        }

        int index3 = myZoo.searchAnimal(kangaroo);
        if (index3 != -1) {
            System.out.println("L'animal " + kangaroo.getName() + " est présent dans le zoo dans la cage numéro : " + (index3 + 1));
        } else {
            System.out.println("L'animal " + kangaroo.getName() + " n'est pas présent dans le zoo.");
        }


        /*
        Lorsque nous créons un autre animal identique au premier et essayons de le rechercher
        dans le zoo, nous remarquons que la méthode searchAnimal() retourne toujours l'indice
        du premier animal trouvé dans le zoo, même s'il existe plusieurs animaux identiques.
        Cela est dû à la façon dont la méthode de recherche est implémentée : elle recherche
        l'animal en comparant ses attributs avec ceux de chaque animal dans le zoo et retourne
        l'indice du premier animal trouvé correspondant.
         */

        // Supprimer un animal du zoo
        System.out.println("\n ** SUPPRIMER **");
        boolean removed = myZoo.removeAnimal(snake);
        if (removed) {
            System.out.println("L'animal "+snake.getName()+" a été supprimé avec succès !");
        } else {
            System.out.println("L'animal "+snake.getName()+" n'a pas été trouvé dans le zoo ou n'a pas pu être supprimé.");
        }
    }
}
