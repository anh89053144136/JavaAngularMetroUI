package anh.AngularMetroUI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

@SpringBootTest
public class CreateDataBase {
	@Test
	public void test() throws SQLException, LiquibaseException, IOException {
		Connection cn = DriverManager.getConnection("jdbc:postgresql://192.168.116.134:5432/angularmetroui?characterEncoding=UTF-8", "angularmetroui", "angularmetroui");
        Liquibase liquibase = null;
        
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(cn));
        // src/main/resources/db/main.xml
        liquibase = new Liquibase("resources/db/main.xml", //
        		new ClassLoaderResourceAccessor(), database);
        
//        try {        
        	liquibase.update("MyContext");
//          } finally {
//            if (cn != null) {
//                try {
//                	cn.rollback();
//                	cn.close();
//                } catch (SQLException e) {
//                    //nothing to do
//                }
//            }
//        }
	}
	
}
