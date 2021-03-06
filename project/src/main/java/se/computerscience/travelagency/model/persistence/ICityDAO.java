package se.computerscience.travelagency.model.persistence;

import java.util.List;

/**
 *
 * @author Hossein
 */
public interface ICityDAO extends IDAO<City> {
    public List<City> searchCityByName(String cityName);
    public List<String> searchCityByNameToString(String cityName);
    public City cityByName(String cityName);
}
