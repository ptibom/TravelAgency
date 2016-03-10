package se.computerscience.travelagency.model.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Hossein
 */
@Stateless
public class CityDAO extends GeneralDAO<City> implements ICityDAO {
    
    public CityDAO() {
        super(City.class);
    }
    
    @Override
    public List<City> searchCityByName(String cityName) {
        return (List<City>)em.createQuery("SELECT t FROM City t WHERE LOWER(t.name) LIKE LOWER(:cityName)")
                .setParameter("cityName", "%"+cityName+"%")
                .getResultList();
    }

    @Override
    public List<String> searchCityByNameToString(String cityName) {
        List<City> cityList = searchCityByName(cityName);
        List<String> result = new ArrayList<>();
        for (City city : cityList) {
            result.add(city.getName());
        }
        return result;
    }
    
    @Override
    public City cityByName(String cityName){
        return (City)em.createQuery("SELECT t FROM City t WHERE LOWER(t.name) LIKE LOWER(:cityName)")
                .setParameter("cityName", cityName)
                .getSingleResult();
    }
    
    
}
