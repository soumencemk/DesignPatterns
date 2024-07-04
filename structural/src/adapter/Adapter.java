package adapter;


interface Charger {
    public void charge();
}


//Target interface
interface IPhone {
    void charge();
}

public class Adapter {
    public static void main(String[] args) {
        IPhone6s iphone6s = new IPhone6s(new IPhone4sTo6sCharger());
        iphone6s.charge();
    }

}

//Adaptee class
class IPhone4sCharger implements Charger {

    @Override
    public void charge() {
        System.out.println("Charging with 4S Charger");
    }
}

class IPhone4sTo6sCharger implements Charger {
    IPhone4sCharger iPhone4sCharger;

    public IPhone4sTo6sCharger() {
        iPhone4sCharger = new IPhone4sCharger();
    }

    @Override
    public void charge() {
        iPhone4sCharger.charge();
    }
}

class IPhone6s implements IPhone {

    Charger iPhone4sTo6sAdapter;

    public IPhone6s(Charger iphone4sTo6sAdapter) {
        this.iPhone4sTo6sAdapter = iphone4sTo6sAdapter;
    }

    @Override
    public void charge() {
        iPhone4sTo6sAdapter.charge();
    }
}
