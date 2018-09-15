/**
 * 
 */
package com.gp.ipmonitor.command.service;

import com.gp.ipmonitor.model.IPConfigSystemModel;

/**
 * Interface to define operation for deleting IP config for system
 * @author GANESH
 *
 */
public interface IDeleteIPConfigService {

	void deleteBlacklistIpForSystem(IPConfigSystemModel blacklistedIp);
}
