package Flight.scanner.modelFX;

import Flight.scanner.database.dao.CityDao;
import Flight.scanner.database.dbutils.DbManager;
import Flight.scanner.database.models.City;
import Flight.scanner.utils.converters.ConverterCity;
import Flight.scanner.utils.exceptions.ApplicationException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.util.List;

public class CityModel {

    private ObservableList<CityFx> cityList = FXCollections.observableArrayList();
    private ObjectProperty<CityFx> city = new SimpleObjectProperty<>();
    private TreeItem<String> root = new TreeItem<>();


    public void init() throws ApplicationException {
        CityDao cityDao = new CityDao(DbManager.getConnectionSource());
        List<City> city = cityDao.queryForAll(City.class);
        initCityList(city);
        initRoot(city);
        DbManager.closeConnectionSource();
    }

    private void initRoot(List<City> city) {
        city.forEach(c->{
            TreeItem<String> cityItem = new TreeItem<>(c.getCity());
            root.getChildren().add(cityItem);
        });
    }


    private void initCityList(List<City> city) {
        this.cityList.clear();
        city.forEach(c->{
            CityFx cityFx = ConverterCity.converterToCityFx(c);
            this.cityList.add(cityFx);
        });
    }

    public void deleteCityById () throws ApplicationException {
        CityDao cityDao = new CityDao(DbManager.getConnectionSource());
        cityDao.deleteById(City.class, city.getValue().getId());
        DbManager.closeConnectionSource();
        init();
    }

    public void saveCityInDataBase(String name) throws ApplicationException {
        CityDao cityDao = new CityDao(DbManager.getConnectionSource());
        City city = new City();
        city.setCity(name);
        cityDao.creatOrUpdate(city);
        DbManager.closeConnectionSource();
        init();
    }
    public void updateCityInDatabase() throws ApplicationException {
        CityDao cityDao = new CityDao(DbManager.getConnectionSource());
        City tempCity = cityDao.findById(City.class, getCity().getId());
        tempCity.setCity(getCity().getCity());
        cityDao.creatOrUpdate(tempCity);
        DbManager.closeConnectionSource();
        init();
    }

    public ObservableList<CityFx> getCityList() {
        return cityList;
    }

    public void setCityList(ObservableList<CityFx> cityList) {
        this.cityList = cityList;
    }

    public CityFx getCity() {
        return city.get();
    }

    public ObjectProperty<CityFx> airlineProperty() {
        return city;
    }

    public void setCity(CityFx city) {
        this.city.set(city);
    }

    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }

}
