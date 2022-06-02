package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();

        session.save(item);

        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();

        session.createQuery(
                        "update Item i "
                                + "set i.name = :name, i.created = :created, i.description = :desc "
                                + "where i.id = :fId")
                .setParameter("name", item.getName())
                .setParameter("desc", item.getDescription())
                .setParameter("created", item.getCreated())
                .setParameter("fId", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();

        session.createQuery("delete from Item i where i.id = :fId")
                .setParameter("fId", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Item");
        List<Item> result = new ArrayList<>();
        for (Object it : query.getResultList()) {
            result.add((Item) it);
        }

        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();

        Item rsl = (Item) session.createQuery("from Item i where i.name = :name")
                .setParameter("name", key)
                .getSingleResult();
        List<Item> result = new ArrayList<>();
        result.add(rsl);

        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item rsl = (Item) session.createQuery("from Item i where i.id = :fId")
                .setParameter("fId", id)
                .getSingleResult();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);

    }
}
