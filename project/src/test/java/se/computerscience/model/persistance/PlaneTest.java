package se.computerscience.model.persistance;

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
 * @author Philip Tibom
 */
@RunWith(Arquillian.class)
public class PlaneTest {
    
    @Inject
    UserTransaction utx;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                // Add all classes
                .addPackage("se.computerscience.model.persistance")
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
    public void testPersistPlane() throws Exception {
        Plane p = new Plane("Boeing", 200, null);
        utx.begin();
        em.persist(p);
        Plane p2 = em.find(Plane.class, p.getId());
        utx.commit();
        assertTrue(p.getType().equals(p2.getType()));
    }
    
    @PersistenceContext(unitName = "travel_test_pu")
    @Produces
    @Default
    EntityManager em;
    
    private void clearAll() throws Exception {  
        utx.begin();  
        em.joinTransaction();
        em.createQuery("DELETE FROM Plane").executeUpdate();
        utx.commit();
    }


}