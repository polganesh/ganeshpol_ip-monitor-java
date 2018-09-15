/**
 * 
 */
package com.gp.ipmonitor.command.rest.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.apache.commons.validator.routines.InetAddressValidator;

import com.gp.ipmonitor.model.IPConfigSystemModel;

/**
 * This class handle all validations specific to IPConfigSystemModel
 * @author GANESH
 *
 */
public class IPConfigSystemModelValidator {

	private static final InetAddressValidator INET_ADDRESS_VALIDATOR = InetAddressValidator.getInstance();

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("YYYY-MM-dd");

	private IPConfigSystemModelValidator(){
		
	}
	
	/**
	 * it will return <code>true</code> if it fulfill all following conditions
	 * <ul>
	 * 	<li>if system id is not  <code>null</code> or empty</li>
	 * 	<li>if it contains valid IP address</li>
	 *  <li>if start date present and it is in format <b>YYYY-MM-dd</b>
	 *  <li>if end date present and it is in format  <b>YYYY-MM-dd</b>
	 * </ul>
	 * else 
	 * @param ipdetailsForSystem
	 * @return
	 */
	public static boolean validateRequest(IPConfigSystemModel ipdetailsForSystem) {
		String systemId=ipdetailsForSystem.getSystemId();
		boolean isValidSystemId=!(systemId==null || "".equals(systemId));
		boolean isValidIP=INET_ADDRESS_VALIDATOR.isValidInet4Address(ipdetailsForSystem.getIpToBlacklist());
		boolean isValidStartDate=!isNullOrEmptyString(ipdetailsForSystem.getStartDate())?isValidDate(ipdetailsForSystem.getStartDate()):true;
		boolean isValidEndDate=!isNullOrEmptyString(ipdetailsForSystem.getEndDate())?isValidDate(ipdetailsForSystem.getEndDate()):true;
		return isValidSystemId && isValidIP && isValidStartDate && isValidEndDate;
	}
	
	private static boolean isValidDate(String date){
		boolean isValidDate=true;
		try{
			LocalDate localDate = LocalDate.parse(date, FORMATTER);
		}catch(DateTimeParseException parseEx){
			isValidDate=false;
		}
		return isValidDate;
	}
	
	private static boolean isNullOrEmptyString(String stringToTest){
		return stringToTest==null || "".equals(stringToTest.trim());
	}
}
