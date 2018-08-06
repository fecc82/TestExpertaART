package com.expertaart.refactorapp.services.push.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="ws.config")
public class WebSocketEndpointProperties {
	
	private String brokerPath;
	
	private String endpointAndroid;
	
	private String endpointIOS;
	
	private String pushAndroid;
	
	private String pushIOS;

	public String getBrokerPath() {
		return brokerPath;
	}

	public String getEndpointAndroid() {
		return endpointAndroid;
	}

	public String getEndpointIOS() {
		return endpointIOS;
	}

	public String getPushAndroid() {
		return pushAndroid;
	}

	public String getPushIOS() {
		return pushIOS;
	}

	public void setBrokerPath(String brokerPath) {
		this.brokerPath = brokerPath;
	}

	public void setEndpointAndroid(String endpointAndroid) {
		this.endpointAndroid = endpointAndroid;
	}

	public void setEndpointIOS(String endpointIOS) {
		this.endpointIOS = endpointIOS;
	}

	public void setPushAndroid(String pushAndroid) {
		this.pushAndroid = pushAndroid;
	}

	public void setPushIOS(String pushIOS) {
		this.pushIOS = pushIOS;
	}

	public String getFullPushAndroid() {
		return this.brokerPath.concat(this.pushAndroid);
	}
	
	public String getFullPushIOS() {
		return this.brokerPath.concat(this.pushIOS);
	}
		
}
