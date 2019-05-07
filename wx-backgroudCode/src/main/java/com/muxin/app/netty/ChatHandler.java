package com.muxin.app.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
        //用于记录和管理所有客户端的channle
        private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


        protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {

           String content = textWebSocketFrame.text();
           System.out.println("接收到的数据："+content);



//            for (Channel channel : clients) {
//                channel.writeAndFlush(new TextWebSocketFrame("[服务器在]"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"[接受到消息，消息为：]"+content));
//
//            }

            clients.writeAndFlush(new TextWebSocketFrame("[服务器在]"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"[接受到消息，消息为：]"+content));
        }

        /**
         *
         * 当客户端连接服务端之后（打开连接）
         * 获取客户端的channle 并且放到channelGroup中进行管理
         * @param ctx
         * @throws Exception
         */
        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            clients.add(ctx.channel());
        }

        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
            // clients.remove(ctx.channel());
            System.out.println("客户端断开长id:"+ctx.channel().id().asLongText());
            System.out.println("客户度断开短id:"+ctx.channel().id().asShortText());
        }


    }
