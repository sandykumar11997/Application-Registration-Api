package in.happy.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.happy.binding.CitizenBindApp;
import in.happy.entity.CitizenApp;
import in.happy.repo.CitizenAppRepo;
import in.happy.service.ArService;

@Service
public class ArServiceImpl implements ArService {
	
	@Autowired
	private CitizenAppRepo appRepo;

	@Override
	public Integer createApplication(CitizenBindApp app) {
		
		String endUrl = "http://13.233.122.141:8080/ssn/{ssn}";
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> resEntity = rt.getForEntity(endUrl, String.class, app.getSsn());
		String stateName = resEntity.getBody();
		if ("New Jourcy".equals(stateName)) {
			CitizenApp entity = new CitizenApp();
			BeanUtils.copyProperties(app, entity);
			
			entity.setStateName(stateName);
		
			CitizenApp save = appRepo.save(entity);
			return save.getAppId();
		}
		return 0;
	}

}
