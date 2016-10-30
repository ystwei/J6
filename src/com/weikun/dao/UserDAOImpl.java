package com.weikun.dao;

import com.weikun.db.DB;
import com.weikun.vo.BBSUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/30.
 */
public class UserDAOImpl implements IUserDAO {
    private Connection conn=null;
    public UserDAOImpl(){
        conn= DB.getConnection();
    }
    @Override
    public boolean login(BBSUser user) {
        String sql="select * from bbsuser where username=? and pwd=?";
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean flag=false;
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsename());
            pstmt.setString(2,user.getPwd());
            rs=pstmt.executeQuery();
            flag=rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){

                    DB.closeConnection();;

            }
        }

        return flag;
    }
}
