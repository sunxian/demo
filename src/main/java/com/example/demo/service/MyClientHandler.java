package com.example.demo.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;

public class MyClientHandler extends ChannelInboundHandlerAdapter {

    private ChannelHandlerContext ctx;
    private ChannelPromise promise;
    private String message;
    private String data;

    public MyClientHandler(String msg) {
        this.message=msg;
    }

    public MyClientHandler() {

    }

    public String getData() {
        return data;
    }


    public void sendTcpMsg(String msg){
        TextWebSocketFrame textWebSocketFrame = new TextWebSocketFrame(msg);
       //ctx.writeAndFlush(Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8));
        ctx.writeAndFlush(textWebSocketFrame);
    }

    public ChannelPromise sendMessage(String message) throws Exception {
        System.out.println("---------------------执行sendMessage的线程"+Thread.currentThread());
        if (ctx == null) {
            throw new IllegalStateException();
        }
        ByteBuf encoded = ctx.alloc().buffer(4 * message.length());
        encoded.writeBytes(message.getBytes("GBK"));
        promise = ctx.writeAndFlush(encoded).channel().newPromise();
        return promise;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf encoded = ctx.alloc().buffer(4 * this.message.length());
        encoded.writeBytes(this.message.getBytes("GBK"));
        ctx.writeAndFlush(encoded);
        encoded.release();
    }

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf result = (ByteBuf) msg;
//        byte[] result1 = new byte[result.readableBytes()];
//        result.readBytes(result1);
//        data = new String(result1, "GBK");
//        result.release();
//    }



    @Override
    /*添加到pipeline时自动触发*/
    public void handlerAdded(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接收服务端发送过来的消息
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("收到服务端" + ctx.channel().remoteAddress() + "的消息：" + byteBuf.toString(CharsetUtil.UTF_8));

    }
}