package dev.ade.project.orm;

import dev.ade.project.exception.ArgumentFormatException;
import dev.ade.project.pojo.Post;
import dev.ade.project.pojo.User;
import dev.ade.project.util.ConnectionUtil;
import org.h2.tools.RunScript;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdeOrmTest {
/*    private AdeOrm adeOrm = new AdeOrm();

    User user = new User();
    Class<?> userClass = user.getClass();
    AdeOrm uAdeOrm = new AdeOrm(userClass);

    Post post = new Post();
    Class<?> postClass = post.getClass();
    AdeOrm pAdeOrm = new AdeOrm(postClass);
/*
    @BeforeAll
    public static void runSetup() throws SQLException, FileNotFoundException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            RunScript.execute(connection, new FileReader("setup.sql"));
        }
    }

    /*@Test
    public void getTestPrimaryKey() throws ArgumentFormatException {
        User user = (User) uAdeOrm.get( "username", "alpha");
        assertEquals("alpha", user.getUsername());
    }

    @Test
    public void getTestNull() throws ArgumentFormatException {
        assertNull(uAdeOrm.get( "user_id",  null));
    }

    @Test
    public void getTestNotPrimaryKey() throws ArgumentFormatException {
        assertNull(uAdeOrm.get( "first",  null));
    }


    @Test
    public void getColumnsTest() throws ArgumentFormatException {
        assertEquals("alpha", uAdeOrm.getColumns("username", "alpha", "username").get(0));
    }

    @Test
    public void getRecordsInOrderTestSort() throws ArgumentFormatException {
        List<String> columnNames = Arrays.asList("city");
        assertEquals("New Orleans", pAdeOrm.getRecordsInOrder(columnNames, "country",
                "United States", "rating","asc").get(0).get(0));
    }

    @Test
    public void getAllTestNumber() throws ArgumentFormatException {
        assertEquals(4, uAdeOrm.getAll().size());
    }

    @Test
    public void getAllInOrderTestOrder() throws ArgumentFormatException {
        User user = (User) uAdeOrm.getAllInOrder("username", "desc").get(0);
        assertEquals("charlie",user.getUsername());
    }

    @Test
    public void getWithCriterionTest() throws ArgumentFormatException {
        FieldPair condition1 = new FieldPair("username", "beta");
        FieldPair condition2 = new FieldPair("rating", 5);
        List<FieldPair> conditions = Arrays.asList(condition1, condition2);
        assertEquals(1, pAdeOrm.getWithCriterion(conditions, "and").size());
    }

    @Test
    public void getRecordsWithOrTest() throws ArgumentFormatException {
        FieldPair condition1 = new FieldPair("username", "alpha");
        FieldPair condition2 = new FieldPair("rating", 5);
        List<FieldPair> conditions = Arrays.asList(condition1, condition2);
        assertEquals(2, pAdeOrm.getWithCriterion(conditions, "or").size());
    }

    @Test
    public void getJointTest() throws ArgumentFormatException {
        List<String> columnNames = Arrays.asList("country", "city", "rating");
        assertEquals(3,  uAdeOrm.getJoint("inner", "users.username", "post", "post.username",
                columnNames).size());
    }

    @Test
    public void getJointWhereTest() throws ArgumentFormatException {
        List<String> columnNames = Arrays.asList("country", "city", "rating");
        assertEquals(0,  uAdeOrm.getJointWhere("inner", "users.username", "post", "post.username",
                columnNames, "tag", "food").size());
    }

    @Test
    public void addUserObjectTest() throws ArgumentFormatException, SQLException {

        User user1 = new User
                ("Tyler","Kelly",'M',"hardstuckwarrior","password123");
        AdeOrm userAdeOrm = new AdeOrm(User.class);

        assertTrue(userAdeOrm.add(user1));
    }


    @Test
    public void testUpdateSingleAttribute() throws ArgumentFormatException {
        FieldPair field1 = new FieldPair("title", "Neapolitan Ice Cream");
        FieldPair field2 = new FieldPair("city", "Ft. Collins");
        FieldPair pk = new FieldPair("post_id", 3);
        List<FieldPair> fields = Arrays.asList(field1, field2);
        assertTrue(pAdeOrm.update(fields,pk));
    }

    @Test
    public void testUpdateMultipleAttributes() throws ArgumentFormatException {
        FieldPair field = new FieldPair("city", "Ft. Collins");
        FieldPair pk = new FieldPair("post_id", 3);
        List<FieldPair> fields = Arrays.asList(field);
        assertTrue(pAdeOrm.update(fields, pk));
    }

    @Test
    public void testUpdateWithObject() throws ArgumentFormatException {
        Post post = new Post(2, "beta", "Inception", "United States", "Gary", "good movie", 4);
        assertTrue(pAdeOrm.update(post));
    }

    @Test
    public void testUpdateWithObjectNotInDB() throws ArgumentFormatException {
        Post post = new Post(13, "3", "Inception", "United States", "Gary", "good movie", 4);
        assertFalse(pAdeOrm.update(post));
    }

    @Test
    public void testDeleteARecord() throws ArgumentFormatException {
        assertTrue(pAdeOrm.delete("post_id", 2));
    }

    @Test
    public void testDeleteARecordNotInDB() throws ArgumentFormatException {
        assertFalse(pAdeOrm.delete("post_id", 13));
    }

    @Test
    public void testDeleteARecordViaObject() throws ArgumentFormatException, SQLException {
        Post post = new Post(3, "charlie", "Inception", "United States", "Chicago", "movie", 3);
        assertTrue(pAdeOrm.delete(post));
    }

    @Test
    public void testDeleteARecordNotInDBViaObject() throws ArgumentFormatException, SQLException {
        Post post = new Post(20, "fox", "something", "United States", "Chicago", "nope", 5);
        assertFalse(pAdeOrm.delete(post));

    }
*/
    /*@AfterAll
    public static void runTeardown() throws SQLException, FileNotFoundException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            RunScript.execute(connection, new FileReader("teardown.sql"));
        }
    }*/


}

