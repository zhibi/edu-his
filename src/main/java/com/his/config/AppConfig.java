package com.his.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import zhibi.utils.DateUtils;
import zhibi.utils.StringUtils;

import java.util.Date;

@Configuration
public class AppConfig {


    @Bean
    public Converter<String, Date> dateConverter() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                if (StringUtils.isEmpty(source))
                    return null;
                else
                    return DateUtils.parse(source, "yyyy-MM-dd");
            }
        };
    }
}
