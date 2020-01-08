package DataAccess;


import java.sql.*;
public class DataConnection {
private static DataConnection connectionSingle=null;
private Connection conn;
private DataConnection(){
	try{
	Class.forName ("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/bdd_banque";
	conn =(Connection) DriverManager.getConnection(url, "root", "");

	} catch (Exception exp) {exp.printStackTrace();}

}
public Connection getConnection() {
	return conn;
}

public static DataConnection getDataConnection(){
	if(connectionSingle==null){
		connectionSingle=new DataConnection();
	}
	return connectionSingle;
}
}
