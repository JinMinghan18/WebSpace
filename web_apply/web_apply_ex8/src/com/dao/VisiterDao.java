package com.dao;

import com.model.IP;
import jdk.nashorn.internal.ir.RuntimeNode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisiterDao extends Basedao {
    //查询ip是否存在
    public boolean isIPexist(String ip){
        String sql = "SELECT * FROM ip_info WHERE ip=?";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,ip);
            IP ip1 = new IP();
            try (ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    ip1.setIP(rst.getString("ip"));
                    ip1.setVisit_time(rst.getString("visit_time"));
                    if(rst.getString("visit_time")!=null){
                        return true;
                    }
                    else
                        return false;
                }
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return false;
    }
    //存入数据
    public 

}
