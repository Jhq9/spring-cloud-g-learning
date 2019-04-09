package may.i.jhq.websocketserver;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat")
    @SendTo("/toAll/may")
    public String say(MessageVO messageVO) {
        String result = null;
        if (messageVO != null) {
            result = messageVO.getUsername() + ":" + messageVO.getMessage();
        }

        return result;
    }

}
