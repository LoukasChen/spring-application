package com.csp.app.argsResolver;

import com.alibaba.fastjson.JSON;
import com.csp.app.consts.Constants;
import com.csp.app.entity.ProtocolRequest;
import com.csp.app.util.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Conventions;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
public class ProtocolRequestArgumentResolver implements HandlerMethodArgumentResolver {

	private final static String param = "param";
	private final static String protocol = "protocol";
	private final static String clientInfo = "clientInfo";

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if (ProtocolRequest.class.isAssignableFrom(parameter.getParameterType())) {
			return true;
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		HttpInputMessage inputMessage = new ServletServerHttpRequest(request);
		Map<String, Object> bodyMap = JSON.parseObject(inputMessage.getBody(), Map.class);
		ProtocolRequest protocolRequest = new ProtocolRequest();
		protocolRequest.setParam((Map<String, Object>) bodyMap.get(param));
		Object protocolObj = bodyMap.get(protocol);

		if (!(protocolObj instanceof Map)) {
			log.error("json param does not have a correct format: JSON={}", bodyMap);
			return null;
		}

		Map<String, String> procMap = (Map<String, String>) protocolObj;
		ProtocolRequest.Protocol protocol = new ProtocolRequest.Protocol();
		protocol.setFunctionCode(procMap.get(Constants.Base.functionCode));
		protocol.setSignature(procMap.get(Constants.Base.signature));
		protocolRequest.setProtocol(protocol);

		Object clientInfoObj = bodyMap.get(clientInfo);
		if (clientInfoObj != null) {
			ProtocolRequest.ClientInfo clientInfo = new ProtocolRequest.ClientInfo();
			clientInfo.setVersionType(((Map<String, String>) clientInfoObj).get("versionType"));
			protocolRequest.setClientInfo(clientInfo);
		}

		final Object memberId = bodyMap.get(Constants.Base.memberId);
		if (memberId != null) {
			protocolRequest.setMemberId(String.valueOf(memberId));
		}
		final Object userId = bodyMap.get(Constants.Base.userId);
		if (userId != null) {
			protocolRequest.setUserId(String.valueOf(userId));
		}
		String name = Conventions.getVariableNameForParameter(parameter);
		WebDataBinder binder = binderFactory.createBinder(webRequest, protocolRequest, name);
		if (protocolRequest != null) {
			WebUtils.validate(binder, parameter);
		}
		mavContainer.addAttribute(BindingResult.MODEL_KEY_PREFIX + name, binder.getBindingResult());

		return protocolRequest;
	}

}
