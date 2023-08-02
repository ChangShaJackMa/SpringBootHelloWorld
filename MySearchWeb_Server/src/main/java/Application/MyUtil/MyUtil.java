package Application.MyUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyUtil {
    public static final ExecutorService globalThreadPool=new ThreadPoolExecutor(50, 200,5,
            TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
    public static AtomicInteger Tokens =new AtomicInteger(200);

}
