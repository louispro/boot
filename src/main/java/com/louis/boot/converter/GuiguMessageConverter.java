package com.louis.boot.converter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.louis.boot.bean.Louis;
import com.louis.boot.bean.Person;

/**
 * @赖小燚
 * @www.louis_lai.com
 */

public class GuiguMessageConverter implements HttpMessageConverter<Louis> {
    @Override
    public boolean canRead(Class<?> aClass, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> aClass, MediaType mediaType) {
        return aClass.isAssignableFrom(Louis.class);
    }

    /***
     *  服务器要统计MessageConverter都能写出哪些内容类型 application/x-guigu
     * @return
     * @author zhangenguang
     * @date 2021/9/20 19:39
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-guigu");
    }

    @Override
    public Louis read(Class<? extends Louis> aClass,
            HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    /***
     * 自定义协议数据的写出
     * @param louis
     * @param mediaType
     * @param httpOutputMessage
     * @return
     * @author zhangenguang
     * @date 2021/9/20 19:42
     */
    @Override
    public void write(Louis louis, MediaType mediaType,
            HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String data = louis.getName()+";"+louis.getSlave();
        //写出去
        OutputStream body = httpOutputMessage.getBody();
        body.write(data.getBytes());
    }
}
