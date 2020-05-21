package com.excellence.dao.impl;

import com.excellence.dao.UserDao;
import com.excellence.dao.UserInformationDao;
import com.excellence.model.User;
import com.excellence.model.UserInformation;
import com.excellence.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName UserInformationImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 18:25:00 星期三
 * @Description TODO
 */
public class UserInformationDaoImpl extends DBUtil implements UserInformationDao {
    String selectSQL= "select * from user_information where 1=1 ";
    String select_userName = "and userName = ? ";
    String modifySQL = "update user_information set relativeName = ?, address = ?, relativePhone = ? where userName = ? ";
    String insertSQL = "insert insert into user_information values(?,?,?,?)";
    String removeSQL = "delete from user where userName = ? and relativeName = ? and address = ? and relativePhone = ? ";


    @Override
    public List<UserInformation> findBy_userName ( String userName ) {
        List<UserInformation> userInformationList = null;
        ResultSet resultSet = null;
        String[] param = new String[]{ userName };
        super.getConnection();
        resultSet = super.executeQuery(selectSQL+select_userName,param);
        try {
            while (resultSet.next()){
                UserInformation userInformation = new UserInformation(
                        resultSet.getString("userName"),
                        resultSet.getString("relativeName"),
                        resultSet.getString("address"),
                        resultSet.getString("relativePhone")
                );
                userInformationList.add(userInformation);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        super.closeAll();
        return userInformationList;
    }

    @Override
    public int add ( UserInformation userInformation ) {
        int count = 0;
        String[] param = new  String[]{
                userInformation.getUserName(),
                userInformation.getRelativeName(),
                userInformation.getAddress(),
                userInformation.getRelativePhone()
        };
        super.getConnection();
        count = super.executeUpdate(insertSQL,param);
        super.closeAll();
        return count;
    }

    @Override
    public int remove ( UserInformation userInformation ) {
        int count = 0;
        String[] param = new  String[]{
                userInformation.getUserName(),
                userInformation.getRelativeName(),
                userInformation.getAddress(),
                userInformation.getRelativePhone()
        };
        super.getConnection();
        count = super.executeUpdate(removeSQL,param);
        super.closeAll();
        return count;
    }

    @Override
    public int modify ( UserInformation userInformation ) {//#########################################################
        return 0;
    }
}
