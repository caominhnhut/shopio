package com.gls.sio.product.model;

public class ProductImage {

	private String filename;
	private String fileDownloadUri;
	
	public ProductImage(String filename, String fileDownloadUri) {
		this.filename = filename;
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}
}
