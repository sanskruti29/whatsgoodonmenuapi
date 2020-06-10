package com.whatsgoodonmenu.api.services;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.whatsgoodonmenu.api.data.Visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua_parser.Client;
import ua_parser.Parser;

@Component
public class VisitorService {
	private static final String UNKNOWN = "UNKNOWN";
	@Autowired Parser parser;

	public Visitor visit(HttpServletRequest request) {
		String ip = extractIp(request);
		Visitor visitor = new Visitor();
		visitor.setDevice(getDeviceDetails(request.getHeader("user-agent")));
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

	private String getDeviceDetails(String userAgent) {
        String deviceDetails = UNKNOWN;
        Client client = parser.parse(userAgent);
        if (Objects.nonNull(client)) {
            deviceDetails = client.userAgent.family + " " + client.userAgent.major + "." + client.userAgent.minor +
                    " - " + client.os.family + " " + client.os.major + "." + client.os.minor;
        }
        return deviceDetails;
    }
}