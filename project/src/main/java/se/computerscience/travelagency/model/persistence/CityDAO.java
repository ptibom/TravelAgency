package se.computerscience.travelagency.model.persistence;

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
        return (List<City>)em.createQuery("SELECT t FROM City t WHERE t.name LIKE :cityName")
                .setParameter("cityName", "%"+cityName+"%")
                .getResultList();
    }

    
    
    
}
