package global;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;

public class GZipOutputStream extends ServletOutputStream{

	private HttpServletResponse response;
	private GZIPOutputStream gzipOutputstream;
	private ByteArrayOutputStream byteArrayOutputstream;
	
	
	public GZipOutputStream(HttpServletResponse response) throws IOException{
		this.response = response;
		this.byteArrayOutputstream = new ByteArrayOutputStream();
		this.gzipOutputstream = new GZIPOutputStream(byteArrayOutputstream);
	}
	
	//轉交到jdk的GZIPOutputStream
	public void write(int b) throws IOException {
		this.gzipOutputstream.write(b);
	}
	
	
	//執行壓縮，然後把response送到broswer
	public void close() throws IOException {
		//執行壓縮一定要呼叫這個方法
		gzipOutputstream.finish();
		
		//把壓縮的資料送到broswer
		byte[] content = byteArrayOutputstream.toByteArray();
		
		//設定壓縮方法為gzip
		response.addHeader("Content-Encoding", "gzip");
		response.addHeader("Content-Length", Integer.toString(content.length));
		
		//送到broswer
		ServletOutputStream out = response.getOutputStream();
		out.write(content);
		out.close();
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		gzipOutputstream.write(b, off, len);
	}
	
	
	
	@Override
	public void write(byte[] b) throws IOException {
		gzipOutputstream.write(b);
	}

	public void flush() throws IOException{
		this.gzipOutputstream.finish();
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWriteListener(WriteListener arg0) {
		// TODO Auto-generated method stub
		
	}
	
	



	
	
}
