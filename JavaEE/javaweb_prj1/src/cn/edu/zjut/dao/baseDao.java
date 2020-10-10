package cn.edu.zjut.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;

public class baseDao {
    DataSource dataSource;
    public baseDao(){
        try{
            Context context = new InitialContext();
            dataSource =
                    (DataSource)context.lookup("java:comp/env/jdbc/sampleDS");
        }catch (NamingException ne){
            System.out.println("Exception:"+ne);
        }
    }
    public Connection getConnection()throws Exception{
        return dataSource.getConnection();
    }
}
