package leftpad.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PadPublisher extends TextWebSocketHandler {
	private final List<WebSocketSession> sessions = new ArrayList<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Socket opened");
		sessions.add(session);
		super.afterConnectionEstablished(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("Socket closed");
		sessions.remove(session);
		super.afterConnectionClosed(session, status);
	}

	public void sendMessage(String input, String output) {
		Map<String, String> data = new HashMap<>();
		data.put("input", input);
		data.put("output", output);
		ObjectMapper mapper = new ObjectMapper();
		String json;

		try {
			json = mapper.writeValueAsString(data);
		} catch (JsonProcessingException e1) {
			throw new RuntimeException(e1);
		}

		try {
			for (WebSocketSession session : sessions) {
				session.sendMessage(new TextMessage(json));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
