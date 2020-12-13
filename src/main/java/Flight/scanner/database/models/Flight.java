package Flight.scanner.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Date;

@DatabaseTable(tableName = "Flight")
public class Flight implements BaseModel{

        public static final String DEPARTURE_ID = "DEPARTURE_ID";
        public static final String ARRIVAL_ID = "ARRIVAL_ID";

        public Flight() {
        }

        @DatabaseField(generatedId = true)
        private int id;

        @DatabaseField(columnName = DEPARTURE_ID, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
        private City departure;
        @DatabaseField(columnName = ARRIVAL_ID, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
        private City arrival;

        @DatabaseField(columnName = "PRICE", canBeNull = false)
        private int price;

        @DatabaseField(columnName = "AIRLINE")
        private String airline;

        @DatabaseField(columnName = "DATE")
        private Date releaseDate;

        @DatabaseField(columnName = "ADDED_DATE")
        private Date addedDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public City getDeparture() {
            return departure;
        }

        public void setDeparture(City departure) {
            this.departure = departure;
        }

        public City getArrival() {
            return arrival;
        }

        public void setArrival(City arrival) {
            this.arrival = arrival;
        }

        public String getAirline() {
            return airline;
        }

        public void setAirline(String airline) {
            this.airline = airline;
        }

        public Date getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(Date releaseDate) {
            this.releaseDate = releaseDate;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Date getAddedDate() {
            return addedDate;
        }

        public void setAddedDate(Date addedDate) {
            this.addedDate = addedDate;
        }


}
