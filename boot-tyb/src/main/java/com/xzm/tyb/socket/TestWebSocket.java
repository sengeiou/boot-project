//package com.xzm.modules.tyb.socket;
//
///**
// * Created by Administrator on 2016/8/7.
// */
//
//import org.apache.log4j.Logger;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.server.standard.SpringConfigurator;
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//
////该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。
//
///**
// * ws://192.168.56.1:8080/testwebsocket
// * 127.0.0.1
// * ws://127.0.0.1:8080/testwebsocket
// * 类似Servlet的注解mapping。无需在web.xml中配置。
// * configurator = SpringConfigurator.class是为了使该类可以通过Spring注入。
// */
////@Configuration
//@ServerEndpoint(value = "/testwebsocket")
//@Component
//public class TestWebSocket {
//    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
//    private Logger logger = Logger.getLogger(TestWebSocket.class);
//    private static int onlineCount = 0;
//
//    public TestWebSocket() {
//    }
//
////    @Autowired
////    private ContentService contentService ;
//
//    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
//    // 若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
////    private static CopyOnWriteArraySet<TestWebSocket> webSocketSet = new CopyOnWriteArraySet<>();
//
//    private static Map<String, TestWebSocket> webSocketSet = new HashMap<>();
//    //与客户端的连接会话，需要通过它来给客户端发送数据
//    private Session session;
//
//    /**
//     * 连接建立成功调用的方法
//     *
//     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
//     */
//    @OnOpen
//    public void onOpen(Session session) {
//        this.session = session;
////        webSocketSet.add(this);     //加入set中
//        webSocketSet.put("key", this);
//        addOnlineCount();           //在线数加1
//        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
//    }
//
//    /**
//     * 连接关闭调用的方法
//     */
//    @OnClose
//    public void onClose() {
//        webSocketSet.remove(this);  //从set中删除
//        subOnlineCount();           //在线数减1
//        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
//    }
//
//    /**
//     * 收到客户端消息后调用的方法
//     *
//     * @param message 客户端发送过来的消息
//     * @param session 可选的参数
//     */
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        System.out.println("来自客户端的消息:" + message);
//        //群发消息
//
////        for(TestWebSocket item: webSocketSet){
////            try {
////                item.sendMessage(message);
////            } catch (IOException e) {
////                e.printStackTrace();
////                continue;
////            }
////        }
//    }
//
//    /**
//     * 发生错误时调用
//     *
//     * @param session
//     * @param error
//     */
//    @OnError
//    public void onError(Session session, Throwable error) {
//        System.out.println("发生错误");
//        error.printStackTrace();
//    }
//
//    /**
//     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
//     *
//     * @param message
//     * @throws IOException
//     */
//    public void sendMessage(String message) throws IOException {
////        //保存数据到数据库
////        Content content = new Content() ;
////        content.setContent(message);
////        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd") ;
////        content.setCreatedate(sm.format(new Date()));
////        contentService.insertSelective(content) ;
//
//        this.session.getBasicRemote().sendText(message);
//        //this.session.getAsyncRemote().sendText(message);
//
//
//    }
//
//    public static synchronized int getOnlineCount() {
//        return onlineCount;
//    }
//
//    public static synchronized void addOnlineCount() {
//        TestWebSocket.onlineCount++;
//    }
//
//    public static synchronized void subOnlineCount() {
//        TestWebSocket.onlineCount--;
//    }
//
//    private void test() {
//        Map<String, TestWebSocket> map = new HashMap<>();
//        if (map != null) {
//            Set<String> keySet = map.keySet();
//            String iconurl = new String();
//            for (String string : keySet) {
//                logger.debug("=====" + string);
//                if (string.equals("profile_image_url")) {
//                    TestWebSocket profileImageUrl = map.get("profile_image_url");
//                }
//            }
//        }
//    }
//
//
//    public static Map<String, TestWebSocket> getWebSocket() {
//        return webSocketSet;
//    }
//
//}
