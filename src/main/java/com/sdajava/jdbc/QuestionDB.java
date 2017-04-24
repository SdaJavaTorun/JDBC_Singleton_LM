package com.sdajava.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by RENT on 2017-04-24.
 */
public class QuestionDB {
    private ConnectDB connectDB;

    public void getQuestion() {

        Statement statement = connectDB.INSTANCE.getConnection();

        try {
            ResultSet resultSet = statement.executeQuery("select * from books");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("title") +
                        " " + resultSet.getString("author") +
                        " " + resultSet.getInt("page_count") +
                        " " + resultSet.getString("category") +
                        " " + resultSet.getString("isbn") +
                        " " + resultSet.getString("price"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
