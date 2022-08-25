import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    static final String url = "";
    static String username = "";
    static String password = "";

    public static void main(String [] args) {
        System.out.println("Company Database Connection");
        Connection connection = null;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        username = input.next();

        System.out.print("Enter password: ");
        password = input.next();

        try (Connection conn = DriverManager.getConnection(url, username, password); Statement stmt = conn.createStatement()) {
            String sql = "CREATE DATABASE COMPANY DATABASE";
            sql = "CREATE TABLE COMPANY" +
                "(Cid VARCHAR(20) NOT NULL," +
                    "Cname VARCHAR(50)," +
                    "City VARCHAR(30)," +
                    "Zip INTEGER," +
                    "Street VARCHAR(30)," +
                    "Country VARCHAR(30)," +
                    "PRIMARY KEY(Cid))";

            sql = "CREATE TABLE EMPLOYEE" +
                "(SSN INTEGER NOT NULL," +
                    "sex CHAR(10)," +
                    "f_name VARCHAR(30)," +
                    "m_name VARCHAR(30)," +
                    "l_name VARCHAR(30)," +
                    "Street VARCHAR(30)," +
                    "City VARCHAR(30)," +
                    "Zip INTEGER," +
                    "emp_title VARCHAR(30)," +
                    "wage_type VARCHAR(30) not NULL," +
                    "amount_per_hour DEC(9, 2)," +
                    "c_amount DEC(9, 2)," +
                    "amount_per_year DEC(9, 2)," +
                    "PRIMARY KEY(SSN))";

            sql = "CREATE TABLE DEPARTMENT" +
                    "(dno INTEGER NOT NULL," +
                    "dname varchar(20)," +
                    "PRIMARY KEY(dno))";

            sql = "CREATE TABLE IT" +
                "(dno INTEGER NOT NULL," +
                    "repair VARCHAR(50)," +
                    "test VARCHAR(50)," +
                    "PRIMARY KEY(dno))," +
                    "FOREIGN KEY(dno) REFERENCES DEPARTMENT(dno)";

            sql = "CREATE TABLE SOFTWARE DEVELOPER" +
                "(dno INTEGER NOT NULL," +
                    "analyze VARCHAR(50)," +
                    "develop VARCHAR(50)," +
                    "PRIMARY KEY(dno))," +
                    "FOREIGN KEY(dno) REFERENCES DEPARTMENT(dno)";

            sql = "CREATE TABLE ACCOUNTING" +
                "(dno INTEGER NOT NULL," +
                    "prepares VARCHAR(50)," +
                    "administer VARCHAR(50)," +
                    "PRIMARY KEY(dno))," +
                    "FOREIGN KEY(dno) REFERENCES DEPARTMENT(dno)";

            sql = "CREATE TABLE WORKS" +
                "(Cid VARCHAR(20) NOT NULL," +
                "SSN INTEGER NOT NULL," +
                "PRIMARY KEY(Cid, SSN)," +
                "FOREIGN KEY(Cid) REFERENCES COMPANY(Cid)," +
                "FOREIGN KEY(SSN) REFERENCES EMPLOYEE(SSN)";

            sql = "CREATE TABLE WORKS_IN" +
                "(SSN INTEGER NOT NULL," +
                "dno INTEGER NOT NULL," +
                "PRIMARY KEY(SSN, dno)," +
                "FOREIGN KEY(SSN) REFERENCES EMPLOYEE(Cid)," +
                "FOREIGN KEY(dno) REFERENCES DEPARTMENT(dno)";

            sql = "CREATE TABLE MANAGES" +
                "(SSN INTEGER NOT NULL," +
                "dno INTEGER NOT NULL," +
                "PRIMARY KEY(SSN, dno)," +
                "FOREIGN KEY(SSN) REFERENCES EMPLOYEE(SSN)," +
                "FOREIGN KEY(dno) REFERENCES DEPARTMENT(dno)";

            stmt.executeUpdate(sql);
            System.out.println("Successfully created the database");

        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed!!!");
        }
    }
}