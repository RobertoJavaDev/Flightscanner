package Flight.scanner.database.dao;

import com.j256.ormlite.support.ConnectionSource;

public class FlightDao extends CommonDao {
    public FlightDao(ConnectionSource connectionSource) {
        super(connectionSource);
    }
}
