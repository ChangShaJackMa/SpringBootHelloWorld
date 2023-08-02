package Application.controller.av;


import Application.Dao.av.JavbooksDao;
import Application.MyUtil.MyUtil;
import Application.POBJ.av.JavbooksPobj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
public class JavbooksController {
    @Autowired
    JavbooksDao jbd;
    @RequestMapping("/av/hello")
    public String helloWorld(){
        JavbooksPobj pobj=jbd.select("k2");
        return "hello world "+pobj.getMyvalue();
    }
    @RequestMapping("/timer/{duration}")
    public String withTimer(@PathVariable("duration")int duration) throws TimeoutException, ExecutionException, InterruptedException {
        Future<String>future=MyUtil.globalThreadPool
                .submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int a=~(1<<31);
                while(a>0){
                    int b=1;
                    a-=1;
                }
                String res="I am call down";
                System.out.println(res);
                return res;
            }
        });
       // new Thread(future).start();
        String res=future.get(duration,TimeUnit.MILLISECONDS);
        return res;
    }
}

