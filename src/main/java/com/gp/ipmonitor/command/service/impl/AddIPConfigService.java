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

import com.gp.ipmonitor.exception.BusinessLogicException;
import com.gp.ipmonitor.exception.TechnicalException;
import com.gp.ipmonitor.model.IPConfigSystemModel;

/**
 * Implementation fo <code>IAddIPConfigService</code>
 * @author GANESH
 *
 */
@Service
public class AddIPConfigService implements IAddIPConfigService {


	@Value("${rootPath}")
	private String rootPath;

	/**
	 * 
	 */
	public AddIPConfigService() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 */
	@Override
	public void addBlacklistIpForSystem(IPConfigSystemModel blacklistedIPSystemDetails) {
		// System.out.println("root path "+rootPath);
		String systemId = blacklistedIPSystemDetails.getSystemId();
		if (!(systemId == null || "".equals(systemId))) {
			Path path = Paths.get(rootPath, systemId.toLowerCase().trim());
			try {
				if (!Files.exists(path)) {
					Files.createDirectories(path);
				}
				String blacklistedIpDetails = rootPath + systemId.toLowerCase() + File.separator
						+ blacklistedIPSystemDetails.getIpToBlacklist();
				Files.createFile(Paths.get(blacklistedIpDetails));
			} catch (IOException ioex) {
				throw new TechnicalException(ioex.getMessage(), ioex);
			}
		} else {
			throw new BusinessLogicException("systemId Can not be null or empty");
		}
	}
}
