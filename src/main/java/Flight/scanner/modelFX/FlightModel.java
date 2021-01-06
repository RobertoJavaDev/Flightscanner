package Flight.scanner.modelFX;

import Flight.scanner.database.dao.FlightDao;
import Flight.scanner.database.dbutils.DbManager;
import Flight.scanner.database.models.Airline;
import Flight.scanner.utils.converters.ConverterAirline;
import Flight.scanner.utils.exceptions.ApplicationException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class FlightModel {

//    private ObservableList<CityFx> cityList = FXCollections.observableArrayList();
//    private ObjectProperty<CityFx> city = new SimpleObjectProperty<>();
    private ObservableList<AirlineFx> airlineList = FXCollections.observableArrayList();
    private ObjectProperty<AirlineFx> airline = new SimpleObjectProperty<>();

    public void init () throws ApplicationException {
        FlightDao flightDao = new FlightDao(DbManager.getConnectionSource());
        List<Airline> airlines = flightDao.queryForAll(Airline.class);
        initAirlineList(airlines);
        DbManager.closeConnectionSource();
    }

    private void initAirlineList(List<Airline> airlines) {
        this.airlineList.clear();
        airlines.forEach(c->{
            AirlineFx airlineFx = ConverterAirline.converterToAirlineFx(c);
            this.airlineList.add(airlineFx);
        });
    }

}
