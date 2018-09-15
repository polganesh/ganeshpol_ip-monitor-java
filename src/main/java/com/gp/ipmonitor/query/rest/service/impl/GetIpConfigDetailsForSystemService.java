/**
 * 
 */
package com.gp.ipmonitor.query.rest.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gp.ipmonitor.query.rest.service.IGetIpConfigDetailsForSystemService;

/**
 * @author GANESH
 *
 */
@Service
public class GetIpConfigDetailsForSystemService implements IGetIpConfigDetailsForSystemService {

	@Value("${rootPath}")
	private String rootPath;

	
	/**
	 * 
	 */
	public GetIpConfigDetailsForSystemService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Return <code>true</code> if systemId is Present else <code>false</code>
	 * @see com.gp.ipmonitor.query.rest.service.IGetIpConfigDetailsForSystemService#isSystemIdPresent(java.lang.String)
	 */
	@Override
	public boolean isSystemIdPresent(String systemId) {
		Path path = Paths.get(rootPath, systemId.toLowerCase().trim());
		return Files.exists(path) && Files.isDirectory(path);
	}
	
	/**
	 * Return <code>true</code> if systemId is Present else <code>false</code>
	 * @see com.gp.ipmonitor.query.rest.service.IGetIpConfigDetailsForSystemService#isSystemIdPresent(java.lang.String)
	 */
	@Override
	public boolean isIpBlacklistedForSystem(String systemId,String blacklistedIp) {
		Path path = Paths.get(rootPath, systemId.toLowerCase().trim()+File.separator+blacklistedIp);
		return Files.exists(path) && !Files.isDirectory(path);
	}

	@Override
	public String [] getBlacklistedIpForSystem(String systemId) {
		File f = new File(rootPath, systemId.toLowerCase().trim()+File.separator);
	    return f.list();
	}
	
	

	
	
	

}
