/**
 * 
 */
package com.gp.ipmonitor.query.rest.service;

/**
 * @author GANESH
 *
 */
public interface IGetIpConfigDetailsForSystemService {

	boolean isSystemIdPresent(String systemId);
	
	boolean isIpBlacklistedForSystem(String systemId,String blacklistedIp) ;
	
	String[] getBlacklistedIpForSystem(String systemId);
}
