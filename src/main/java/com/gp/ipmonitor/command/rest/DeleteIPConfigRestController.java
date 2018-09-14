/**
 * 
 */
package com.gp.ipmonitor.command.rest;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.ipmonitor.model.IPConfigSystemModel;

/**
 * Purpose of this controller is to delete mapping of IP and System.
 * @author GANESH
 *
 */
@RestController
public class DeleteIPConfigRestController {

	private static final InetAddressValidator INET_ADDRESS_VALIDATOR=InetAddressValidator.getInstance();

	
	/**
	 * 
	 */
	public DeleteIPConfigRestController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Purpose of this method is to delete IP and system details
	 * <ul>
	 * <li> it will return HTTP 202 request if record is accepted for deletion</li>
	 * <li> return HTTP 400 response if IP address is not valid</li>
	 * </ul>
	 *  
	 * @param ipdetailsForSystem
	 * @return
	 */
	@RequestMapping(
			value = "/blacklisted-ip-system", 
			method = RequestMethod.DELETE, 
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity  addIPDetailstoBlacklistForSystem(@RequestBody IPConfigSystemModel ipdetailsForSystem){
		if(INET_ADDRESS_VALIDATOR.isValidInet4Address(ipdetailsForSystem.getIpToBlacklist())){
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}else{
			//throw 400 error
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
	}


}
