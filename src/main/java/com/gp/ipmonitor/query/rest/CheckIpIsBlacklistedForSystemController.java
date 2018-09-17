/**
 * 
 */
package com.gp.ipmonitor.query.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gp.ipmonitor.query.rest.service.IGetIpConfigDetailsForSystemService;

/**
 * @author GANESH
 *
 */
public class CheckIpIsBlacklistedForSystemController {

	@Autowired
	IGetIpConfigDetailsForSystemService service;

	
	/**
	 * 
	 */
	public CheckIpIsBlacklistedForSystemController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(
			value = "/is-black-listed", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<Boolean>  isBlackListedForSystem(@RequestParam("systemId") String systemId,@RequestParam("ip") String ip){
		return new  ResponseEntity<Boolean>(service.isIpBlacklistedForSystem(systemId,ip), HttpStatus.OK);
	}

}
