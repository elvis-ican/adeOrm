package dev.ade.project;

import dev.ade.project.exception.ArgumentFormatException;
import dev.ade.project.orm.AdeOrm;
import dev.ade.project.orm.FieldPair;
import dev.ade.project.pojo.Post;
import dev.ade.project.pojo.User;
import dev.ade.project.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

// This class only serves for checking results during development, will be commented out or deleted at deployment.
public class App {

    public static void main (String[] args) {

        // For checking results
        try {
            String url = "jdbc:postgresql://training-db.czu9b8kfiorj.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=project-1";

            // create user orm instance
            AdeOrm uAdeOrm = new AdeOrm(User.class);

            uAdeOrm.setConnectionPool(url, 10);
            // set connection
            //uAdeOrm.setConnection(url);
            // test getAll
            System.out.println(uAdeOrm.getAll2());
            System.out.println(uAdeOrm.getAll2());
            System.out.println(uAdeOrm.getAll2());
            System.out.println(uAdeOrm.getAll2());
            System.out.println(uAdeOrm.getAll2());
            System.out.println(uAdeOrm.getAll2());
/*
            // test connection
            System.out.println(uAdeOrm.getConnection().getMetaData().getDriverName());

            // create post orm instance
            Post post = new Post();
            Class<?> postClass = post.getClass();
            AdeOrm pAdeOrm = new AdeOrm(postClass);
//            pAdeOrm.getConnection();
            pAdeOrm.setConnection(url);

            Post p = new Post(35, "beta", "Strawberry Waffles", "Italy", "Naples", "old", 2);
            Post p2 = new Post(36, "charlie", "Corned Beef Hash", "United States", "Cincinnati", "old", 3);
            User u = new User("Nicephoros","Phokas",'M',"gamma4","pass");
            User u2 = new User("Nicephoros","Phokas",'M',"gamma3","pass");

//            uAdeOrm.add(u);

            pAdeOrm.add(p);
            pAdeOrm.add(p2);

            try {
                pAdeOrm.begin();
                pAdeOrm.delete(p);
                pAdeOrm.delete(p2);
                pAdeOrm.commit();
            } catch(ArgumentFormatException | SQLException throwables){
                uAdeOrm.rollback();
                throw throwables;
            }

//            try {
//                pAdeOrm.begin();
//                pAdeOrm.update(p);
//                pAdeOrm.update(p2);
//                pAdeOrm.commit();
//            } catch(ArgumentFormatException | SQLException throwables){
//                pAdeOrm.rollback();
//                throw throwables;
//            }
/*            try{
                uAdeOrm.begin();
                uAdeOrm.add(u);
                uAdeOrm.add(u2);
                uAdeOrm.commit();

                pAdeOrm.begin();
                pAdeOrm.add(p);
                pAdeOrm.commit();
            } catch(ArgumentFormatException throwables){
                try{
                    uAdeOrm.rollback();
                    pAdeOrm.rollback();
                }catch (NullPointerException e){
                    e.printStackTrace();
                }

                throw throwables;
            } finally{
                uAdeOrm.close();
                pAdeOrm.close();
            }

//              pAdeOrm.update(p);
//            pAdeOrm.update(p);
//            System.out.println(pAdeOrm.get("title", p.getTitle()));

//            Post p1 = new Post(6, "u", "title", "country", "city", "tag", 4);
//            pAdeOrm.delete(p1);

            // test getById
            System.out.println(uAdeOrm.get("user_id",1));

            // test getAll
            System.out.println(uAdeOrm.getAll());

            // test getValue by pk
            System.out.println((String)uAdeOrm.getColumns("user_id", 1, "username").get(0));

            // test getColumnsInOrder
            List<String> columnNames = Arrays.asList("title", "country", "city", "tag", "rating");
            System.out.println(pAdeOrm.getRecordsInOrder(columnNames, "country", "United States", "rating", "desc"));

            // test getAllInOrder
            System.out.println(pAdeOrm.getAllInOrder("rating", "asc"));

            // test getWithCriterion
            FieldPair fieldPair1 = new FieldPair("rating", 5);
            FieldPair fieldPair2 = new FieldPair("city", "Miami");
            List<FieldPair> fieldPairs = Arrays.asList(fieldPair1, fieldPair2);
            List<List<Object>> result = pAdeOrm.getWithCriterion(columnNames, fieldPairs, "and");
            result.forEach(System.out::println);

            // test getJoint
            List<String> columnNames2 = Arrays.asList("username", "country", "city", "tag", "rating");
            result = uAdeOrm.getJoint("inner", "users.user_id", "post", "post.user_id",
                    columnNames2);
            result.forEach(System.out::println);

            // test getJointWhere
            result = uAdeOrm.getJointWhere("inner", "users.user_id", "post", "post.user_id",
                    columnNames2, "post.tag", "food");
            result.forEach(System.out::println);

            List<String> columnList = Arrays.asList("title", "city");
            List<String> valuesList = Arrays.asList("Chocolate Ice Cream", "Denver");
            FieldPair fielda = new FieldPair("title", "Neapolitan Ice Cream");
            FieldPair fieldb = new FieldPair("city", "Ft. Collins");
            FieldPair pk = new FieldPair("post_id", 3);

            List<FieldPair> fieldsses = Arrays.asList(fielda,fieldb);

            boolean result1 = adeOrm.update("post", fieldPairs, pk);
            System.out.println(result1);*//*


            // test transaction
//            try {
//                uAdeOrm.begin();
//                uAdeOrm.update2("first_name", "user_id", 1, "Ginny");
//                uAdeOrm.update2("last_name", "user_id", 1, "Weasley");

//                uAdeOrm.commit();
//            } catch (Exception e) {
//                uAdeOrm.rollback();
//            } finally {
//                uAdeOrm.close();
//            }
//            System.out.println(uAdeOrm.get("user_id", 1));
//
//            try {

//                uAdeOrm.open();
//                uAdeOrm.update2("first_name", "user_id", 1, "Leah");
//                uAdeOrm.update2("last_name", "user_id", 10, "Canavan");
//                uAdeOrm.commit();
//            } catch (Exception e) {

//                uAdeOrm.rollback();
//            } finally {
//                uAdeOrm.close();
//            }
//            System.out.println(uAdeOrm.get("user_id", 1));
//
//            //User hermione = new User(0, "Hermione", "Granger", 'F', "her", "iamtalented");
//            //uAdeOrm.add(hermione);
//            System.out.println(uAdeOrm.getColumns("username", "her", "first_name", "last_name"));
//
//            //User ron = new User(0, "Ron", "Weasley", 'M', "ron", "password123");
//            //uAdeOrm.add(ron);
//            System.out.println(uAdeOrm.getColumns("username", "ron", "first_name", "last_name"));
//
//            //User harry = new User(0, "Harry", "Porter", 'M', "harry", "password123");
//            //uAdeOrm.add(harry);
//            System.out.println(uAdeOrm.getColumns("username", "harry", "first_name", "last_name"));
*/
        FieldPair fplastName = new FieldPair("last_name", "Weasley");
        FieldPair fpGender = new FieldPair("gender", "M");
        List<FieldPair> fieldPairs = Arrays.asList(fplastName);
        //System.out.println(uAdeOrm.getWithCriterion(fieldPairs, "no"));

        } catch (ArgumentFormatException e) {
            e.printStackTrace();
        }
    }

}
