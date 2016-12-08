package medart.mygoodproject;

//import org.apache.harmony.xnet.provider.jsse.GMailSender;
import android.app.Activity;
import android.util.Log;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.MailTo;
import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MainActivity extends BroadcastReceiver{

    Context context;
    String email;
    String currentSimSerial;
    //SharedPreferences settings;
    SmsManager smsMgr = SmsManager.getDefault();
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    public void onReceive(Context context, Intent intent) {

     //   settings = context.getSharedPreferences(PREFS_NAME, 0);
        String storedSimSerial = MAinActivity2.serial;
        Log.d("Stored Sim Serial::",storedSimSerial);

        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        currentSimSerial = tm.getSimSerialNumber();
        Log.d("Current Sim Serial","::"+currentSimSerial);
        String trustedNum = MAinActivity2.mob;
        email = MAinActivity2.email;

        if(currentSimSerial == storedSimSerial){

        }else{
            Log.d("Sim changed","!!!");
            new GmailAsync().execute("");
            String sms = "Sim card has changed, " +
                    "Sim Serial Number of this card is\n"+currentSimSerial+
                    "Network Operator"+tm.getNetworkOperatorName();
            smsMgr.sendTextMessage(trustedNum, null,sms, null, null);
        }

       /* Intent sms = new Intent(context, SMSReceiver.class);
        sms.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(sms);

        Intent netAvailability = new Intent(context, CheckingNetworkAvailability.class);
        netAvailability.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(netAvailability);*/
    }
    public class GmailAsync extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            String mail_body = "Sim serial number is "+currentSimSerial;
            String subject = "Your Sim has changed!!!";
            GMailSender sender = new GMailSender("medhab31@gmail.com", "8877664279");
            try {
                sender.sendMail(subject, mail_body+"\nThanks for using Mobile Security App",
                        "medhab31@gmail.com",
                        MAinActivity2.email
                        );
            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            Log.d("Mail","Sent");
        }
    }
}
