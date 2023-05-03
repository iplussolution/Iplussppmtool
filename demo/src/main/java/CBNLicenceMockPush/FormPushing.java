package CBNLicenceMockPush;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import java.util.Locale;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

@Service
public class FormPushing {//implements CommandLineRunner {
    String message = null;
    long PFISeries = 0;
    long BASeries = 0;
    long MFSeries = 0;
    long formNumber = 0;


    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public String pushMessage(MessagePushParam ser){
        try {

            MFSeries = ser.getMfNumber();
            PFISeries = ser.getPfiNumber();
            BASeries = ser.getBaNumber();
            formNumber = ser.getFormNumber();

            System.out.println(MFSeries+": MFSeries");
            System.out.println(PFISeries+": PFI Series");
            System.out.println(BASeries+": BA Series");
            System.out.println(formNumber+": Form Number");

            for(int x=0; x<formNumber; x++) {
                MFSeries++;
                PFISeries++;
                BASeries++;

                message = "{\n" +
                        "  \"id\": 52358,\n" +
                        "  \"formSubmit\": true,\n" +
                        "  \"applicationNumber\": \"MF\" " + MFSeries + ",\n" +
                        "  \"applicantRepresentative\": \"UBA Bank Plc 002 TEST\",\n" +
                        "  \"authorizationDate\": \"2021-06-29\",\n" +
                        "  \"authorizationReperesentative\": \"UBA Bank Plc 001 TEST\",\n" +
                        "  \"applicantTin\": \"1000438893\",\n" +
                        "  \"bankBranch\": \"33150037\",\n" +
                        "  \"bankCode\": \"033\",\n" +
                        "  \"bankNumbering\": " + BASeries + ",\n" +
                        "  \"beneficiaryAddress\": \"BLOCK 1, UNIT 180, AIRSIDE BUSINESS PARK, DUBLIN, \",\n" +
                        "  \"beneficiaryCountryCode\": \"IE\",\n" +
                        "  \"beneficiaryCountryName\": \"Ireland\",\n" +
                        "  \"beneficiaryEmail\": \"ANNA.BUCKETT@NCR.COM\",\n" +
                        "  \"beneficiaryFax\": \"+44-1382-400628\",\n" +
                        "  \"beneficiaryName\": \"ISW Test\",\n" +
                        "  \"beneficiaryPhone\": \"+44-1382-592362\",\n" +
                        "  \"createdAt\": \"2021-07-05 00:02:17.23\",\n" +
                        "  \"expiryDate\": \"2022-06-24\",\n" +
                        "  \"formNumber\": \"BA\"" + BASeries + ",\n" +
                        "  \"formType\": \"IM\",\n" +
                        "  \"inspectionAgentCode\": \"DI77009             \",\n" +
                        "  \"inspectionAgentName\": \"NCS\",\n" +
                        "  \"status\": \"Submitted\",\n" +
                        "  \"bankStatus\": \"PENDING_VALIDATION\",\n" +
                        "  \"attachmentsStatus\": \"COMPLETED\",\n" +
                        "  \"goodsStatus\": \"PROHIBITED_KEY\",\n" +
                        "  \"proformaStatus\": \"VALID\",\n" +
                        "  \"processingStage\": \"SUBMIT\",\n" +
                        "  \"enrichmentStatus\": \"COMPLETED\",\n" +
                        "  \"goodsDetailsStatus\": \"VALID\",\n" +
                        "  \"tiPostingStage\": \"REGISTRATION_CHARGES_POSTED\",\n" +
                        "  \"rmEmail\": \"charles.elimuya@gmail.com\",\n" +
                        "  \"applicantEmail\": \"charles.elimuya@gmail.com\",\n" +
                        "  \"bmEmail\": \"lewis.elimuya@gmail.com\",\n" +
                        "  \"bomEmail\": \"charles.elimuya@gmail.com\",\n" +
                        "  \"previousState\": \"UNDEFINED\",\n" +
                        "  \"previousStage\": \"UNDEFINED\",\n" +
                        "  \"replacementId\": 0,\n" +
                        "  \"forexStatus\": true,\n" +
                        "  \"accountNumber\": \"2008799909\",\n" +
                        "  \"accountName\": \"Okido In\",\n" +
                        "  \"missingEnrichment\": [],\n" +
                        "  \"attachments\": {\n" +
                        "    \"incomplete\": false,\n" +
                        "    \"bypassed\": false,\n" +
                        "    \"awaitingByPass\": false,\n" +
                        "    \"formAttachment\": [],\n" +
                        "    \"formInfoId\": 0,\n" +
                        "    \"auditableId\": 0\n" +
                        "  },\n" +
                        "  \"formSupportInformations\": [\n" +
                        "    {\n" +
                        "      \"id\": 87366,\n" +
                        "      \"actor\": \"UBA Bank Plc 002 TEST ( UBA Bank Plc )\",\n" +
                        "      \"date\": \"2018-08-31 14:42:23.0950000\",\n" +
                        "      \"message\": \"\",\n" +
                        "      \"operation\": \"Submit\",\n" +
                        "      \"formInfoId\": 52358,\n" +
                        "      \"allow\": false,\n" +
                        "      \"bankCode\": \"033\",\n" +
                        "      \"auditableId\": 87366\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 87367,\n" +
                        "      \"actor\": \"UBA Bank Plc 001 TEST ( UBA Bank Plc )\",\n" +
                        "      \"date\": \"2021-06-29 10:44:40.2270000\",\n" +
                        "      \"message\": \"\",\n" +
                        "      \"operation\": \"Validate\",\n" +
                        "      \"formInfoId\": 52358,\n" +
                        "      \"allow\": false,\n" +
                        "      \"bankCode\": \"033\",\n" +
                        "      \"auditableId\": 87367\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"availableTemplates\": [],\n" +
                        "  \"headOfficer\": false,\n" +
                        "  \"formAmount\": \"159000\",\n" +
                        "  \"paymentModeCode\": \"26                                                \",\n" +
                        "  \"currency\": \"USD                                               \",\n" +
                        "  \"applicantName\": \"LORIEN GLOBAL CO LTD\",\n" +
                        "  \"paymentModeName\": \"Letters of Credit\",\n" +
                        "  \"shippingDetails\": false,\n" +
                        "  \"queue\": false,\n" +
                        "  \"mailDiscrepancies\": [],\n" +
                        "  \"report\": false,\n" +
                        "  \"branchCode\": \"33152666\",\n" +
                        "  \"branch\": {\n" +
                        "    \"name\": \"Oko Awo Branch\",\n" +
                        "    \"id\": 2324,\n" +
                        "    \"code\": \"33150037\",\n" +
                        "    \"address\": \"15B Oko Awo Street\",\n" +
                        "    \"email\": \"samuel.idaewor@interswitchgroup.com,lateefah.abdulkareem@interswitchgroup.com,oluwaseyi.obatolu@inte\",\n" +
                        "    \"status\": true,\n" +
                        "    \"tenantId\": 1398,\n" +
                        "    \"solId\": false\n" +
                        "  },\n" +
                        "  \"branchId\": 2324,\n" +
                        "  \"xmlToTI\": [],\n" +
                        "  \"approvalsAwaitingAction\": [],\n" +
                        "  \"formApplicant\": {\n" +
                        "    \"id\": 2625,\n" +
                        "    \"applicantAddress\": \"PLOT H, BLOCK 3, OSHODI/\\nOWORONSHOKI EXPRESSWAY, ILUPEJU,\\nLAGOS, LAGOS, SHOMOLU, LAGOS\",\n" +
                        "    \"applicantCityCode\": \"LAGOS\",\n" +
                        "    \"applicantEmail\": \"acustodio@webbfontaine.com\",\n" +
                        "    \"applicantFax\": \"10002026-0001\",\n" +
                        "    \"applicantName\": \"LORIEN GLOBAL CO LTD\",\n" +
                        "    \"applicantPhone\": \"08093851540\",\n" +
                        "    \"applicantRcNumber\": \"RC155007\",\n" +
                        "    \"applicantStateCode\": \"15\",\n" +
                        "    \"applicantStateName\": \"LAGOS\",\n" +
                        "    \"applicantTin\": \"1000438893\",\n" +
                        "    \"bankCode\": \"033\",\n" +
                        "    \"auditableId\": 2625\n" +
                        "  },\n" +
                        "  \"shippingDocumentDetailsList\": [],\n" +
                        "  \"formGoodsDetails\": {\n" +
                        "    \"id\": 41918,\n" +
                        "    \"createdAt\": \"2021-07-05 00:02:17.443\",\n" +
                        "    \"currencyCode\": \"USD  \",\n" +
                        "    \"currencyName\": \"United States Dollar\",\n" +
                        "    \"customOfficeCode\": \"01AP \",\n" +
                        "    \"customOfficeName\": \"APAPA PORT\",\n" +
                        "    \"description\": \"CHICKEN\",\n" +
                        "    \"dischargePortCode\": \"NGAPP\",\n" +
                        "    \"dischargePortName\": \"Apapa\",\n" +
                        "    \"exchangeRate\": \"155.8\",\n" +
                        "    \"insuranceCost\": \"645694901.61\",\n" +
                        "    \"modeOfTransportCode\": \"1    \",\n" +
                        "    \"modeOfTransportName\": \"Sea transport\",\n" +
                        "    \"paymentModeCode\": \"26   \",\n" +
                        "    \"paymentModeName\": \"Letters of Credit\",\n" +
                        "    \"proformaInvDate\": \"2018-08-02\",\n" +
                        "    \"proformaInvNumber\": \"PF31-\"" + PFISeries + ",\n" +
                        "    \"bankCode\": \"033\",\n" +
                        "    \"sourceOfFundsCode\": \"BID  \",\n" +
                        "    \"sourceOfFundsName\": \"C.B.N FUNDS\",\n" +
                        "    \"supplyCountryCode\": \"IN   \",\n" +
                        "    \"supplyCountryName\": \"India\",\n" +
                        "    \"termOfDeliveryCode\": \"IN   \",\n" +
                        "    \"totalAncilaryCharges\": \"2000\",\n" +
                        "    \"totalCfValue\": \"159000\",\n" +
                        "    \"totalFobValue\": \"129000\",\n" +
                        "    \"proformaStatus\": \"VALID\",\n" +
                        "    \"totalFreightCharges\": \"30000\",\n" +
                        "    \"totalItems\": 1,\n" +
                        "    \"totalNetWeight\": \"0\",\n" +
                        "    \"transferModeCode\": \"CFR  \",\n" +
                        "    \"formInfoId\": 52358,\n" +
                        "    \"formGoods\": [\n" +
                        "      {\n" +
                        "        \"id\": 41918,\n" +
                        "        \"countryOfOriginCode\": \"IN  \",\n" +
                        "        \"description\": \"CHICKEN\",\n" +
                        "        \"fobValue\": \"127000\",\n" +
                        "        \"freightCharges\": \"30000\",\n" +
                        "        \"bankCode\": \"033\",\n" +
                        "        \"hsCode\": \"8472900000\",\n" +
                        "        \"numberOfPackages\": 50,\n" +
                        "        \"packageTypeCode\": \"U    \",\n" +
                        "        \"quantity\": \"50\",\n" +
                        "        \"sectorialPurposeCode\": \"N1409\",\n" +
                        "        \"stateOfGoodsCode\": \"U  \",\n" +
                        "        \"unitCode\": \"U    \",\n" +
                        "        \"goodStatus\": \"VALID\",\n" +
                        "        \"unitPrice\": \"2540\",\n" +
                        "        \"formGoodsDetailId\": 0,\n" +
                        "        \"auditableId\": 41918\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 41918,\n" +
                        "        \"countryOfOriginCode\": \"IN  \",\n" +
                        "        \"description\": \"CHICKEN\",\n" +
                        "        \"fobValue\": \"127000\",\n" +
                        "        \"freightCharges\": \"30000\",\n" +
                        "        \"bankCode\": \"033\",\n" +
                        "        \"hsCode\": \"8472900000\",\n" +
                        "        \"numberOfPackages\": 50,\n" +
                        "        \"packageTypeCode\": \"U    \",\n" +
                        "        \"quantity\": \"50\",\n" +
                        "        \"sectorialPurposeCode\": \"N1409\",\n" +
                        "        \"stateOfGoodsCode\": \"U  \",\n" +
                        "        \"unitCode\": \"U    \",\n" +
                        "        \"goodStatus\": \"PROHIBITED\",\n" +
                        "        \"unitPrice\": \"2540\",\n" +
                        "        \"formGoodsDetailId\": 0,\n" +
                        "        \"auditableId\": 41918\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"auditableId\": 41918\n" +
                        "  },\n" +
                        "  \"auditableId\": 52358\n" +
                        "}";


                 this.jmsMessagingTemplate.convertAndSend(this.queue, message);
          /*      jmsTemplate.send("smartTradeDemoRequestDev", new MessageCreator() {
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage( message);
                    }      }); */
                System.out.println(formNumber + ": Form sent to queue");


            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }



}

