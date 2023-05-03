package formsmock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PushApplication {

    public static void main(String[] args) {

        ApplicationContext ctx =SpringApplication.run(PushApplication.class, args);

     //   JmsTemplate jms = ctx.getBean(JmsTemplate.class);
     //   jms.convertAndSend("javainuse", "test message");
    }

}
