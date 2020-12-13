package Flight.scanner.modelFX;

import Flight.scanner.database.dao.AirlineDao;
import Flight.scanner.database.dbutils.DbManager;
import Flight.scanner.database.models.Airline;
import Flight.scanner.database.models.BaseModel;

public class AirlineModel {

    public void saveAirlineInDataBase(String name){
        AirlineDao airlineDao = new AirlineDao(DbManager.getConnectionSource());
        Airline airline = new Airline();
        airline.setAirline(name);
        airlineDao.creatOrUpdate((BaseModel) airline);
        DbManager.closeConnectionSource();
    }
}
