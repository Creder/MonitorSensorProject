package by.sergeybukatyi.monitorsensors.persistence;

import by.sergeybukatyi.monitorsensors.entities.Explorer;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Repository
public class JpaUserRepository {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public Explorer findUser(String username) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Explorer explorer = (Explorer) entityManager.createQuery("SELECT u FROM Explorer u where u.username = :username")
                .setParameter("username", username).getSingleResult();
        return explorer;
    }
}
