import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("hello world!\n");

        try(var connection = DB.connect()){
            System.out.println("Connected to the PostgreSQL database.");

            DB.executeBatchedSQL("src/Bank_tables.sql", connection, 10);
            System.out.println("The tables has been created.");

            DB.disconnect();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}