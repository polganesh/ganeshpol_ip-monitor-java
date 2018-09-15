/**
 * 
 */
package com.gp.ipmonitor.command.rest;

import java.time.format.DateTimeFormatter;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.ipmonitor.command.rest.validator.IPConfigSystemModelValidator;
import com.gp.ipmonitor.command.service.impl.IAddIPConfigService;
import com.gp.ipmonitor.model.IPConfigSystemModel;

/**
 * REST Controller for Adding IP to be blacklisted for system
 * 
 * @author GANESH
 *
 */
@RestController
public class AddIPConfigRestController {
	
	

	@Autowired
	private IAddIPConfigService addIPConfigService;
	
	/**
	 *No Argument Constructor 
	 */
	public AddIPConfigRestController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Purpose of this method is to add IP and system details
	 * <ul>
	 * <li> it will return HTTP 201 request if it is valid request and record is created</li>
	 * <li> return HTTP 400 response if IP address is not valid</li>
	 * </ul>
	 *  
	 * @param ipdetailsForSystem
	 * @return
	 * @see IPConfigSystemModelValidator#validateRequest(IPConfigSystemModel)
	 */
	@RequestMapping(
			value = "/blacklisted-ip-system", 
			method = RequestMethod.POST, 
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity  addIPDetailstoBlacklistForSystem(@RequestBody IPConfigSystemModel ipdetailsForSystem){
		if(IPConfigSystemModelValidator.validateRequest(ipdetailsForSystem)){
			addIPConfigService.addBlacklistIpForSystem(ipdetailsForSystem);
			return new ResponseEntity(HttpStatus.CREATED);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
}
