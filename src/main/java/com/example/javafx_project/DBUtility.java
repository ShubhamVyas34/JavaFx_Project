package com.example.javafx_project;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user=DBCreds.getUser();
    private static String pass=DBCreds.getPassword();
    private static String connectURl="jdbc:mysql://172.31.22.43/Shubham200469159 ";
    public static int insertProject(projectMain newData) throws SQLException {
        int weatherDayId = -1;
        ResultSet resultSet = null;

        String sql = "INSERT INTO weather_data (formattedDate, precipType, temp, apparentTemp, windSpeed,dailySummary) VALUES (?,?,?,?,?,?);";

        //This is called a "try with resources" block.  It will autoclose anything in the ()
        try(
                Connection conn = DriverManager.getConnection(connectURl,user,pass);
                PreparedStatement ps = conn.prepareStatement(sql, new String[] {"weatherDayId"})
        )
        {
            //configure the prepared statement to prevent SQL injection attacks
            ps.setInt(1, newData.getFormattedDate());
            ps.setString(2,newData.getPrecipType());
            ps.setFloat(3,newData.getTemp());
            ps.setFloat(4,newData.getApparentTemp());
            ps.setFloat(5,newData.getWindSpeed());
            ps.setString(6,newData.getDailySummary());

            //run the command into the DB
            ps.executeUpdate();

            //get the cameraID
            resultSet = ps.getGeneratedKeys();
            while (resultSet.next())
                weatherDayId = resultSet.getInt(1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (resultSet != null)
                resultSet.close();
        }

        return weatherDayId;
    }

    public static ArrayList<projectMain> getCamerasFromDB()
    {
        ArrayList<projectMain> newdatas = new ArrayList<>();

        //query the DB and create Camera objects / add them to the list
        String sql = "select  * from weather_data";

        try(
                Connection conn = DriverManager.getConnection(connectURl, user, pass);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {

            while (resultSet.next())
            {
               projectMain newData = new projectMain(1,"Sunny",21.4f,23.2f,24.5f,"partly Sunny");
               newdatas.add(newData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newdatas;
    }
}
