package Flight.scanner.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName = "AIRLINE")
public class Airline {

    public Airline() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "AIRLINE", canBeNull = false)
    private String airline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

}
