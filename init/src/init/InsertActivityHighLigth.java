package init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import global.GlobalService;

public class InsertActivityHighLigth 
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO ActivityHighlight(fullProjId,memberId,frontCoverName,frontCover,frontCoverLength,videoURL,content) VALUES(?,?,?,?,?,?,?)";
	
	public static void start()
	{
		File file = null;
		File contentFile = null;
		StringBuilder content = new StringBuilder();
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			
			// 第一筆
			pstmt.setInt(1,10);     // 完整計畫
			pstmt.setInt(2,8);		// 發起者
			
			file = new File("ActivityHighLight/ActivityHighLight01.png");
			try(FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(3,file.getName());	// frontCoverName
				pstmt.setBytes(4,GlobalService.convertByteArrayToBase64String(file.getName(), GlobalService.convertInputStreamToByteArray(fis)).getBytes());	// frontCover 
				pstmt.setLong(5,file.length());		// frontCoverLength 
				pstmt.setString(6,"https://www.youtube.com/watch?v=8GjErEIet5E");
				
				contentFile = new File("ActivityHighLigthContent/1.txt");
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
					pstmt.setString(7,content.toString());
					pstmt.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			// 第二筆
			pstmt.setInt(1,11);     // 完整計畫
			pstmt.setInt(2,8);		// 發起者
			
			file = new File("ActivityHighLight/ActivityHighLight02.jpg");
			try(FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(3,file.getName());	// frontCoverName
				pstmt.setBytes(4,GlobalService.convertByteArrayToBase64String(file.getName(), GlobalService.convertInputStreamToByteArray(fis)).getBytes());	// frontCover 
				pstmt.setLong(5,file.length());		// frontCoverLength 
				pstmt.setString(6,"https://www.youtube.com/watch?v=WI_tONeHpcA");
				
				contentFile = new File("ActivityHighLigthContent/2.txt");
				content.delete(0,content.length());
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
					pstmt.setString(7,content.toString());
					pstmt.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			// 第三筆
			pstmt.setInt(1,12);     // 完整計畫
			pstmt.setInt(2,8);		// 發起者
			
			file = new File("ActivityHighLight/ActivityHighLight03.jpg");
			try(FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(3,file.getName());	// frontCoverName
				pstmt.setBytes(4,GlobalService.convertByteArrayToBase64String(file.getName(), GlobalService.convertInputStreamToByteArray(fis)).getBytes());	// frontCover 
				pstmt.setLong(5,file.length());		// frontCoverLength 
				pstmt.setString(6,"https://www.youtube.com/watch?v=DyhbMZQi1XY");
				
				contentFile = new File("ActivityHighLigthContent/3.txt");
				content.delete(0,content.length());
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
					pstmt.setString(7,content.toString());
					pstmt.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			// 第四筆
			pstmt.setInt(1,13);     // 完整計畫
			pstmt.setInt(2,1);		// 發起者
			
			file = new File("ActivityHighLight/ActivityHighLight04.jpg");
			try(FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(3,file.getName());	// frontCoverName
				pstmt.setBytes(4,GlobalService.convertByteArrayToBase64String(file.getName(), GlobalService.convertInputStreamToByteArray(fis)).getBytes());	// frontCover 
				pstmt.setLong(5,file.length());		// frontCoverLength 
				pstmt.setString(6,"https://www.youtube.com/watch?v=mvYjMSnGWQc");
				
				contentFile = new File("ActivityHighLigthContent/4.txt");
				content.delete(0,content.length());
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
					pstmt.setString(7,content.toString());
					pstmt.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			// 第五筆
			pstmt.setInt(1,14);     // 完整計畫
			pstmt.setInt(2,1);		// 發起者
			
			file = new File("ActivityHighLight/ActivityHighLight05.jpg");
			try(FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(3,file.getName());	// frontCoverName
				pstmt.setBytes(4,GlobalService.convertByteArrayToBase64String(file.getName(), GlobalService.convertInputStreamToByteArray(fis)).getBytes());	// frontCover 
				pstmt.setLong(5,file.length());		// frontCoverLength 
				pstmt.setString(6,"https://www.youtube.com/watch?v=SQlz7Q94b0E");
				
				contentFile = new File("ActivityHighLigthContent/5.txt");
				content.delete(0,content.length());
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
					pstmt.setString(7,content.toString());
					pstmt.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			// 第六筆
			pstmt.setInt(1,15);     // 完整計畫
			pstmt.setInt(2,1);		// 發起者
			
			file = new File("ActivityHighLight/ActivityHighLight06.jpg");
			try(FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(3,file.getName());	// frontCoverName
				pstmt.setBytes(4,GlobalService.convertByteArrayToBase64String(file.getName(), GlobalService.convertInputStreamToByteArray(fis)).getBytes());	// frontCover 
				pstmt.setLong(5,file.length());		// frontCoverLength 
				pstmt.setString(6,"https://www.youtube.com/watch?v=qa_6S52NEdk");
				
				contentFile = new File("ActivityHighLigthContent/6.txt");
				content.delete(0,content.length());
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
					pstmt.setString(7,content.toString());
					pstmt.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			// 第七筆
			pstmt.setInt(1,16);     // 完整計畫
			pstmt.setInt(2,1);		// 發起者
			
			file = new File("ActivityHighLight/ActivityHighLight07.jpg");
			try(FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(3,file.getName());	// frontCoverName
				pstmt.setBytes(4,GlobalService.convertByteArrayToBase64String(file.getName(), GlobalService.convertInputStreamToByteArray(fis)).getBytes());	// frontCover 
				pstmt.setLong(5,file.length());		// frontCoverLength 
				pstmt.setString(6,"https://www.youtube.com/watch?v=H4hiHYCN1oc");
				
				contentFile = new File("ActivityHighLigthContent/7.txt");
				content.delete(0,content.length());
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
					pstmt.setString(7,content.toString());
					pstmt.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			// 第八筆
			pstmt.setInt(1,17);     // 完整計畫
			pstmt.setInt(2,1);		// 發起者
			
			file = new File("ActivityHighLight/ActivityHighLight08.jpg");
			try(FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(3,file.getName());	// frontCoverName
				pstmt.setBytes(4,GlobalService.convertByteArrayToBase64String(file.getName(), GlobalService.convertInputStreamToByteArray(fis)).getBytes());	// frontCover 
				pstmt.setLong(5,file.length());		// frontCoverLength 
				pstmt.setString(6,"https://www.youtube.com/watch?v=sVcwfMYerzM");
				
				contentFile = new File("ActivityHighLigthContent/8.txt");
				content.delete(0,content.length());
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
					pstmt.setString(7,content.toString());
					pstmt.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			// 第九筆
			pstmt.setInt(1,18);     // 完整計畫
			pstmt.setInt(2,1);		// 發起者
			
			file = new File("ActivityHighLight/ActivityHighLight09.jpg");
			try(FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(3,file.getName());	// frontCoverName
				pstmt.setBytes(4,GlobalService.convertByteArrayToBase64String(file.getName(), GlobalService.convertInputStreamToByteArray(fis)).getBytes());	// frontCover 
				pstmt.setLong(5,file.length());		// frontCoverLength 
				pstmt.setString(6,"https://www.youtube.com/watch?v=0Rv6EIBAvME");
				
				contentFile = new File("ActivityHighLigthContent/9.txt");
				content.delete(0,content.length());
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
					pstmt.setString(7,content.toString());
					pstmt.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			System.out.println("花絮已完成");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args)
	{
	}
}
