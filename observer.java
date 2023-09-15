import java.util.ArrayList;
import java.util.List;


interface Correio {
    void update();
}


class Correio {
    private List<Observer> observers = new ArrayList<>();
    private int state;


    public int getState() {
        return state;
    }


    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }


    public void attach(Observer observer) {
        observers.add(observer);
    }


    public void detach(Observer observer) {
        observers.remove(observer);
    }


    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}


class ConcreteObserver implements Observer {
    private Correio correio;


    public ConcreteObserver(Correio correio) {
        this.correio = correio;
        subject.attach(this);
    }


    public void update() {
        System.out.println("State changed to " + correio.getState());
    }
}


public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        ConcreteObserver cliente = new ConcreteObserver(correio);
        ConcreteObserver vendedor = new ConcreteObserver(correio);


        correio.setState(cliente);
        correio.setState(vendedor);
    }
}