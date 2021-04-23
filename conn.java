package hotel.management.system;

import java.sql.*;

public class conn {
Connection c;
Statement s;

public conn(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c= DriverManager.getConnection("JDBC:mysql://localhost:3305/projecthms","root","Vaishnavi@23");
        s= c.createStatement();
    }
    catch(Exception e){
        e.printStackTrace();
    }
}
}
