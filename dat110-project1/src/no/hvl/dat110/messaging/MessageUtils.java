package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

    public static final int SEGMENTSIZE = 128;

    public static final int MESSAGINGPORT = 8080;
    public static final String MESSAGINGHOST = "localhost";

    public static byte[] encapsulate(Message message) {

        // TODO - START

        // encapulate/encode the payload data of the message and form a segment
        // according to the segment format for the messagin layer


        byte[] segment = new byte[SEGMENTSIZE];
        byte[] data = message.getData();
        segment[0] = (byte) data.length;
        //payload
        for (int i = 0; i < data.length; i++) {
            segment[i + 1] = data[i];
        }
        //padding
        for (int i = data.length + 1; i < SEGMENTSIZE; i++) {
            segment[i] = (byte) 0;
        }

        // TODO - END
        return segment;

    }

    public static Message decapsulate(byte[] segment) {

        Message message = null;

        // TODO - START
        // decapsulate segment and put received data into a message

        //Helper array for housing the payload
        byte[] payload = new byte[segment[0]];
        //decapsulation
        for (int i = 0; i < segment[0]; i++) {
            payload[i] = segment[i + 1];
        }
        //creates the decapsulated message
        message = new Message(payload);

        // TODO - END

        return message;

    }

}
