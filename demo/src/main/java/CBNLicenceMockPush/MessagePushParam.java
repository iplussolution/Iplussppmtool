package CBNLicenceMockPush;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

public class MessagePushParam {


    //private long ID;


    private long pfiNumber;

    private long baNumber;

    private long mfNumber;

    private long formNumber;



    public MessagePushParam()
    {

    }

    public long getPfiNumber() {
        return pfiNumber;
    }

    public void setPfiNumber(long pfiNumber) {
        this.pfiNumber = pfiNumber;
    }

    public long getBaNumber() {
        return baNumber;
    }

    public void setBaNumber(long baNumber) {
        this.baNumber = baNumber;
    }

    public long getMfNumber() {
        return mfNumber;
    }

    public void setMfNumber(long mfNumber) {
        this.mfNumber = mfNumber;
    }

    public long getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(long formNumber) {
        this.formNumber = formNumber;
    }
}
