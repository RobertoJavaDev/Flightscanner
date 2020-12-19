package Flight.scanner.utils.converters;

import Flight.scanner.database.models.Airline;
import Flight.scanner.modelFX.AirlineFx;

public class ConverterAirline {

    public static AirlineFx converterToAirlineFx (Airline airline){
        AirlineFx airlineFx = new AirlineFx();
        airlineFx.setId(airline.getId());
        airlineFx.setAirline(airline.getAirline());
        return airlineFx;
    }
}
