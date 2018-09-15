/**
 * 
 */
package com.gp.ipmonitor.command.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gp.ipmonitor.command.service.IDeleteIPConfigService;
import com.gp.ipmonitor.exception.TechnicalException;
import com.gp.ipmonitor.model.IPConfigSystemModel;

/**
 * @author GANESH
 *
 */
@Service
public class DeleteIPConfigService implements IDeleteIPConfigService {
	
	@Value("${rootPath}")
	private String rootPath;

	/* (non-Javadoc)
	 * @see com.gp.ipmonitor.command.service.impl.IDeleteIPConfigService#deleteBlacklistIpForSystem(com.gp.ipmonitor.model.IPConfigSystemModel)
	 */
	@Override
	public void deleteBlacklistIpForSystem(IPConfigSystemModel blacklistedIp) {
		String systemId = blacklistedIp.getSystemId();
		if (!(systemId == null || "".equals(systemId))) {
			Path path = Paths.get(rootPath, systemId.toLowerCase().trim()+File.separator+blacklistedIp.getIpToBlacklist());
			try{
				//Files.deleteIfExists(path);
				Files.delete(path);
			}catch(IOException |SecurityException ex){
				new TechnicalException("Unable to remove IP for system", ex);
			}
		}

	}

}
