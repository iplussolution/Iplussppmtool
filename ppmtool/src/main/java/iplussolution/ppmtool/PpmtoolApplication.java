package iplussolution.ppmtool;

import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class PpmtoolApplication {

    public static void main(String[] args) {

        SpringApplication.run(PpmtoolApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("smartTradeDemoRequestDev");
    }
}
