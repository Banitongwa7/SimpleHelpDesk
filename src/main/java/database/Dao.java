package database;
import bean.*;
import java.sql.*;


public class Dao {

    public boolean insert(lesBeans bean) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/helpdesk?useSSL=false", "root", "");
            // connection
            PreparedStatement preparedStatement = connection.prepareStatement("insert into ticket (nom,email,service,phone,typeAppareil,message) values(?,?,?,?,?,?)");
            preparedStatement.setString(1, bean.getNom());
            preparedStatement.setString(2, bean.getEmail());
            preparedStatement.setString(3, bean.getService());
            preparedStatement.setString(4, bean.getPhone());
            preparedStatement.setString(5, bean.getTypeAppareil());
            preparedStatement.setString(6, bean.getMessage());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            status = true;

        } catch (SQLException e) {
            // process sql exception
            // printSQLException(e);
            System.out.println(e.getMessage());
        }
        return status;
    }

    public boolean delete(lesBeans bean) throws ClassNotFoundException {
        boolean rowdel = false;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/helpdesk?useSSL=false", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement("delete from ticket where id=?");
            preparedStatement.setInt(1, bean.getId());
            rowdel = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowdel;
    }


    public boolean loginUser(loginBeans loginbean) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        boolean trouve = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/helpdesk?serverTimezone=UTC", "root", "");
            stmt = conn.prepareStatement("Select * from user where email = ? and password = ?");
            stmt.setString(1, loginbean.getEmail());
            stmt.setString(2, loginbean.getPassword());
            rset = stmt.executeQuery();
            trouve = rset.next();

            rset.close();
            stmt.close();
            conn.close();
        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        } catch (ClassNotFoundException e2) {
            System.out.println(e2.getMessage());
        }
        return trouve;
    }


    public boolean newUser(signupBeans bean) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/helpdesk?useSSL=false", "root", "");
            // connection
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user (nom,prenom,email,password) values(?,?,?,?)");
            preparedStatement.setString(1, bean.getNom());
            preparedStatement.setString(2, bean.getPrenom());
            preparedStatement.setString(3, bean.getEmail());
            preparedStatement.setString(4, bean.getPassword());

            System.out.println(preparedStatement);
            status = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }


    public boolean loginAdmin(loginBeans loginbean) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        boolean trouve = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/helpdesk?serverTimezone=UTC", "root", "");
            stmt = conn.prepareStatement("Select * from admin where nomadmin = ? and passadmin = ?");
            stmt.setString(1, loginbean.getEmail());
            stmt.setString(2, loginbean.getPassword());
            rset = stmt.executeQuery();
            trouve = rset.next();

            rset.close();
            stmt.close();
            conn.close();
        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        } catch (ClassNotFoundException e2) {
            System.out.println(e2.getMessage());
        }
        return trouve;
    }
}