# 12. Enums

**enum** is a special type of class in java that holds group of constants. A Enum class **cannot be used to create groups or to extend another class**.

**All constants declared inside the enum class are public, static and final by default**. Values for the constants declared in the enum class starts with 0 and increments. calling **ordinal** method on the constant returns the integer value.

    enum Status {
        Loading, Failed, Success
    }

    public class Enums {
        public static void main(String[] args) {
            Status success = Status.Success;
            System.out.println(success); //Sucess
            System.out.println(success.ordinal()); //2
        }
    }

We can use enums for comparisiosn & in if-else statements and switch statements.

**if/else statements**

    Status success = Status.Success;
    if(success==Status.Success){
        System.out.println("Success Case."); // Success Case.
    }

**Switch Statement**

For Switch statements, we don't have to implicitly use Status.Success etc in switch cases. We can just refer to the enum constants (or called objects of enum class ).

    Status success = Status.Success;

    switch(success){
        case Success:
            System.out.println("Success"); //Success
            break;
        case Failed:
            System.out.println("Failed.");
            break;
        default:
            System.out.println("Loading");
            break;
    }

Because, Enum is a special type of class, each enum class can have constructor methods defined. Enum constants are objects of the enum class. We can define both normal constructor method and parametrized constructors in the enum class which we can use to initiate the enum constants/objects. Since, all enum constants are of **public, static, final** type, we cannot initiate them outside the class. So, the constructor methods should be private.

    enum Mobile {
        Pixel(800), Realme(400), Coolpad(300), Motorola();

        private int price;

        private Mobile() {
            this.price = 200;
        }

        private Mobile(int price) {
            this.price = price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    // In Main Method

    Mobile realMe = Mobile.Realme;
    realMe.setPrice(500);
    System.out.println(realMe.getPrice()); //500

Here, price is a private variable associated with each enum constant/object. We can either access those constants and set/get price variable using getter/setter methods. Or we have to initiate the enum objects inside the enum class either using default constructor method or using parametrized constructor method.

We can use **values method** on Status type to get an array of all enum constants. And in order to store them in an array we have to use **<Enum Name>[]** Syntax. And we can use enhanced for loop to iterate through the Array.

    Mobile[] mobiles = Mobile.values();
    for (Mobile mobile : mobiles) {
        System.out.println(mobile.ordinal() + "." + mobile.name() + " - $." + mobile.getPrice());
    }

**Output**

    0.Pixel - $.800
    1.Realme - $.500
    2.Coolpad - $.300
    3.Motorola - $.200
