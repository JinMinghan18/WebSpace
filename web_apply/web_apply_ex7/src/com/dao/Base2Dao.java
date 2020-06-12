package com.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;

public class Base2Dao {
    DataSource dataSource;
    public Base2Dao(){
        try{

            Context context = new InitialContext();
            dataSource =
                    (DataSource)context.lookup("java:comp/env/jdbc/sampleDS2");
        }catch (NamingException ne){
            System.out.println("Exception:"+ne);
        }
    }
    public Connection getConnection()throws Exception{
        return dataSource.getConnection();
    }

}