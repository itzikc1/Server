package model;

import java.io.Serializable;

public class Problem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String domainName;
	private String algorithm;
	
	//private static Problem instance=null;
	
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
}
