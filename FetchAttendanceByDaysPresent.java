import java.sql.*;
import java.util.Scanner;

class FetchAttendanceByDaysPresent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost/ri_db";
        String username = "test";
        String password = "test123";
        
        int daysThreshold = scanner.nextInt();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // Establish connection to the database
            conn = DriverManager.getConnection(url, username, password);
            
            // Prepare SQL query to fetch employees with days_present > threshold
            String sql = "SELECT employee_id, employee_name, days_present FROM attendance WHERE days_present > ? ORDER BY employee_id";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, daysThreshold);
            
            // Execute the query
            rs = pstmt.executeQuery();
            
            // Check if any records are found
            boolean found = false;
            while (rs.next()) {
                found = true;
                int employeeId = rs.getInt("employee_id");
                String employeeName = rs.getString("employee_name");
                int daysPresent = rs.getInt("days_present");
                
                // Display employee information
                System.out.println("Employee ID: " + employeeId);
                System.out.println("Employee Name: " + employeeName);
                System.out.println("Days Present: " + daysPresent);
                System.out.println(); // blank line after each employee
            }
            
            // If no matching records found
            if (!found) {
                System.out.println("No employee found with more than " + daysThreshold + " days present");
            }
            
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}
