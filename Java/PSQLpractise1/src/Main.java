import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List array = new ArrayList();
        System.out.println("Database connection app");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (!input.equals("exit")){
            try {
                input = in.readLine();
                TaskManager(input);
                System.out.println("working, input was: " + input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // array = getRecords(connection);
        // System.out.println(array);
        // System.out.println("Insertion successful:" + Adding(connection));
        // System.out.println(Deleting(connection));
        // System.out.println(Update(connection));
    }

    private static void TaskManager(String input) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Database connector not found");
            System.err.println(e);
            System.exit(0);
        }
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/javatest", "postgres", "newpassword");
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.err.println("Connection failed");
        }
        String[] str = input.split(" ");
        List array = new ArrayList();
        if (str.length > 1) {
            if (str[0].equals("GET") && str[1].equals("ALL")) {
                array = getRecords(connection);
                System.out.println(array);
            } else if (str[0].equals("GET") && str[1].equals("BY") && str[2].equals("NAME")) {
                array = getRecordsByName(connection, str[3]);
                System.out.println(array);
            } else if (str[0].equals("GET") && str[1].equals("BY") && str[2].equals("ID")) {
                array = getRecordsById(connection, Integer.parseInt(str[3]));
                System.out.println(array);
            }
        }
        for (int i=0; i < str.length; i++) {

        }
    }

    public static List<PhoneBookEntry> getRecords(Connection C) {
        List<PhoneBookEntry> phony = new ArrayList<PhoneBookEntry>();
        try (PreparedStatement preparedStatement = C
                .prepareStatement("select id, pn, name, description from phonebook");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pn = resultSet.getString("pn");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                PhoneBookEntry entry = new PhoneBookEntry(id, pn, name, description);
                phony.add(entry);
            }
        } catch (SQLException e) {
            System.err.println("Connection failed! " + e.getMessage());
        }

        return phony;
    }
    public static List<PhoneBookEntry> getRecordsByName(Connection C, String str3) {
        List<PhoneBookEntry> phony = new ArrayList<PhoneBookEntry>();
        try (PreparedStatement preparedStatement = C
                .prepareStatement("select id, pn, name, description from phonebook WHERE name=?");) {
            preparedStatement.setString(1, str3);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pn = resultSet.getString("pn");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                PhoneBookEntry entry = new PhoneBookEntry(id, pn, name, description);
                phony.add(entry);
            }
        } catch (SQLException e) {
            System.err.println("Connection failed! " + e.getMessage());
        }

        return phony;
    }
    public static List<PhoneBookEntry> getRecordsById(Connection C, int str3) {
        List<PhoneBookEntry> phony = new ArrayList<PhoneBookEntry>();
        try (PreparedStatement preparedStatement = C
                .prepareStatement("select id, pn, name, description from phonebook WHERE id=?");) {
            preparedStatement.setInt(1, str3);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pn = resultSet.getString("pn");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                PhoneBookEntry entry = new PhoneBookEntry(id, pn, name, description);
                phony.add(entry);
            }
        } catch (SQLException e) {
            System.err.println("Connection failed! " + e.getMessage());
        }

        return phony;
    }

    public static boolean Adding(Connection C) {
        try (PreparedStatement preparedStatement = C
                .prepareStatement("insert into phonebook (pn, name, description) values (?, ?, ?);");) {
            preparedStatement.setString(1, "+369977007");
            preparedStatement.setString(2, "Robi");
            preparedStatement.setString(3, "Java");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean Deleting(Connection C) {
        try (PreparedStatement preparedStatement = C
                .prepareStatement("DELETE FROM phonebook WHERE id=3;");) {
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public static boolean Update(Connection C) {
        try (PreparedStatement preparedStatement = C
                .prepareStatement("UPDATE phonebook SET pn=999999 WHERE id=1;");) {
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}