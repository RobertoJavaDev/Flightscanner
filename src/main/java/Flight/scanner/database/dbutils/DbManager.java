package Flight.scanner.database.dbutils;

import Flight.scanner.database.models.Airline;
import Flight.scanner.database.models.City;
import Flight.scanner.database.models.Flight;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DbManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    private static final String JDBC_DRIVER_HD = "jdbc:sqlite:./flightDB";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    private static ConnectionSource connectionSource;

    public static void initDatabase(){
        createConnectionSource();
        dropTable();
        createTable();
        closeConnectionSource();
    }

    private static void createConnectionSource(){
        try {
            connectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD,USER, PASS);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource == null){
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSource(){
        if(connectionSource!=null){
            try {
                connectionSource.close();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private static void createTable(){
        try {
            TableUtils.createTableIfNotExists(connectionSource, City.class);
            TableUtils.createTableIfNotExists(connectionSource, Flight.class);
            TableUtils.createTableIfNotExists(connectionSource, Airline.class);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private  static  void  dropTable(){
        try {
            TableUtils.dropTable(connectionSource, Airline.class, true);
            TableUtils.dropTable(connectionSource, City.class, true);
            TableUtils.dropTable(connectionSource, Flight.class, true);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

}
