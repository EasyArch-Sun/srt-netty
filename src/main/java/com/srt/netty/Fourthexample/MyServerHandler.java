package com.srt.netty.Fourthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent=(IdleStateEvent)evt;

            String everyType=null;

            switch (idleStateEvent.state()){
                case READER_IDLE:
                    everyType="读空闲";
                    break;
                case WRITER_IDLE:
                    everyType="写空闲";
                    break;
                case ALL_IDLE:
                    everyType="读写空闲";
                    break;
            }

            System.out.println(ctx.channel().remoteAddress()+"超时事件:"+everyType);

            ctx.channel().close();
        }

    }
}
