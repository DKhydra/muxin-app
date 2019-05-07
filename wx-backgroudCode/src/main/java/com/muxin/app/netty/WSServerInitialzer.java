package com.muxin.app.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WSServerInitialzer extends ChannelInitializer<SocketChannel> {


    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline =socketChannel.pipeline();

        pipeline.addLast(new HttpServerCodec());
        // 对写大数据流
        pipeline.addLast(new ChunkedWriteHandler());
        // 对httpMessage进行聚合，聚合成fullHttpRequest或FullHttpResponse
        pipeline.addLast(new HttpObjectAggregator(1024*64));

        //=====================以上对http支持===================

        //websocket 服务器处理的协议，用于指定给客户端连接访问的路由
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        pipeline.addLast(new ChatHandler());

    }
}
