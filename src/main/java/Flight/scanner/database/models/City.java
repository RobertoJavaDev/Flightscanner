package Flight.scanner.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName = "CITY")
public class City implements BaseModel{

    public City() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField (columnName = "CITY", canBeNull = false)
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
