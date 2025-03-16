package domain.events;

public class IncomeClickEvent extends DefaultEventImpl<IncomeClickEvent> {

    public IncomeClickEvent(){
        super();
    }

    public void click() { notifyObservers(); }

}
