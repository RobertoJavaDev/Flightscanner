package Flight.scanner.modelFX;

import Flight.scanner.database.dao.AirlineDao;
import Flight.scanner.database.dbutils.DbManager;
import Flight.scanner.database.models.Airline;
import Flight.scanner.database.models.BaseModel;
import Flight.scanner.utils.exceptions.ApplicationException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class AirlineModel {

    private ObservableList<AirlineFx> airlineList = FXCollections.observableArrayList();
    private ObjectProperty<AirlineFx> airline = new SimpleObjectProperty<>();

    public void init() throws ApplicationException {
        AirlineDao airlineDao = new AirlineDao(DbManager.getConnectionSource());
        List<Airline> airlines = airlineDao.queryForAll(Airline.class);
        this.airlineList.clear();
        airlines.forEach(c->{
            AirlineFx airlineFx = new AirlineFx();
            airlineFx.setId(c.getId());
            airlineFx.setAirline(c.getAirline());
            this.airlineList.add(airlineFx);

        });
        DbManager.closeConnectionSource();
    }

    public void deleteAirlineById () throws ApplicationException {
        AirlineDao airlineDao = new AirlineDao(DbManager.getConnectionSource());
        airlineDao.deleteById(Airline.class, airline.getValue().getId());
        DbManager.closeConnectionSource();
        init();
    }

    public void saveAirlineInDataBase(String name) throws ApplicationException {
        AirlineDao airlineDao = new AirlineDao(DbManager.getConnectionSource());
        Airline airline = new Airline();
        airline.setAirline(name);
        airlineDao.creatOrUpdate(airline);
        DbManager.closeConnectionSource();
        init();
    }
    public void updateAirlineInDatabase() throws ApplicationException {
        AirlineDao airlineDao = new AirlineDao(DbManager.getConnectionSource());
        Airline tempAirline = airlineDao.findById(Airline.class, getAirline().getId());
        tempAirline.setAirline(getAirline().getAirline());
        airlineDao.creatOrUpdate(tempAirline);
        DbManager.closeConnectionSource();
        init();
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
