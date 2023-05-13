# 13. Functional Interface

## Annotations

Annotations are added to our program/code to provide additional information about our code to the compiler / runtime. Annotations are started with **@**.

There are many standard/builtin annotations available in java. And, also we can define custon annotations as well.

### Override Annotation

When a class extends a parent class, and if we want to override a method in the parent class then adding **@Override** annotation helps compiler to identify if the parent method is overrided. if it isn't overrided, compiler will throw an error.

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

        //if there's no call method and there's calls() method here,
        //compiler will throw an error saying that
        // there should be method which overrides super class method.
    }

### @Deprecated

There are other Annotations like **@Deprecated**. Classes marked with Deprecated Annotation will be identified as Deprecated and compiler throws a warning when the code is compiled. Linters will notice and throws an lint error.

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
    }

    class Annotation {
        public static void main(String[] args) {
            Mobile mob = new Mobile();
            mob.call();
        }
    }

**to use linter while compiling the code, use javac <filename> -Xlint**. Compiling the above code with a linter will throw lint warnings.

**Output**

    PS C:\projects\JavaPractise> javac .\Annotation.java -Xlint
    .\Annotation.java:8: warning: [deprecation] Mobile in unnamed package has been deprecated
    class Cellphone extends Mobile {
                            ^
    .\Annotation.java:27: warning: [deprecation] Mobile in unnamed package has been deprecated
            Mobile mob = new Mobile();
            ^
    .\Annotation.java:27: warning: [deprecation] Mobile in unnamed package has been deprecated
            Mobile mob = new Mobile();
                             ^
    3 warnings

### @FunctionalInterface

We can add **@FunctionalInterface** to an interface if we want it to have only one method declared in it. Trying to declare multiple methods will result in an runtime error.

    @FunctionalInterface
    interface Cell{
        void call();
        void call2();
    }

Above code throws a runtime error.

## Lambda Expressions

Lambda Expressions can be only used with **Functional Interfaces**. When a functional interface is defined, we need to define the abstract method declared inside the functional interface either in a class which implements the interface. Or we can use Anonymous Inner classes to define the abstract method as follows.

    @FunctionalInterface
    interface Cell {
        void call();
    }

    class Annotation {
        public static void main(String[] args) {
            Cell c = new Cell() {
                public void call() {
                    System.out.println("Inner Class -> Calling.");
                }
            };

            c.call(); // Inner Class -> Calling.

        }
    }

We can shorten this code using lambda empressions. As we are creating an Object of type Cell and the compiler know Cell is a functional Interface, instead of defining a public method in the anonymous inner class, we can eliminate this code and use lambda expression as follows.

    Cell c = () -> {
        System.out.println("Inner Class calling");
    };

If there's only one statement in the method we can eliminate { } too and write the statement in the same line as follows.

    Cell c = () -> System.out.println("Inner Class calling");

If the method we need to implement returns anything and takes arguments, then we can still use lambda expressions. In the Lambda expression, we don't have to specify the parameters data types explicitly.

    @FunctionalInterface
    interface Cell2 {
        int add(int a, int b);
    }


    class Annotation {
        public static void main(String[] args) {

            Cell2 c2 = (a, b) -> {
                return a + b;
            };
            int res = c2.add(1, 2);
            System.out.println(res); //3

        }
    }

Simillarly, we can eliminate { } if there's only one statement. Alos we can directly return the result without including **return** keyword.

    Cell2 c2 = (a,b) -> a+b;
    int res = c2.add(1, 2);
    System.out.println(res); //3

:bangbang: Lambda Expressions are very simillar to **Arrow Functions in Javascript**.
