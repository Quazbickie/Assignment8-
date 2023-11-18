public class Dog extends Animal{

    private String name;
    private String breed;
    private int size;

    public Dog(){
        super();
    }

    public Dog(String name, String breed, int size){
        super(name, breed, size);
    }

    public String sound(){
        return "rUfF";
    }


}
