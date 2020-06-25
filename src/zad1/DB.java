package zad1;

import java.sql.*;


public class DB {


    private static String conURL = "jdbc:derby:database/BookDB;create=true";

    private ResultSet result;

  private Connection conn;

  public DB(){

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Get a connection

             conn = DriverManager.getConnection(conURL);


        }catch (Exception ex){ex.printStackTrace();}

    }


  public Connection getConn(){
      return conn;
  }

    public String getResultQuery(Connection conn,String statment) throws SQLException {



        Statement stmt = conn.createStatement();

        System.out.println(statment);

        result = stmt.executeQuery(statment);

        String result_query = "";

        while (result.next()) {

            String[] vals = {result.getString(1),
                            result.getString(2),
                   result.getString(3),
                   result.getString(4),
                   result.getString(5),
                   result.getString(6)};

            for (int i = 0; i < vals.length; i++) {

                result_query += result.getMetaData().getColumnName(i+1) + ": " + vals[i] + "\n";
            }

            result_query += "\n";
        }


        return result_query;
    }



}
