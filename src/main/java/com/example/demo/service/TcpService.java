package com.example.demo.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.generator.UUIDGenerator;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@Slf4j
public class TcpService {

    public void sendMsg() throws InterruptedException {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            //创建bootstrap对象，配置参数
            Bootstrap bootstrap = new Bootstrap();

            //设置线程组
            bootstrap.group(eventExecutors)
                    //设置客户端的通道实现类型
                    .channel(NioSocketChannel.class)
                    //使用匿名内部类初始化通道
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            MyClientHandler myClientHandler = new MyClientHandler();
                            //添加客户端通道的处理器
                            ch.pipeline().addLast(myClientHandler);
                            //myClientHandler.beforeAdd(channelHandlerContext);
                           myClientHandler.sendTcpMsg(createMsg());
                        }
                    });
            System.out.println("客户端准备就绪，随时可以起飞~");

            //连接服务端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 10010).sync();
            //对通道关闭进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            //关闭线程组
            eventExecutors.shutdownGracefully();
        }

    }

   public String createMsg() throws UnsupportedEncodingException {
       Document document = DocumentHelper.createDocument();
       document.setXMLEncoding("gb2312");
       Element ap = document.addElement("ap");
       Element head = ap.addElement("head");
       Element trCode = head.addElement("tr_code");
       Element reqNo = head.addElement("req_no");
       Element trAcdt = head.addElement("tr_acdt");
       Element trTime = head.addElement("tr_time");
       Element channel = head.addElement("channel");
       Element sign = head.addElement("sign");
       Element fileFlag = head.addElement("file_flag");
       trCode.setText("00003040102A0105");
       reqNo.setText(UUID.fastUUID().toString().replace("-",""));
       trAcdt.setText(DateUtil.format(new Date(),"yyyyMMdd"));
       trTime.setText(DateUtil.format(DateTime.now(),"HHmmss"));
       channel.setText("18");
       sign.setText("0");
       fileFlag.setText("0");
       Element body = ap.addElement("body");
       Element acctNo = body.addElement("acctNo");
       Element currency = body.addElement("currency");
       Element asacNo = body.addElement("asacNo");
       Element startDate = body.addElement("startDate");
       Element endDate = body.addElement("endDate");
       acctNo.setText("29130188000076607");
       currency.setText("01");
       asacNo.setText("00000003");
       startDate.setText("20200101");
       endDate.setText("20220401");

       String msg="00"+document.asXML().replace("<?xml version=\"1.0\" encoding=\"gb2312\"?>","").replace("\n","");
       String encoding = System.getProperty("file.encoding");
       log.info(encoding);
       int length = msg.getBytes("gbk").length;
       log.info("len:{}",length);
       log.info("lenq1:{}",msg.length());
       String headString = String.format("%010d", length);
       String result=headString+msg;
       log.info(result);
       return result;
   }
}
