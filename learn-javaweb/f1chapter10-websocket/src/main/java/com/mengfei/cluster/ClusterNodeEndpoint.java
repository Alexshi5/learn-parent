package com.mengfei.cluster;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * author Alex
 * date 2018/12/23
 * description WebSocket通信的服务终端
 * 服务端使用了Java序列化器发送和接收ClusterMessage，此时WebSocket消息必须是二进制的。Java序列化器比Json更快，
 * 所以最好使用Java序列化器，前提是两个终端都采用Java编写时才可以使用，如果只有一个节点是Java，那么就只能使用其
 * 他方式了，比如：Json
 *
 * 服务器终端唯一的责任是将一个节点发送过来的信息再发送到所有其他节点中，并在其他节点加入或离开集群时进行广播。当
 * 然，在不同的需求中有不同的连接模型，可以用中央终端发送和接收消息，也可以让每个节点直接与其他节点互联。
 */
@ServerEndpoint("/clusterNode/{nodeId}")
public class ClusterNodeEndpoint {
    private static final List<Session> nodes = new ArrayList<>(2);

    @OnOpen
    public void onOpen(Session session, @PathParam("nodeId") String nodeId){
        System.out.println("信息 - 节点" + nodeId + "连接到集群");
        ClusterMessage message = new ClusterMessage(nodeId,"节点" + nodeId + "加入集群");
        try {
            byte[] bytes = ClusterNodeEndpoint.toByteArray(message);
            //有新的节点加入集群时进行广播
            for (Session node : ClusterNodeEndpoint.nodes){
                node.getBasicRemote().sendBinary(ByteBuffer.wrap(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将新的节点session加入集合
        ClusterNodeEndpoint.nodes.add(session);
    }

    @OnMessage
    public void onMessage(Session session,byte[] bytes){
        try {
            //有新的消息时，对除了它自己之外的所有节点进行广播
            for (Session node : ClusterNodeEndpoint.nodes){
                if(node != session){
                    node.getBasicRemote().sendBinary(ByteBuffer.wrap(bytes));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session,@PathParam("nodeId") String nodeId){
        System.out.println("信息 - 节点" + nodeId + "断开连接");
        //将断开连接的节点移除集合
        ClusterNodeEndpoint.nodes.remove(session);
        ClusterMessage message = new ClusterMessage(nodeId,"节点" + nodeId + "离开集群");
        try {
            byte[] bytes = ClusterNodeEndpoint.toByteArray(message);
            //有新的节点离开集群时也要进行广播
            for (Session node : ClusterNodeEndpoint.nodes){
                node.getBasicRemote().sendBinary(ByteBuffer.wrap(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 转换字节数组
     * @param message
     * @return
     * @throws IOException
     */
    private static byte[] toByteArray(ClusterMessage message) throws IOException{
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ObjectOutputStream outputStream = new ObjectOutputStream(output)) {
            outputStream.writeObject(message);
            return output.toByteArray();
        }
    }
}
