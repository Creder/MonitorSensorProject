package by.sergeybukatyi.monitorsensors.persistence;
import by.sergeybukatyi.monitorsensors.entities.Sensor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaSensorRepository {

  @PersistenceUnit
  private EntityManagerFactory entityManagerFactory;



  public ArrayList<Sensor> getAll() {
    return (ArrayList<Sensor>) entityManagerFactory.createEntityManager().createQuery(
        "select s from Sensor s join fetch s.type st join fetch s.unit su")
        .getResultList();
  }

  public Sensor getOne(Long id) {
      return entityManagerFactory.createEntityManager().find(Sensor.class, id);
  }


  public boolean saveOrUpdate(Sensor sensor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        if(sensor.getId() == null){
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(sensor);
                entityManager.getTransaction().commit();
                return true;
            }catch (PersistenceException e){
                return false;
            }
        }
        else{
            try {
                entityManager.getTransaction().begin();
                entityManager.merge(sensor);
                entityManager.getTransaction().commit();
                return true;
            }catch (PersistenceException e) {
                return false;
            }
        }
  }
  public boolean delete(Long id){
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      Sensor sensor = entityManager.find(Sensor.class, id);
      if( sensor != null) {
          try {
              entityManager.getTransaction().begin();
              entityManager.remove(sensor);
              entityManager.getTransaction().commit();
              return true;
          } catch (PersistenceException e) {
              return false;
          }
      }
      else return false;
  }

}
