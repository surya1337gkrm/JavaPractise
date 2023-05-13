@Deprecated
class Mobile {
    public void call() {
        System.out.println("Calling.");
    }
}

class Cellphone extends Mobile {
    @Override
    public void call() {
        System.out.println("Override: Calling.");
    }

    // if there's no call method and there's calls() method here, compiler will
    // throw an error saying that
    // there should be method which overrides super class method.
}

@FunctionalInterface
interface Cell {
    void call();
    // void call2();
}

@FunctionalInterface
interface Cell2 {
    int add(int a, int b);
}

class Annotation {
    public static void main(String[] args) {
        Mobile mob = new Mobile();
        mob.call();

        // Cell c = new Cell() {
        // public void call() {
        // System.out.println("Inner Class -> Calling.");
        // }
        // };

        // Cell c = () -> {
        // System.out.println("Inner Class calling");
        // };

        Cell c = () -> System.out.println("Inner Class calling");

        c.call();

        // Cell2 c2 = (a, b) -> {
        //     return a + b;
        // };

        Cell2 c2 = (a,b) -> a+b; 
        
        int res = c2.add(1, 2);
        System.out.println(res);

    }
}