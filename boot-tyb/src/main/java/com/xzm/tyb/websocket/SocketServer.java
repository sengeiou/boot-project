package com.xzm.tyb.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ws://127.0.0.1:8083/tyb/socketServer/121
 */
@EnableWebSocket // 允许WebSocketSw
@ServerEndpoint(value = "/socketServer/{userid}")
@Component
public class SocketServer {

	private Session session;
	private static Map<String,Session> sessionPool = new HashMap<>();
	private static Map<String,String> sessionIds = new HashMap<>();

	/**
	 * 用户连接时触发
	 * @param session
	 * @param userid
	 */
	@OnOpen
	public void open(Session session, @PathParam(value="userid")String userid){
		System.out.println("==open==");
		this.session = session;
		sessionPool.put(userid, session);
		sessionIds.put(session.getId(), userid);
	}

	/**
	 * 收到信息时触发
	 * @param message
	 */
	@OnMessage
	public void onMessage(String message){
		System.out.println("==onMessage==");
		System.out.println("当前发送人sessionid为"+session.getId()+"发送内容为"+message);
	}

	/**
	 * 连接关闭触发
	 */
	@OnClose
	public void onClose(){
		System.out.println("==onClose==");
		sessionPool.remove(sessionIds.get(session.getId()));
		sessionIds.remove(session.getId());
	}

	/**
	 * 发生错误时触发
	 * @param session
	 * @param error
	 */
    @OnError
    public void onError(Session session, Throwable error) {
		System.out.println("==onError==");
        error.printStackTrace();
    }

	/**
	 *信息发送的方法
	 * @param message
	 * @param userId
	 */
	public static void sendMessage(String message,String userId){
		Session s = sessionPool.get(userId);
		if(s!=null){
			try {
				s.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取当前连接数
	 * @return
	 */
	public static int getOnlineNum(){
		return sessionPool.size();
	}

	/**
	 * 获取在线用户名以逗号隔开
	 * @return
	 */
	public static String getOnlineUsers(){
		StringBuffer users = new StringBuffer();
	    for (String key : sessionIds.keySet()) {
		   users.append(sessionIds.get(key)+",");
		}
	    return users.toString();
	}

	/**
	 * 信息群发
	 * @param msg
	 */
	public static void sendAll(String msg) {
		for (String key : sessionIds.keySet()) {
			sendMessage(msg, sessionIds.get(key));
	    }
//		webSocketService.sendAll(msg);
	}

	/**
	 * 多个人发送给指定的几个用户
	 * @param msg
	 * @param persons  用户s
	 */

	public static void SendMany(String msg,String [] persons) {
		for (String userid : persons) {
			sendMessage(msg, userid);
		}

	}
}
