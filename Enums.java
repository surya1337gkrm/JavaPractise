enum Status {
    Loading, Failed, Success
}

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

public class Enums {
    public static void main(String[] args) {
        Status success = Status.Success;
        System.out.println(success.ordinal());

        if (success == Status.Success) {
            System.out.println("Success Case.");
        }

        switch (success) {
            case Success:
                System.out.println("Success");
                break;
            case Failed:
                System.out.println("Failed.");
                break;
            default:
                System.out.println("Loading");
                break;
        }

        Mobile realMe = Mobile.Realme;
        realMe.setPrice(500);
        System.out.println(realMe.getPrice());

        Mobile[] mobiles = Mobile.values();
        for (Mobile mobile : mobiles) {
            System.out.println(mobile.ordinal() + "." + mobile.name() + " - $." + mobile.getPrice());
        }
    }
}
