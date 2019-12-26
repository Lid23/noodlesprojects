package com.noodles.netty.io.pool;

/**
 * @filename NettyClientHander
 * @description NettyClientHander
 * @author 巫威
 * @date 2019/12/10 9:07
 */
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.atomic.AtomicInteger;

public class NettyClientHander extends ChannelInboundHandlerAdapter {
	static AtomicInteger count = new AtomicInteger(1);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println(count.getAndIncrement() + ":" + msg);
	}
}

