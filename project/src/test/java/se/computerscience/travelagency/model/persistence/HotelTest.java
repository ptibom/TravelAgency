package se.computerscience.travelagency.model.persistence;

import javax.ejb.EJB;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Hossein
 */
@RunWith(Arquillian.class)
public class HotelTest {
    
    @Inject
    UserTransaction utx;

    @EJB
    private IHotelDAO hotelDAO;
    
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                // Add all classes
                .addPackage("se.computerscience.travelagency.model.persistence")
                // This will add test-persitence.xml as persistence.xml (renamed)
                // in folder META-INF, see Files > jpa_managing > target > arquillian
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                // Must have for CDI to work
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    }
    
    @Before  // Run before each test
    public void before() throws Exception {
        clearAll();
    }

    @Test
    public void testPersistHotel() throws Exception {
        Hotel c = new Hotel();
        c.setName("hotelName");
        c.setCity(null);
        c.setDecsription("");
        c.setNumberOfRooms(0);
        c.setPrice(0);
        c.setRating(0);
        utx.begin();
        hotelDAO.create(c);
        Hotel c2 = hotelDAO.findById(c.getId());
        utx.commit();
        assertTrue(c.getName().equals(c2.getName()));
    }
    
    @Test
    public void testUpdateHotel() throws Exception {
        Hotel c = new Hotel();
        c.setName("hotelName");
        c.setCity(null);
        c.setDecsription("");
        c.setNumberOfRooms(0);
        c.setPrice(0);
        c.setRating(0);
        utx.begin();
        hotelDAO.create(c);
        String name = "newName";
        c.setName(name);
        hotelDAO.update(c);
        utx.commit();
        assertTrue(c.getName().equals(name));
    }
    
    @PersistenceContext(unitName = "travel_test_pu")
    @Produces
    @Default
    EntityManager em;
    
    private void clearAll() throws Exception {  
        utx.begin();  
        em.joinTransaction();
        em.createQuery("DELETE FROM Hotel").executeUpdate();
        utx.commit();
    }


}