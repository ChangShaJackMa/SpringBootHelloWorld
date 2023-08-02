package Application.WebConfig;

import Application.Interceptor.TokenLimitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//       下面这句代码相当于添加一个拦截器   添加的拦截器就是我们刚刚创建的
        System.out.println("I am InterceptorConfig");
        registry.addInterceptor(new TokenLimitInterceptor())
                .addPathPatterns("/**");
    }
}