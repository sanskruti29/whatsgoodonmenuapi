package com.whatsgoodonmenu.api.services;

import javax.servlet.http.HttpServletRequest;

import com.whatsgoodonmenu.api.data.Visitor;

import org.springframework.stereotype.Component;

@Component
public class VisitorService {

	public Visitor visit(HttpServletRequest request) {
		String ip = extractIp(request);
		Visitor visitor = new Visitor();
		visitor.setDevice("ABC");
		visitor.setIp(ip);
		return visitor;
	}

	private String extractIp(HttpServletRequest request) {
		String clientIp = request.getHeader("x-forwarded-for");
		if(clientIp == null){
			clientIp = request.getRemoteAddr();
		} else {
			clientIp = clientIp.split(" *, *")[0];
		}
		return clientIp;
	}
}