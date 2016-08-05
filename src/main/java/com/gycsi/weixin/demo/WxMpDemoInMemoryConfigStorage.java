package com.gycsi.weixin.demo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import me.chanjar.weixin.common.util.xml.XStreamInitializer;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

import java.io.InputStream;

/**
 * @author
 */
@XStreamAlias("xml")
public class WxMpDemoInMemoryConfigStorage extends WxMpInMemoryConfigStorage {

	public String toString() {
		return "SimpleWxConfigProvider [appId=" + appId + ", secret=" + secret + ", accessToken=" + accessToken + ", expiresTime=" + expiresTime + ", token=" + token + ", aesKey=" + aesKey + "]";
	}

	public static WxMpDemoInMemoryConfigStorage fromXml(InputStream is) {
		XStream xstream = XStreamInitializer.getInstance();
		xstream.processAnnotations(WxMpDemoInMemoryConfigStorage.class);
		return (WxMpDemoInMemoryConfigStorage) xstream.fromXML(is);
	}

}
