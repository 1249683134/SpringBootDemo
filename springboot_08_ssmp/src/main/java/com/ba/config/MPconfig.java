package com.ba.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//MP配置类
@Configuration
public class MPconfig {
    @Bean

    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//      1.定义拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//      2.添加具体的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
//        要用其他拦截器就new出来加进去
//        interceptor.addInnerInterceptor(new a());
//        interceptor.addInnerInterceptor(new b());
//        interceptor.addInnerInterceptor(new c());
        return interceptor;
    }
}
