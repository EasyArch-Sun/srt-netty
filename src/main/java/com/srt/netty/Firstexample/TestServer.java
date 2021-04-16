package com.srt.netty.Firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestServer {
    public static void main(String[] args) throws InterruptedException {
        //事件循环组
        EventLoopGroup bossGroup =new NioEventLoopGroup() ;      //从客户端接受连接不做别的  //nioeventloopgroup死循环
        EventLoopGroup workerGroup=new NioEventLoopGroup();      //处理请求

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();   //启动
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).
                    childHandler(new TestServerinitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
