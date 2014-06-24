package YOpr.mbayonaYo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class YOimpl implements YOservice{


	@Autowired
	RestTemplate rest;
	
	private String serviceUrl;
	
	@Value("${yo.pr.mbayona.token:}")	
	private String TOKEN = null;

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public boolean YO(String idUser) {
		final String PARAMETER = "api_token";
		HttpEntity<String> entity= new HttpEntity<String>(PARAMETER+TOKEN); 
		
		try {
		rest.postForObject(serviceUrl, entity, Object.class);
		}
		catch (Exception e){
			return false;
		} 
		return true;
	}

}
