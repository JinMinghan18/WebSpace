package com.dao;

import com.model.newbug;
import com.model.newpaper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class seebugdao extends Basedao{
    public ArrayList<newbug> allnewbugInfo(){
        String sql = "SELECT * FROM buginfo ORDER BY update_time desc ";
        ArrayList<newbug> newbugList = new ArrayList<newbug>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    newbug newbug1 = new newbug();
                    newbug1.setSSV_ID(rst.getString("SSV_ID"));
                    newbug1.setUpdate_time(rst.getString("update_time"));
                    newbug1.setBug_name(rst.getString("bug_name"));
                    newbug1.setBug_level(rst.getString("bug_level"));
                    newbug1.setBug_status(rst.getString("bug_status"));
                    newbugList.add(newbug1);
                }

            }
            return newbugList;
        }catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }


    public ArrayList<newpaper> allnewpaper(){
        String sql = "SELECT * FROM newpaper ORDER BY paper_time desc ";
        ArrayList<newpaper> newpaperList = new ArrayList<newpaper>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    newpaper newpaper1 = new newpaper();
                    newpaper1.setPaper_name(rst.getString("paper_name"));
                    newpaper1.setPaper_time(rst.getString("paper_time"));
                    newpaper1.setPaper_category(rst.getString("paper_category"));
                    newpaper1.setPaper_introduce(rst.getString("paper_introduce"));
                    newpaperList.add(newpaper1);
                }

            }
            return newpaperList;
        }catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }



    public ArrayList<newbug> allnewPOC(){
        String sql = "SELECT * FROM newPOC ORDER BY time desc ";
        ArrayList<newbug> newbugList = new ArrayList<newbug>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    newbug newbug1 = new newbug();
                    newbug1.setSSV_ID(rst.getString("ssv_id"));
                    newbug1.setUpdate_time(rst.getString("time"));
                    newbug1.setBug_name(rst.getString("name"));
                    newbug1.setBug_level(rst.getString("level"));
                    newbug1.setBug_status(rst.getString("status"));
                    newbugList.add(newbug1);
                }

            }
            return newbugList;
        }catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }
}
