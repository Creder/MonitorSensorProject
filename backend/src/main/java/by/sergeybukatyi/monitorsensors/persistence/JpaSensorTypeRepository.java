package by.sergeybukatyi.monitorsensors.persistence;
import by.sergeybukatyi.monitorsensors.entities.SensorType;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

@Repository
public class JpaSensorTypeRepository {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public ArrayList<SensorType> getAll(){
        return (ArrayList<SensorType>) entityManagerFactory.createEntityManager().createQuery(
                "select s from SensorType s")
                .getResultList();
    }
}
