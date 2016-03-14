package se.computerscience.travelagency.model.persistence;

import javax.ejb.Stateless;

/**
 *
 * @author Hossein
 */
@Stateless
public class PlaneDAO extends GeneralDAO<Plane> implements IPlaneDAO{
    public PlaneDAO() {
        super(Plane.class);
    }
}
