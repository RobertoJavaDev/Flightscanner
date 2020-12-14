package Flight.scanner.modelFX;

import Flight.scanner.database.dao.AirlineDao;
import Flight.scanner.database.dbutils.DbManager;
import Flight.scanner.database.models.Airline;
import Flight.scanner.database.models.BaseModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class AirlineModel {

    private ObservableList<AirlineFx> airlineList = FXCollections.observableArrayList();
    private ObjectProperty<AirlineFx> airline = new SimpleObjectProperty<>();

    public void init(){
        AirlineDao airlineDao = new AirlineDao(DbManager.getConnectionSource());
        List<Airline> airlines = airlineDao.queryForAll(Airline.class);
        airlines.forEach(c->{
            AirlineFx airlineFx = new AirlineFx();
            airlineFx.setId(c.getId());
            airlineFx.setAirline(c.getAirline());
            this.airlineList.add(airlineFx);

        });
        DbManager.closeConnectionSource();
    }

    public void saveAirlineInDataBase(String name){
        AirlineDao airlineDao = new AirlineDao(DbManager.getConnectionSource());
        Airline airline = new Airline();
        airline.setAirline(name);
        airlineDao.creatOrUpdate(airline);
        DbManager.closeConnectionSource();
    }

    public ObservableList<AirlineFx> getAirlineList() {
        return airlineList;
    }

    public void setAirlineList(ObservableList<AirlineFx> airlineList) {
        this.airlineList = airlineList;
    }

    public AirlineFx getAirline() {
        return airline.get();
    }

    public ObjectProperty<AirlineFx> airlineProperty() {
        return airline;
    }

    public void setAirline(AirlineFx airline) {
        this.airline.set(airline);
    }
}
