import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * @program: maven-mysql
 * @className: com.kaka.TestMysql
 * @description: TODO
 * @author: 513 王老师(qq:292817678,tel&微信:18688753763)
 * @create: 2020-09-21 15:12
 **/
public class MySQL_Test {
    public static void main(String[] args) throws Exception {
        // 链接上数据库
        Class.forName("com.mysql.jdbc.Driver");
        // 获取数据库的链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://ncscu.cn:3306/class_test?useUnicode=true&characterEncoding=utf8",
                "admin", "admin");


        // 插入的数据
        String username = "数据分析也要写程序";
        int age = 100;
        Date birth = new Date();

        // 保存数据
        String saveSql = "insert into users(username,age,birth) values(?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(saveSql);

        // 给占位符赋值
        pstmt.setString(1, username);
        pstmt.setInt(2, age);
        pstmt.setObject(3, birth);

        // 执行sql语句
        pstmt.executeUpdate(); // 适合 insert delete update的操作

        /**
         * 在这里开始增删改查实现
         *
         * */

        /**
         * 删除操作
         * */

        String deleteSQL = "delect * ";


        // 准备sql语句
        String sql = "select id, username, age, birth from users";

        // 预编译sql语句
        pstmt = conn.prepareStatement(sql);

        // 执行sql语句
        ResultSet rs = pstmt.executeQuery();

        // 使用循环的方式从rs中获取数据

        while (rs.next()) {
            System.out.print(rs.getInt("id") + "\t");
            System.out.print(rs.getString("username") + "\t");
            System.out.print(rs.getInt("age") + "\t");
            System.out.print(rs.getTimestamp("birth") + "\t");
            System.out.println();
        }

    }
}