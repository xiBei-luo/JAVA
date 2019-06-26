package com.luo.crawler;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Created by Luowenlv on 2019/3/18,15:17
 */
public class SelectSocket {
    public static int PORT_NUMBER = 1234;
    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
    public static void main(String[] args) throws Exception {
        new SelectSocket().go(args);
    }
    public void go(String[] args) throws Exception{
        int port = PORT_NUMBER;
        if (args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        System.out.println("listening on port:" + port);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        Selector selector = Selector.open();
        serverSocket.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while(true){
            int n = selector.select();
            if( n== 0){
                continue;
            }
            Iterator iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                if(selectionKey.isAcceptable()){
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    regiterChannel(selector, socketChannel,SelectionKey.OP_READ);
                    sayHello(socketChannel);
                }
                if (selectionKey.isReadable()){
                    readDataFromSocket(selectionKey);
                }
                iterator.remove();

            }
        }
    }


    protected void regiterChannel(Selector selector, SelectableChannel channel,int op) throws Exception{
        if (channel == null){
            return;
        }
        channel.configureBlocking(false);
        channel.register(selector, op);
    }
    protected void readDataFromSocket(SelectionKey selectionKey) throws Exception{
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        int count;
        buffer.clear();
        while((count = socketChannel.read(buffer)) > 0){
            buffer.flip();
            while (buffer.hasRemaining()){
                socketChannel.write(buffer);
            }
            buffer.clear();
        }
        if (count < 0){
            socketChannel.close();
        }
    }
    private void sayHello(SocketChannel channel) throws Exception{
        buffer.clear();
        buffer.put("Hi there\r\n".getBytes());
        buffer.flip();
        channel.write(buffer);
    }
}
