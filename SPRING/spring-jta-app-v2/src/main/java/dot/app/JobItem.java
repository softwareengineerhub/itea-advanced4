package dot.app;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobItem {

    @Scheduled(cron = "*/10 * * * * ?")
    public void sendMail(){
        System.out.println("send email");
    }
}
