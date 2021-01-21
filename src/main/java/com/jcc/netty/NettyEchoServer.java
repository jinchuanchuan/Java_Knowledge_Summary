package com.jcc.netty;

//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.ChannelPipeline;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.example.echo.EchoServerHandler;
//import io.netty.handler.logging.LogLevel;
//import io.netty.handler.logging.LoggingHandler;

/**
 * @program: javaknowledge->NettyEchoServer
 * @description: echo demo
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-14 00:06
 **/
//public class NettyEchoServer {
//    public static void main(String[] args) {
//        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//
//        try {
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(bossGroup,workerGroup)
//                .channel(NioServerSocketChannel.class)
//                .option(ChannelOption.SO_BACKLOG, 100)
//                .handler(new LoggingHandler(LogLevel.INFO))
//                .childHandler(new ChannelInitializer<SocketChannel>() {
//                    @Override
//                    protected void initChannel(SocketChannel ch) throws Exception {
//                        ChannelPipeline p = ch.pipeline();
//                        p.addLast(new LoggingHandler(LogLevel.INFO));
//                        p.addLast(new EchoServerHandler());
//                    }
//                });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
