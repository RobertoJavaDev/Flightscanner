package Flight.scanner.modelFX;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FlightFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty departure = new SimpleStringProperty();
    private StringProperty arrival = new SimpleStringProperty();
    private IntegerProperty price = new SimpleIntegerProperty();
    private StringProperty airline = new SimpleStringProperty();
    private StringProperty date = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getDeparture() {
        return departure.get();
    }

    public StringProperty departureProperty() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure.set(departure);
    }

    public String getArrival() {
        return arrival.get();
    }

    public StringProperty arrivalProperty() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival.set(arrival);
    }

    public int getPrice() {
        return price.get();
    }

    public IntegerProperty priceProperty() {
        return price;
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public String getAirline() {
        return airline.get();
    }

    public StringProperty airlineProperty() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline.set(airline);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

}
