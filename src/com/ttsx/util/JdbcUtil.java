package com.ttsx.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: 马果
 * @Date: 2021/3/17 10:51
 * 工具类：用于产生数据源
 */
public class JdbcUtil {

    //声明数据源DataSource
    private static DataSource ds;

    //通过静态块，初始化数据源
    static{
        try{
            //加载配置文件，得到输入流
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");

            //创建属性类
            Properties prop = new Properties();

            //将输入流的信息，加载到属性类中
            prop.load(in);

            //通过属性类中的信息，产生数据源
            ds = DruidDataSourceFactory.createDataSource(prop);

            //关闭流
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // 编写 一个静态方法，得到数据源
    public static DataSource getDs(){
        return ds;
    }
}
