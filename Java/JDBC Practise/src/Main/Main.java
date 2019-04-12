
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String... args) {
        System.out.println("Database connection app");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Database connector not found");
            System.exit(0);
        }
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/javatest","postgres","newpassword");
        } catch (SQLException e) {
            System.err.println("Connection failed");
        }

    }
}