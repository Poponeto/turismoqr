/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

/**
 *
 * @author Chelo
 */
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener {


    public void onApplicationEvent(ApplicationEvent event) {
       if(event instanceof MessageEvent) {
           MessageEvent msgEvt = (MessageEvent)event;
           System.out.println("Received: " + msgEvt.getMessage());
       }
    }

}
