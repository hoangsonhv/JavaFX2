package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connected {
    public static Connected connected;
    public final static String connectString = "jdbc:mysql://localhost:3306/project";
    public final static String user = "root";
    public final static String password = "";

    Statement statement;

    public static Connected getConnected() {
        return connected;
    }

    public static void setConnected(Connected connected) {
        Connected.connected = connected;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connected(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectString,user,password);
            setStatement(conn.createStatement());
        }catch (Exception e){
            System.out.println("ERROR.!");
        }
    }

    public static Connected getInstance(){
        if (connected == null) {
            connected = new Connected();
        }
        return connected;
    }
}
