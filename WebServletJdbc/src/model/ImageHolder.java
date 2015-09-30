package model;

public class ImageHolder {
	private int id;
	private String name;
	private String contentType;
	private byte[] content;
	private long contentLength;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public long getContentLength()
	{
		return contentLength;
	}
	public void setContentLength(long contentLength)
	{
		this.contentLength = contentLength;
	}
	
}
