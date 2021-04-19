package com.srt.netty.Thirdexample;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.logging.SocketHandler;

public class MychatClientHandler extends SimpleChannelInboundHandler<SocketHandler> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SocketHandler msg) throws Exception {

    }
}
