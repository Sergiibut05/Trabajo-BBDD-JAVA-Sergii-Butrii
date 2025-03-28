package connection;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionList {
//Atributos
    private String url;
    private String user;
    private String password;
    private ArrayList<Connection> connections = new ArrayList<Connection>() {
        
    };
//Constructore
    public ConnectionList(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
//Metodos
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection _conn = DriverManager.getConnection(this.url, this.user, this.password);
        this.connections.add(_conn);
        return _conn;
    }

    public void closeAll() throws SQLException{
        for(Connection conn : this.connections){
            if(conn!=null && !conn.isClosed()){
                conn.close();
            }
        }
    }
}
