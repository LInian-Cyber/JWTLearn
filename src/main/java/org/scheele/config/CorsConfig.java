package org.scheele.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * 在新的springboot框架中还是使用CorsConfig implements WebMvcConfigurer这种实现方法来配置，但是有更新的方法如CorsWebFilter和application文件配置
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
// 设置允许跨域的路径
        registry.addMapping("/**")
// 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
// 是否允许cookie
                .allowCredentials(true)
// 设置允许的请求方式
                .allowedMethods("GET", "POST", "DELETE", "PUT")
// 设置允许的header属性
                .allowedHeaders("*")
// 跨域允许时间
                .maxAge(3600);
    }

}
