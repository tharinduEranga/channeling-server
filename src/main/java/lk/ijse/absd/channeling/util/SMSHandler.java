package lk.ijse.absd.channeling.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static lk.ijse.absd.channeling.util.Constants.TEXTFULLURL;

/**
 * Handles the texit.biz SMS related activities in here
 * <p>
 * Created By :- Tharindu Eranga
 * Date :- 2019-08-08 21:50:32
 * Intellij IDEA 2018.1.5
 */
public class SMSHandler {

    /**
     * @param mobile  number of the reciever
     * @param message for the sms to send
     * @return true if no exceptions occurred
     * @throws IOException if something went wrong
     */
    public static boolean sendSms(String mobile, String message) throws IOException {
        String smsUrl = TEXTFULLURL + "&to=" + mobile + "&text=" + message.replaceAll(" ", "+") + "";
        URL texTit = new URL(smsUrl);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(texTit.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
        return true;
    }

}
