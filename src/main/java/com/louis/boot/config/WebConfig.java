package com.louis.boot.config;

import com.louis.boot.bean.Slave;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
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

//    设置路径解析不移除分号后面的内容，这样便可以开启矩阵变量
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
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
        };
    }
}
