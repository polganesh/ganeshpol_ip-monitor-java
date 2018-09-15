/**
 * 
 */
package com.gp.ipmonitor.command.service;

import com.gp.ipmonitor.model.IPConfigSystemModel;

/**
 * Interface to define operation for adding blacklisted IP
 * @author GANESH
 *
 */
public interface IAddIPConfigService {
	
	/**
	 * This method add IP against systemId (case insensitive)
	 * @param blacklistedIp
	 */
	void addBlacklistIpForSystem(IPConfigSystemModel blacklistedIp);

}
