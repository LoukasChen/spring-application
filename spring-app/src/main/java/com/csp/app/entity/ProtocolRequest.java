package com.csp.app.entity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class ProtocolRequest {
	/**
	 * 会员ID
	 */
	private String memberId;

	@NotNull
	@Valid
	private Protocol protocol;


	private ClientInfo clientInfo;

	@NotNull
	private Map<String, Object> param;

	@Data
	public static class Protocol {

		@NotNull
		private String functionCode;

		private String signature;

		private String fromPlatform;

	}

	@Data
	public static class ClientInfo {

		private String versionType;


	}

	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}

	public Map<String, Object> getParam() {
		return param;
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

}
