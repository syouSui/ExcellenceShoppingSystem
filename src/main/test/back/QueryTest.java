package back;

import com.excellence.model.User;
import com.excellence.util.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName QueryTest.java
 * @PackageLoaction com.excellence.util
 * @createTime 2020-05-25 17:23:00 星期一
 * @Description TODO
 */
public class QueryTest {
    private static QueryRunner queryRunner = new QueryRunner( C3P0Utils.getDataSource( ) );

    public static void main ( String[] args ) throws SQLException {
//            String sql = "select * from user;";
//            Connection con = C3P0Utils.getConnection();
//            List<User> list = queryRunner.query( con , sql, new BeanListHandler<>( User.class ) );
//            con.close();
    }
}
