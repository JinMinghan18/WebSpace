package cn.edu.zjut.dao;

import cn.edu.zjut.model.UserBean;
import com.sun.xml.internal.ws.message.stream.PayloadStreamReaderMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends baseDao {

    public boolean searchUser(UserBean user){
        String sql = "SELECT * FROM usertable WHERE username=? and password=?";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                return true;
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return false;
    }

}
