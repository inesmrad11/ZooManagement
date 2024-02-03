public class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    public String getName() {
        return name;
    }

    /*
     En fait, .name ne fonctionne pas car l'attribut
     name de la classe Animal n'est pas directement
     accessible à l'extérieur de la classe. Pour accéder
     à cet attribut,on doit utiliser un getter, comme getName().
     */

    //instruction 9
    @Override //redef
    public String toString() {
        return ("Famille : "+family+" | Nom : "+name+" | Age : "+age+" | Type : "+isMammal);
    }
}
