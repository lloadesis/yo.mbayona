package YOpr.mbayonaYo;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class YOimpl implements YOservice{

	@Autowired
	RestTemplate rest;
	
	private String serviceUrl;
	
	@Value("${yo.pr.mbayona.token:}")	
	private String TOKEN;

	private static Logger logger = Logger.getLogger(YOimpl.class.getName());
	
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public boolean YO (String idUser) {
		final String PARAMETER = "api_token";
		HttpEntity<String> entity= new HttpEntity<String>(PARAMETER+TOKEN); 
		
		try {
		rest.postForObject(serviceUrl, entity, Object.class);
		}
		catch (HttpServerErrorException e){
			logger.log(Level.SEVERE, e.getStatusText() + e.getStatusCode());
			return false;
		} 
		return true;
	}

}
