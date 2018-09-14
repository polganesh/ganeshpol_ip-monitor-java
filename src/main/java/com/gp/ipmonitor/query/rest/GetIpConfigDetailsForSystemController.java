package com.gp.ipmonitor.query.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gp.ipmonitor.model.IPConfigSystemModel;

/**
 * This will provide Ip Configuration details based on systemId
 * @author GANESH
 *
 */
public class GetIpConfigDetailsForSystemController {

	public GetIpConfigDetailsForSystemController() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Provide list of IP details based on systemId
	 * @param ipdetailsForSystem
	 * @return <code>List</code> of <code>IPConfigSystemModel</code>
	 */
	@RequestMapping(
			value = "/blacklisted-ip-system", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity  getIpConfigBySystem(@RequestBody String systemId){
		return null;
	}

}
