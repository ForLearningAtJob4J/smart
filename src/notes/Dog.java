package notes;

public class Dog {

    private String name;

    public static void main(String[] args) {
        Dog myDog = new Dog("Rover");
        System.out.println("before foo: " + myDog);
        foo(myDog);
        System.out.println("after  foo: " + myDog);
    }

    public static void foo(Dog someDog) {
        someDog.setName("Max");     // AAA
        someDog = new Dog("Fifi");  // BBB
        someDog.setName("Rolf");   // CCC
    }

    public Dog(String n) {
        this.name = n;
    }

    public void setName(String n) {
        this.name = n;
    }

    @Override
    public String toString() {
        return this.name;
    }
}