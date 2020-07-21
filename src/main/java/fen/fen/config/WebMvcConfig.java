package fen.fen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor = new WebContentInterceptor();
//         addPathPatterns 用于添加拦截规则, 这里假设拦截 /url 后面的全部链接
//         excludePathPatterns 用户排除拦截
        registry.addInterceptor(interceptor).excludePathPatterns("/**");
//        registry.addInterceptor(interceptor).addPathPatterns("/**")
//                .excludePathPatterns("/swagger-resources/**", "/swagger-resources/configuration/ui",
//                        "/swagger-ui.html/**", "/v2/**", "/webjars/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").
                addResourceLocations("classpath:/static/**", "classpath:/META-INF/resources/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "DELETE")
                .allowedHeaders("Content-Disposition")
                .maxAge(3600)
                .allowCredentials(true);
    }
}
