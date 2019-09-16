package org.app;

import com.app.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SampleAppConfig.class);
        /*Engine engine = ctx.getBean(Engine.class);
        engine.doWork();
        System.out.println("---COMPLETED--");*/

        Engine engine = ctx.getBean(Engine.class);
        Future<String> future = engine.doWork2();
        String res = future.get();
        System.out.println("---COMPLETED: result "+res);

    }
}
