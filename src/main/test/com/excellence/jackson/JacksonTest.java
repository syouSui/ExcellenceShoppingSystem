package com.excellence.jackson;

import com.excellence.dao.UserDao;
import com.excellence.dao.impl.UserDaoImpl;
import com.excellence.model.User;
import com.excellence.util.ResultVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName JacksonTest.java
 * @PackageLoaction com.excellence.jackson
 * @createTime 2020-05-29 15:49:00 星期五
 * @Description TODO
 */
public class JacksonTest {
    public static void main ( String[] args ) {

//        UserDao userDao = new UserDaoImpl();
//        List<User> list = userDao.findAllUser();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String str_json = mapper.writeValueAsString( list );
//            System.out.println( str_json );
//
////            List<User> received_list = mapper.readValue( str_json, new TypeReference<List<User>>(){} );
//            User user = mapper.readValue( str_json, User.class );
//
//
//
//            int a = 0;
//
//        } catch ( JsonProcessingException e ) {
//            e.printStackTrace( );
//        }

        String str_user_json = "{\"userName\":\"aa\",\"userNickname\":\"122\",\"userPassword\":\"123456\",\"role\":0,\"phone\":null,\"userEmail\":null}\n";
        ResultVo received = new ResultVo( ResultVo.CODE_SUCCESS, "yes", str_user_json );
        String received_str = received.toJSON();


//        ObjectMapper mapper = new ObjectMapper( );
//        User user = new User( );
//        try {
//            user = mapper.readValue( received.getData( ).toString( ), User.class );
//        } catch ( JsonProcessingException e ) {
//            e.printStackTrace( );
//        }

        ResultVo front = new ResultVo( received_str );



        int a = 0;


//        UserDao userDao = new UserDaoImpl();
//        List<User> userList = userDao.findAllUser();
//        String str_userList = null;
//        try {
//            str_userList = mapper.writeValueAsString( userList );
//        } catch ( JsonProcessingException e ) {
//            e.printStackTrace( );
//        }
//        ResultVo post = new ResultVo( ResultVo.CODE_SUCCESS, "yes", str_userList );

        UserDao userDao = new UserDaoImpl( );
        new ResultVo(
                ResultVo.CODE_SUCCESS,
                "yes",
                userDao.findAllUser( )
        ).toJSON();





    }
}
