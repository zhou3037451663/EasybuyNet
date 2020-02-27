package com.buy.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.*;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/19
 * @Explain:
 */
public class DataSourceUtil {
    /**
     * 配置阿里巴巴连接池
     */
    private final static String URL = "jdbc:mysql://localhost/easybuy";
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String USER = "admin";
    private final static String PASSWORD = "1234";
    //创建druid数据源对象
    private static DruidDataSource druidDataSource = null;

    static {
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 配置阿里巴巴数据源
     */
    public static DruidDataSource init() throws SQLException {
        //实例化DruidDataSource
        druidDataSource = new DruidDataSource();
        //设置属性的值
        druidDataSource.setDriverClassName(DRIVER);
        druidDataSource.setUrl(URL);
        //设置连接池相关属性
        druidDataSource.setInitialSize(5);//初始化连接池数量
        druidDataSource.setMaxActive(100);//最大连接数
        druidDataSource.setMinIdle(1);//最大空闲连接数
        druidDataSource.setMaxWait(1000);//连接等待时长，单位：毫秒
        druidDataSource.setFilters("stat");//设置监控
        return druidDataSource;
    }

    /**
     * 连接数据源的方法
     *
     * @return
     */
    public static Connection getConn() {
        Connection conn = null;
        //加载mysql驱动(开启服务)
        try {
            Class.forName(DRIVER);
            //如果数据库处于没有连接状态，则创建一个连接
            if (conn == null) {
                conn = druidDataSource.getConnection(USER, PASSWORD);
            }
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭的方法
     *
     * @param conn 数据库连接对象
     */
    public static void closeConnection(ResultSet rs, PreparedStatement pstm, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 增删改的通用方法
     *
     * @param sql
     * @param param
     * @return
     */
    public static int execaUpdate(String sql, Object... param) {
        Connection conn = getConn();
        int num = 0;
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstm.setObject(i + 1, param[i]);
                }
            }
            num = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return num;
    }

    public int executeInsert(String sql, Object... param) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Long num = 0L;
        try {
             conn=getConn();
             pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstm.setObject(i + 1, param[i]);
                }
            }
            pstm.executeUpdate();
             rs=pstm.getGeneratedKeys();
           if (rs.next()){
               num=rs.getLong(1);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(rs,pstm,conn);
        }
        return num.intValue();
    }
    public ResultSet executeQuery(String sql,Object...param){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try {
            conn=getConn();
            pstm=conn.prepareStatement(sql);
            if (param!=null){
                for (int i = 0; i < param.length; i++) {
                    pstm.setObject(i+1,param[i]);
                }
            }
            rs=pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}