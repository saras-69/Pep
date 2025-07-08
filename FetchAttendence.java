import java.sql.*;
import java.util.Scanner;

class FetchAttendanceByDaysPresent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:mysql://localhost/ri_db";
        String username = "test";
        String password = "test123";

        System.out.print("Enter threshold for days present: ");
        int daysThreshold = scanner.nextInt();

        boolean found = false;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Connecting to database...");
            try (
                    Connection conn = DriverManager.getConnection(url, username, password);
                    PreparedStatement pstmt = conn.prepareStatement(
                            "SELECT id, name, days_present FROM attendance WHERE days_present > ?")) {
                pstmt.setInt(1, daysThreshold);

                System.out.println("Executing query...");
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        found = true;
                        System.out.println("Employee ID: " + rs.getInt("id"));
                        System.out.println("Employee Name: " + rs.getString("name"));
                        System.out.println("Days Present: " + rs.getInt("days_present"));
                        System.out.println();
                    }
                }
            }

            if (!found) {
                System.out.println("No employee found with more than " + daysThreshold + " days present");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Please add the driver to your classpath.");
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}