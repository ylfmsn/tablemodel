package com.suntoon.swing.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description TODO
 * @Author ylf
 * @Date 2019/9/20 0020上午 10:46
 */
public class SqliteUtils {
    /**
     * 创建一个.sop文件
     * @param path
     * @return
     */
    private static void createDBFile(String path) {
        Connection conn = null;
        Statement stat = null;

        StringBuffer sb = new StringBuffer("create table treedata( ");
        sb.append("_id integer primary key,");
        sb.append("name varchar,");
        sb.append("code varchar,");
        sb.append("parent_id int);");
        sb.append("create index parent_id_index on treedata (parent_id);");

        //连接SQLite的JDBC
        try {
            Class.forName("org.sqlite.JDBC");
            //建立一个.sop数据库的连接，如果不存在就在当前目录下创建之
            conn = DriverManager.getConnection("jdbc:sqlite:" + path);
            stat = conn.createStatement();
            stat.executeUpdate(sb.toString());//创建一个表，两列

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null)
                    stat.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
