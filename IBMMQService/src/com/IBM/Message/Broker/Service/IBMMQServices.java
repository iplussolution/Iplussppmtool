package com.IBM.Message.Broker.Service;

import com.ibm.mq.jms.MQQueueConnectionFactory;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import com.ibm.mq.jms.JMSC;

public class IBMMQServices {

    QueueReceiver receiver;
    QueueConnection queueConnection;
    QueueSession queueSession;
    Queue queue;
    MQQueueConnectionFactory mqcf ;
    TextMessage textMessage;

    public IBMMQServices() throws JMSException {

        mqcf = new MQQueueConnectionFactory();
        //Get The host name or IP from Config file
        mqcf.setHostName("10.8.2.163");
        //Get the created channel name for Config file
        mqcf.setChannel("TRADECH");
        //Get The port number from Config file
        mqcf.setPort(1414);
        //Get The queue manager from Config file
        mqcf.setQueueManager("TRADEMQMGR");
        mqcf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
        //Get The username and password from Config file
        queueConnection =	mqcf.createQueueConnection("wasadmin","wasadmin123");

        queueSession = queueConnection.createQueueSession(true, 1);
        queueConnection.start();

    }

    public void sendMessage() throws JMSException {
        queue = queueSession.createQueue("formMRequestQueue");
        //Create  message
        textMessage = queueSession.createTextMessage(getRequestMsg());
        textMessage.setJMSDeliveryMode(DeliveryMode.PERSISTENT); //message delivery mode either persistent or non-persistemnt

        //***Create sender queue ***
        QueueSender queueSender = queueSession.createSender(queue);

        // Send Message
       queueSender.send(textMessage);

        System.out.println("### SEND(): text message called");
       System.out.println("after sending a message ");

    }

    public void receiveMessage() throws JMSException {

        /*Within the session we have to create queue receiver */
        queue = queueSession.createQueue("formMResponseQueue");
        new Thread(new Runnable()  {
            @Override
            public void run() {
               try {
                   QueueReceiver queueReceiver = queueSession.createReceiver(queue);
                   /*Receive the message from*/
                   Message message = queueReceiver.receive(1 * 1000);

                   System.out.println(message);


                   System.out.println("### RECEIVE_TIMEOUT(): called");

                   if (message == null) {
                       System.out.println("### RECEIVE_TIMEOUT(): message is null");
                   } else {
                       String responseMsg = ((TextMessage) message).getText();
                       System.out.println("### RECEIVE_TIMEOUT(): message received");
                       System.out.println(responseMsg);
                       // Pass the message to the method that will get the value and update response against form's record
                   }
               }
               catch(JMSException e){
                   e.printStackTrace();
                }

            }
        }).start();
    }




    //This is to mirror method returning message from Single Window
    public String getRequestMsg() {
      return "<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?><ServiceResponse xmlns=\\\"urn:control.services.tiplus2.misys.com\\\" xmlns:m=\\\"urn:messages.service.ti.apps.tiplus2.misys.com\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\"><ResponseHeader><Service>Account</Service><Operation>AvailBal</Operation><Status>SUCCEEDED</Status><Details><!--Error>Less Balance 2</Error><Warning/--><Info/></Details><CorrelationId>c2686014734aef2d:8c8c328:163a7dee3dd:-650a</CorrelationId><TargetSystem>RAKStub</TargetSystem><SourceSystem>ZONE3</SourceSystem></ResponseHeader><m:AvailBalResponse><m:Balance>000150000000000</m:Balance><m:Negative>false</m:Negative><m:Applies>true</m:Applies><!--m:Blocked>false</m:Blocked><m:ErrorCode/--><m:CheckedInBackOffice>false</m:CheckedInBackOffice><!--m:ErrorMessage>less balance</m:ErrorMessage><m:ErrorOrWarning>true</m:ErrorOrWarning--></m:AvailBalResponse></ServiceResponse>";
    }


}
