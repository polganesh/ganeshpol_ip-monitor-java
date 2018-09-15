/**
 * 
 */
package com.gp.ipmonitor.command.rest;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.ipmonitor.command.rest.validator.IPConfigSystemModelValidator;
import com.gp.ipmonitor.command.service.IDeleteIPConfigService;
import com.gp.ipmonitor.model.IPConfigSystemModel;
import com.gp.ipmonitor.query.rest.service.IGetIpConfigDetailsForSystemService;

/**
 * Purpose of this controller is to delete mapping of IP and System.
 * @author GANESH
 *
 */
@RestController
public class DeleteIPConfigRestController {

	@Autowired
	private IGetIpConfigDetailsForSystemService ipConfigDetailsForSystemService;

	@Autowired
	private IDeleteIPConfigService deleteIPConfigService;

	
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
	 * <li> return HTTP 404 response if system id is not present or  IP address and systemId combination is not present</li>
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
	public ResponseEntity  deleteIpBlacklisting(@RequestBody IPConfigSystemModel ipdetailsForSystem){
		boolean isValidRequest=IPConfigSystemModelValidator.validateRequestForDelete(ipdetailsForSystem);
		if(isValidRequest){
			boolean isDetailsPresnetInSystem=ipConfigDetailsForSystemService.isSystemIdPresent(ipdetailsForSystem.getSystemId())&&
					ipConfigDetailsForSystemService.isIpBlacklistedForSystem(ipdetailsForSystem.getSystemId(), ipdetailsForSystem.getIpToBlacklist());
			if(isDetailsPresnetInSystem){
				deleteIPConfigService.deleteBlacklistIpForSystem(ipdetailsForSystem);
				return new ResponseEntity(HttpStatus.ACCEPTED);
			}else{
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		

	}


}
