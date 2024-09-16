import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DB {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "elensar15";
    private static final Pattern COMMENT_PATTERN = Pattern.compile("–.*|/\\*(.|[\\r\\n])*?\\*/");

    public static Connection connect() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void disconnect() throws SQLException {
        Connection db = DriverManager.getConnection(URL, USER, PASSWORD);
        db.close();
    }

    static void executeBatchedSQL(String scriptFilePath, Connection connection, int batchSize) throws Exception {
        List<String> sqlStatements = parseSQLScript(scriptFilePath);
        executeSQLBatches(connection, sqlStatements, batchSize);
    }

    public static List<String> parseSQLScript(String sqlFilePath) throws IOException {
        List<String> sqlStatements = new ArrayList<String>();

        try(BufferedReader br = new BufferedReader(new FileReader(sqlFilePath))){
            StringBuilder currentStatement = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                Matcher commentMatcher = COMMENT_PATTERN.matcher(line);
                line = commentMatcher.replaceAll("");
                line = line.trim();

                if(line.isEmpty()){
                    continue;
                }
                currentStatement.append(line).append(" ");

                if(line.endsWith(";")){
                    sqlStatements.add(currentStatement.toString());
                    currentStatement.setLength(0);
                }
            }
        } catch(IOException e){
            throw e;
        }

        return sqlStatements;
    }

    public static void executeSQLBatches(Connection c, List<String> sqlStatements, int batchSize) throws SQLException {
        int count = 0;
        Statement stmt = c.createStatement();

        for(String sql : sqlStatements){
            stmt.addBatch(sql);
            count = count+1;
            if(count % batchSize == 0){
                stmt.executeBatch();
                stmt.clearBatch();
            }
        }
        if(count % batchSize != 0){
            stmt.executeBatch();
        }
    }
}