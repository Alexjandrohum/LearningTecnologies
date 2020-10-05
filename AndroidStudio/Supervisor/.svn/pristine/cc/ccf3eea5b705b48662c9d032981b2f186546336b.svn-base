package com.grupopakar.grupopakarapp.service;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.grupopakar.grupopakarapp.util.Factory;
import com.grupopakar.grupopakarapp.util.SessionManager;
import com.grupopakar.grupopakarapp.ws.DispositivoWS;

import java.io.IOException;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * Created by antonio.ruiz on 2019-05-20
 */
public class MessagingService extends FirebaseMessagingService {

    @Override
    public void onCreate() {
//        LocalBroadcastManager broadcaster = LocalBroadcastManager.getInstance(this);
    }

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // [START_EXCLUDE]
        // There are two types of messages data messages and notification messages. Data messages are handled
        // here in onMessageReceived whether the app is in the foreground or background. Data messages are the type
        // traditionally used with GCM. Notification messages are only received here in onMessageReceived when the app
        // is in the foreground. When the app is in the background an automatically generated notification is displayed.
        // When the user taps on the notification they are returned to the app. Messages containing both notification
        // and data payloads are treated as notification messages. The Firebase console always sends notification
        // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
        // [END_EXCLUDE]

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(MessagingService.class.getName(), "From: " + remoteMessage.getFrom());

        /*// Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            if (*//* Check if data needs to be processed by long running job *//* true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                scheduleJob();
            } else {
                // Handle message within 10 seconds
                handleNow();
            }

        }*/

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(MessagingService.class.getName(), "Message Notification Body: " + remoteMessage.getNotification().getBody());
            Log.e(TAG, "onMessageReceived: " + remoteMessage.getData());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
    // [END receive_message]

    // [START on_new_token]

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    @Override
    public void onNewToken(String token) {
        Log.d(MessagingService.class.getName(), "Refreshed token: " + token);
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        if (token != null && !token.isEmpty()) sendRegistrationToServer(token);
    }
    // [END on_new_token]

    /**
     * Persist token to third-party servers.
     * <p>
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        DispositivoWS ws = (DispositivoWS) Factory.getWS(DispositivoWS.class);
        SessionManager session = new SessionManager(this);
        String idSocio = session.getToken();
        try {
            if (!idSocio.isEmpty()) {
                ws.registraToken(idSocio, token).execute();
            }
        } catch (IOException e) {
            Log.e(TAG, ".sendRegistrationToServer");
            e.printStackTrace();
        }
    }

}
