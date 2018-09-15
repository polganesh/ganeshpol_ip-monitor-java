package com.gp.ipmonitor.query.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.ipmonitor.model.IPConfigSystemModel;
import com.gp.ipmonitor.query.rest.service.IGetIpConfigDetailsForSystemService;

/**
 * This will provide Ip Configuration details based on systemId
 * @author GANESH
 *
 */
@RestController
public class GetIpConfigDetailsForSystemController {
	
	@Autowired
	IGetIpConfigDetailsForSystemService service;

	public GetIpConfigDetailsForSystemController() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Provide list of IP details based on systemId
	 * @param ipdetailsForSystem
	 * @return array  of <code>String</code>  in ResponseEntity
	 */
	@RequestMapping(
			value = "/blacklisted-ip-system", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String[]>  getIpConfigBySystem(@RequestParam("systemId") String systemId){
		return new  ResponseEntity<String[]>(service.getBlacklistedIpForSystem(systemId), HttpStatus.OK);
	}
	
	/**
	 * provide <code>true</code>if IP address found for system else <code>false</code>
	 * @param systemId
	 * @param ip
	 * @return
	 */
	@RequestMapping(
			value = "/is-ip-present-for-systemid", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json")
	@ResponseBody
	ResponseEntity<Boolean> isIpAddressPresentForSystem(@RequestParam("systemId") String systemId,@RequestParam("ip") String ip){
		return new ResponseEntity<Boolean>(service.isIpBlacklistedForSystem(systemId, ip), HttpStatus.OK);
	}

}
