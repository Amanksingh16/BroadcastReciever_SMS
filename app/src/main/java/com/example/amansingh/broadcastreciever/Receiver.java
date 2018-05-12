package com.example.amansingh.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
        String action = intent.getAction();
        String message;
        if(action.equals("android.provider.Telephony.SMS_RECEIVED"))
        {
            SmsMessage[] smsManager = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            message = smsManager[0].getMessageBody();
            Intent i = new Intent(context,MainActivity.class);
            i.putExtra("msg",""+message);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
