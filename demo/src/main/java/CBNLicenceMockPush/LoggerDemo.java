package CBNLicenceMockPush;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDemo {

    private static final Logger logger
            = LoggerFactory.getLogger(LoggerDemo.class);

    private static final ch.qos.logback.classic.Logger parentLogger =
            (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("CBNLicenceMockPush");

    private static final ch.qos.logback.classic.Logger parentLogger2 =
            (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("RollingFileTest");

 //   public static void main(String[] args) {
 //       parentLogger2.warn("Example log from {}", LoggerDemo.class.getSimpleName());
  //  }
}
