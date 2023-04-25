package in.happy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.happy.binding.CitizenBindApp;
import in.happy.service.ArService;

@RestController
public class AppRegRestcontrolller {
	
	@Autowired
	private ArService service;
	
	@PostMapping("/ssn/{ssn}")
	public ResponseEntity<String> createApp(@RequestBody CitizenBindApp app){
		
		Integer status = service.createApplication(app);
		if(status >0) {
			return new ResponseEntity<>("successfull registration" + app.getSsn(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>("unsuccessfull registration",HttpStatus.BAD_REQUEST);
		}
	}

}
