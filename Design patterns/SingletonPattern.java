class Singleton {
    
    private static Singleton instance;

    private Singleton() {
        // Private constructor
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Singleton method called");
    }
}

public class SingletonPattern {
    public static void main(String[] args) {

        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        obj1.doSomething();

        if (obj1 == obj2) {
            System.out.println("Both objects are the same instance");
        }
    }
}