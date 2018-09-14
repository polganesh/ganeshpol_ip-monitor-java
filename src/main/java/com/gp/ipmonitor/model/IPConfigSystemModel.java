/**
 * 
 */
package com.gp.ipmonitor.model;

import java.io.Serializable;

/**
 * Wrapper for IP address and system details
 * 
 * @author GANESH
 *
 */
public class IPConfigSystemModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1209089834665018304L;

	private String ipToBlacklist;
	private String systemId;
	private String startDate;
	private String endDate;

	/**
	 * No Argument Constructor
	 */
	public IPConfigSystemModel() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Handy Constructor to create instance of this class.
	 * @param ipToBlacklist
	 * @param systemId
	 * @param startDate
	 * @param endDate
	 */
	public IPConfigSystemModel(String ipToBlacklist, String systemId, String startDate, String endDate) {
		super();
		this.ipToBlacklist = ipToBlacklist;
		this.systemId = systemId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @return the ipToBlacklist
	 */
	public String getIpToBlacklist() {
		return ipToBlacklist;
	}

	/**
	 * @param ipToBlacklist the ipToBlacklist to set
	 */
	public void setIpToBlacklist(String ipToBlacklist) {
		this.ipToBlacklist = ipToBlacklist;
	}

	/**
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}

	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
