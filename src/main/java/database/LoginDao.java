package database;
import bean.*;
import java.sql.*;


public class LoginDao {

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

    public boolean delete(lesBeans bean) throws ClassNotFoundException
    {
        boolean rowdel = false;
        Class.forName("com.mysql.jdbc.Driver");
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/helpdesk?useSSL=false", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement("delete from ticket where id=?");
            preparedStatement.setInt(1,bean.getId());
            rowdel = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowdel;
    }


    /*

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    public ArrayList<beansAff> findAllEmployer()
    {
        ArrayList<beansAff> ticket = new ArrayList<beansAff>();
        try{
            Class.forName ("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/helpdesk?serverTimezone=UTC", "root", "");
            stmt = conn.createStatement();
            rset = stmt.executeQuery("Select * from ticket");
            while(rset.next())
            {
                beansAff tick = new beansAff();
                tick.setId(rset.getInt("id"));
                tick.setNom(rset.getString("nom"));
                tick.setEmail(rset.getString("email"));
                tick.setService(rset.getString("service"));
                tick.setPhone(rset.getString("phone"));
                tick.setTypeAppareil(rset.getString("typeAppareil"));
                tick.setMessage(rset.getString("message"));
                ticket.add(tick);
            }

            rset.close();
            stmt.close();
            conn.close();
        }

        catch(SQLException e1){
            System.out.println(e1.getMessage());
        }

        catch(ClassNotFoundException e2){
            System.out.println(e2.getMessage());
        }
        return ticket;
    }
*/


/*
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

 */
}