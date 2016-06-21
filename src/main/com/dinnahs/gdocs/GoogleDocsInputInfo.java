package com.dinnahs.gdocs;

public class GoogleDocsInputInfo {
	private String serviceAccountEmail;
	private String ownerEmail;
	private String privateKeyPath;
	private String excelFileId;
	private String username;
	private String password;
	
	public GoogleDocsInputInfo(String serviceAccountEmail, String ownerEmail, String privateKeyPath,
			String excelFileId, String username, String password) {
		this.serviceAccountEmail = serviceAccountEmail;
		this.ownerEmail = ownerEmail;
		this.privateKeyPath = privateKeyPath;
		this.excelFileId = excelFileId;
		this.username = username;
		this.password = password;
	}
	
	public String getServiceAccountEmail() {
		return serviceAccountEmail;
	}
	public void setServiceAccountEmail(String serviceAccountEmail) {
		this.serviceAccountEmail = serviceAccountEmail;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getPrivateKeyPath() {
		return privateKeyPath;
	}
	public void setPrivateKeyPath(String privateKeyPath) {
		this.privateKeyPath = privateKeyPath;
	}
	public String getExcelFileId() {
		return excelFileId;
	}
	public void setExcelFileId(String excelFileId) {
		this.excelFileId = excelFileId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
