package Application.Interceptor;

import Application.MyUtil.MyUtil;
import Application.exception.NoTokenException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class TokenLimitInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int tokens= MyUtil.Tokens.get();
        System.out.println("beforeTokens:"+tokens);
        if(tokens<1){
            throw new NoTokenException();
        }
        while(!MyUtil.Tokens.compareAndSet(tokens,tokens-1)){
            tokens=MyUtil.Tokens.get();
            if(tokens<1){
                throw new NoTokenException();
            }
        }
        System.out.println("afterTokens:"+(tokens-1));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("I am TokenLimitInterceptor.postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        MyUtil.Tokens.addAndGet(1);
        System.out.println("CurTokens:"+MyUtil.Tokens.toString());
    }
}
