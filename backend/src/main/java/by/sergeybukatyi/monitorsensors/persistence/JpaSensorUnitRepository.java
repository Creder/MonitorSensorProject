package by.sergeybukatyi.monitorsensors.persistence;

import by.sergeybukatyi.monitorsensors.entities.SensorUnit;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;

@Repository
public class JpaSensorUnitRepository {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public ArrayList<SensorUnit> getAll(){
        return (ArrayList<SensorUnit>) entityManagerFactory.createEntityManager().createQuery(
                "select s from SensorUnit s").getResultList();
    }
}
