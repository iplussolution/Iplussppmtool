package CBNLicenceMockPush;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class FormsPusher {

    public static void main(String[] args) {

     //   ApplicationContext ctx =
                SpringApplication.run(FormsPusher.class, args);

      //     JmsTemplate jms = ctx.getBean(JmsTemplate.class);
      //     jms.convertAndSend("javainuse", "test message");
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("smartTradeDemoRequestDev");
    }

}
