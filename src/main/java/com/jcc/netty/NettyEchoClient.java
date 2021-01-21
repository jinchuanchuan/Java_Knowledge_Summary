package com.jcc.netty;

//import io.netty.bootstrap.Bootstrap;
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.ChannelPipeline;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.example.echo.EchoClientHandler;
//import io.netty.example.echo.EchoServerHandler;
//import io.netty.handler.logging.LogLevel;
//import io.netty.handler.logging.LoggingHandler;

/**
 * @program: javaknowledge->NettyEchoClient
 * @description: client
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-14 00:22
 **/
//public class NettyEchoClient {
//    public static void main(String[] args) {
//        EventLoopGroup group = new NioEventLoopGroup();
//        try {
//            Bootstrap b = new Bootstrap();
//            b.group(group)
//                .channel(NioSocketChannel.class)
//                .option(ChannelOption.SO_BACKLOG, 100)
//                .handler(new ChannelInitializer<SocketChannel>() {
//                    @Override
//                    protected void initChannel(SocketChannel ch) throws Exception {
//                        ChannelPipeline p = ch.pipeline();
//                        p.addLast(new LoggingHandler(LogLevel.INFO));
//                        p.addLast(new EchoClientHandler());
//                    }
//                });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
