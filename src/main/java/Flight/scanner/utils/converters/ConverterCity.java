package Flight.scanner.utils.converters;

import Flight.scanner.database.models.City;
import Flight.scanner.modelFX.CityFx;

public class ConverterCity {

    public static CityFx converterToCityFx (City city){
        CityFx cityFx = new CityFx();
        cityFx.setId(city.getId());
        cityFx.setCity(city.getCity());
        return cityFx;
    }
}
