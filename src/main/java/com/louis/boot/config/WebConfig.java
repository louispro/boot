package com.louis.boot.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.louis.boot.bean.Slave;
import com.louis.boot.converter.GuiguMessageConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //自定义rest请求的name值
//    @Bean
//    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
//        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
//        methodFilter.setMethodParam("_m");
//        return methodFilter;
//    }


//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        //设置路径解析不移除分号后面的内容，这样便可以开启矩阵变量
//        urlPathHelper.setRemoveSemicolonContent(false);
////        urlPathHelper.setAlwaysUseFullPath(true);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }


    //定制springmvc的功能
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            //    设置路径解析不移除分号后面的内容，这样便可以开启矩阵变量
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            //添加自定义转换器
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Slave>() {

                    @Override
                    public Slave convert(String str) {
                        if(!StringUtils.isEmpty(str)){
                            Slave slave = new Slave();
                            slave.setName(str.split(",")[0]);
                            slave.setHost(str.split(",")[1]);
                            return slave;
                        }
                        return null;
                    }
                });
            }

            //添加自定义MessageConverter
            @Override
            public void extendMessageConverters(
                    List<HttpMessageConverter<?>> converters) {
                converters.add(new GuiguMessageConverter());
            }

            //自定义基于参数的内容协商
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypeMap = new HashMap<>();
                mediaTypeMap.put("json",MediaType.APPLICATION_JSON);
                mediaTypeMap.put("xml",MediaType.APPLICATION_ATOM_XML);
                mediaTypeMap.put("gg",MediaType.parseMediaType("application/x-guigu"));
                //指定支持解析哪些参数对应的哪些媒体类型
                ParameterContentNegotiationStrategy parameterContentNegotiationStrategy =
                        new ParameterContentNegotiationStrategy(mediaTypeMap);
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy =
                        new HeaderContentNegotiationStrategy();
                configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy,headerContentNegotiationStrategy));
            }
        };
    }
}
