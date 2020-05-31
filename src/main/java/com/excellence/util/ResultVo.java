package com.excellence.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName ResultVo.java
 * @PackageLoaction com.excellence.util
 * @createTime 2020-05-29 16:11:00 星期五
 * @Description TODO
 */
public class ResultVo {
    public static final int CODE_FAILED = 0;
    public static final int CODE_SUCCESS = 1;
    public static final int CODE_NOLOGIN = 2;
    public static final int CODE_AUTH_FAIL = 403;

    private int code;
    private String message;
    private String data;

    public ResultVo ( ) {
    }

    public ResultVo ( String json ) {
        try {
            ResultVo resultVo = new ObjectMapper( ).readValue( json, ResultVo.class );
            this.code = resultVo.code;
            this.message = resultVo.message;
            this.data = resultVo.data;
        } catch ( JsonProcessingException e ) {
            e.printStackTrace( );
        }
    }

    public ResultVo ( int code, String message, Object data ) {
        this.code = code;
        this.message = message;
        this.setData( data );
    }

    public int getCode ( ) {
        return code;
    }

    public void setCode ( int code ) {
        this.code = code;
    }

    public String getMessage ( ) {
        return message;
    }

    public void setMessage ( String message ) {
        this.message = message;
    }

    public Object getData ( ) {
        return data;
    }

    public void setData ( Object data ) {
        String data_json = null;
        try {
            data_json = new ObjectMapper( ).writeValueAsString( data );
        } catch ( JsonProcessingException e ) {
            e.printStackTrace( );
        }
        this.data = data_json;
    }

    public String toJSON ( ) {
        String resultVo_json = null;
        try {
            resultVo_json = new ObjectMapper( ).writeValueAsString( this );
        } catch ( JsonProcessingException e ) {
            e.printStackTrace( );
        }
        return resultVo_json;
    }

}
