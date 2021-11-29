package ru.job4j.tracker;

import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in =
                     SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("ein");
        tracker.add(item);
        int id = item.getId();
        Item itemTwo = new Item("zwei");
        assertTrue(tracker.replace(id, itemTwo));
        assertThat(tracker.findById(id).getName(), is("zwei"));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item oneItem = new Item("tram");
        tracker.add(oneItem);
        int id = oneItem.getId();
        assertTrue(tracker.delete(id));
        assertThat(tracker.findById(id), is(IsNull.nullValue()));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item one = new Item("first");
        Item two = new Item("second");
        Item three = new Item("third");
        tracker.add(one);
        tracker.add(two);
        tracker.add(three);
        List<Item> result = tracker.findAll();
        List<Item> resultik = List.of(one, two, three);
        assertThat(result, is(resultik));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        tracker.add(new Item("first"));
        tracker.add(new Item("second"));
        tracker.add(new Item("third"));
        List<Item> result = tracker.findByName("second");
        Iterator<Item> iter = result.iterator();
        assertThat(iter.next().getName(), is("second"));
        assertFalse(iter.hasNext());
    }
}