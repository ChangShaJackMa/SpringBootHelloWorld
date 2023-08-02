package Application.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public void uploadException(Exception e, HttpServletResponse resp) throws IOException {
        System.out.println("MyException:"+e.toString());
    }

    @ExceptionHandler(TimeoutException.class)
    @ResponseBody
    public String timeoutExceptionHandler(Exception e){

        String res="sorry,timeout-处理超时:"+e.toString();
        return res;
    }
    @ExceptionHandler(NoTokenException.class)
    @ResponseBody
    public String noTokensException(){
        return "当前访问人数过多，请稍后再试";
    }
}
