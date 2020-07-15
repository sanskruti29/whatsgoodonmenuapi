package com.whatsgoodonmenu.api.services.visitor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.whatsgoodonmenu.api.data.Visitor;
import com.whatsgoodonmenu.api.database.visitor.VisitorRepository;
import com.whatsgoodonmenu.api.database.visitor.VisitorTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import ua_parser.Client;
import ua_parser.Parser;

@Log4j2
@Component
public class VisitorService {
	
	private static final String UNKNOWN = "UNKNOWN";
	@Autowired Parser parser;
	@Autowired VisitorRepository visitorRepository;
	@Autowired VisitorTemplate visitorTemplate;

	public Visitor visit(HttpServletRequest request) {
		String ip = extractIp(request);
		Visitor visitor = new Visitor();
		LocalDateTime localDateTime =  LocalDateTime.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/Los_Angeles"));
		visitor.setZonedDateTime(zonedDateTime);
		visitor.setDevice(getDeviceDetails(request.getHeader("user-agent")));
		visitor.setIp(ip);
		log.info("Visit from: " + visitor);
		Visitor visit = visitorRepository.save(visitor);
		log.info("ID is: " + visit.getId());
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

	public int getTotalVisits() {
		return visitorRepository.findAll().size();
	}

	public int getUniqueVisitors() {
		return visitorTemplate.getUniqueVisits();
	}
}