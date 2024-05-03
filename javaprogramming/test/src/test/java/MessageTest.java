import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import com.nhnacademy.Message;

public class MessageTest {
    Message testMessage = new Message( "info");

    @Test
    void MessageTest_messageConfirm() {
        assertEquals(testMessage, testMessage.getInfo() );
    }

    private static class testMessage extends Message {
        public testMessage(String info) {
            super(info);
        }
    } 
    
}
