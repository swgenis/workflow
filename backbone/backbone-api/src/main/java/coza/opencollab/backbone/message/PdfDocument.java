package coza.opencollab.backbone.message;

import java.io.Serializable;

public class PdfDocument implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private byte[] bytes;
    private String fileName;

    public PdfDocument(byte[] bytes) {
	super();
	this.bytes = bytes;
    }

    public byte[] getBytes() {
	return bytes;
    }

    public void setBytes(byte[] bytes) {
	this.bytes = bytes;
    }

    public String getFileName() {
	return fileName;
    }

    public void setFileName(String fileName) {
	this.fileName = fileName;
    }

}
