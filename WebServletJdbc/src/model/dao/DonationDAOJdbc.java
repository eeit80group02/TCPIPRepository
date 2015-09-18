package model.dao;

import global.GlobalService;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.DonationBean;
import model.dao.interfaces.DonationDAO;

public class DonationDAOJdbc implements DonationDAO
{
	private static final String SELECT_BY_PRYMARY_KEY = "SELECT donationId,schoolId,donationStatus,supplyName,originalDemandNumber,originalDemandUnit,demandNumber,size,demandContent,supplyStatus,demandTime,expireTime,imageName,imageFile,imageLength,remark FROM Donation where donationId = ?";
	private static final String GET_ALL_BY_ODN = "SELECT * FROM donation order by originalDemandNumber DESC";
	private static final String GET_ALL_BY_EXP = "SELECT * FROM donation order by expiretime";
	private static final String GET_ALL_BY_DET = "SELECT * FROM donation order by demandtime desc";
	private static final String GET_ALL = "SELECT donationId,schoolId,donationStatus,supplyName,originalDemandNumber,originalDemandUnit,demandNumber,size,demandContent,supplyStatus,demandTime,expireTime,imageName,imageFile,imageLength,remark FROM Donation";
	private static final String INSERT = "INSERT INTO Donation (schoolId,donationStatus,supplyName,originalDemandNumber,originalDemandUnit,demandNumber,size,demandContent,supplyStatus,demandTime,expireTime,imageName,imageFile,imageLength,remark) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE Donation SET schoolId = ?,donationStatus = ?,supplyName = ?,originalDemandNumber = ?,originalDemandUnit = ?,demandNumber = ?,size = ?,demandContent=?,supplyStatus = ?,demandTime = ?,expireTime = ?,imageName = ?,imageFile = ?,imageLength = ?,remark = ? where donationId = ?";
	private static final String DELETE = "DELETE FROM Donation WHERE donationId = ?";

	private DataSource datasource;
	
	public DonationDAOJdbc()
	{
		try
		{
			Context context = new InitialContext();
			datasource = (DataSource)context.lookup(GlobalService.JNDI);
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public DonationBean insert(DonationBean bean)
	{
		DonationBean result = null;

		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{

				pstmt.setInt(1,bean.getSchoolId());
				pstmt.setString(2,bean.getDonationStatus());
				pstmt.setString(3,bean.getSupplyName());
				pstmt.setInt(4,bean.getOriginalDemandNumber());
				pstmt.setString(5,bean.getOriginalDemandUnit());
				pstmt.setInt(6,bean.getDemandNumber());
				pstmt.setString(7,bean.getSize());
				pstmt.setString(8,bean.getDemandContent());
				pstmt.setString(9,bean.getSupplyStatus());

				pstmt.setTimestamp(10,new java.sql.Timestamp(bean.getDemandTime().getTime()));
				pstmt.setTimestamp(11,new java.sql.Timestamp(bean.getExpireTime().getTime()));
				pstmt.setString(12,bean.getImageName());
				pstmt.setBytes(13,bean.getImageFile());
				pstmt.setLong(14,bean.getImageLength());
				
				if(bean.getRemark() != null)
				{
					pstmt.setString(15,bean.getRemark());
				}
				else
				{
					pstmt.setNull(15,Types.NVARCHAR);
				}

				int count = pstmt.executeUpdate();
				if(count == 1)
				{
					ResultSet key = pstmt.getGeneratedKeys();
					if(key.next())
					{
						result = findByPrimaryKey(key.getInt(1));
					}
					System.out.println("insert success");
				}
			}

			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public DonationBean update(DonationBean bean)
	{
		DonationBean result = null;

		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{

				pstmt.setInt(1,bean.getSchoolId());
				pstmt.setString(2,bean.getDonationStatus());
				pstmt.setString(3,bean.getSupplyName());
				pstmt.setInt(4,bean.getOriginalDemandNumber());
				pstmt.setString(5,bean.getOriginalDemandUnit());
				pstmt.setInt(6,bean.getDemandNumber());
				pstmt.setString(7,bean.getSize());
				pstmt.setString(8,bean.getDemandContent());
				pstmt.setString(9,bean.getSupplyStatus());

				pstmt.setTimestamp(10,new java.sql.Timestamp(bean.getDemandTime().getTime()));
				pstmt.setTimestamp(11,new java.sql.Timestamp(bean.getExpireTime().getTime()));
				pstmt.setString(12,bean.getImageName());
				pstmt.setBytes(13,bean.getImageFile());
				pstmt.setLong(14,bean.getImageLength());
				
				if(bean.getRemark() != null)
				{
					pstmt.setString(15,bean.getRemark());
				}
				else
				{
					pstmt.setNull(15,Types.NVARCHAR);
				}
				
				pstmt.setInt(16,bean.getDonationId());

				int count = pstmt.executeUpdate();
				if(count == 1)
				{
					result = findByPrimaryKey(bean.getDonationId());
					System.out.println("update success");
				}
			}

			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public boolean delete(int donationId)
	{
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,donationId);

			int count = pstmt.executeUpdate();
			if(count == 1)
			{
				System.out.println("delete success");
				return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return false;
	}
	private static final String DEL1 = "delete from Donation where donationId=? and schoolId=?";
	public boolean delete(int donationId, int schoolId) {

		try (	Connection conn = datasource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(DEL1);) {

			pstmt.setInt(1, donationId);
			pstmt.setInt(2, schoolId);
			int count = pstmt.executeUpdate();
			if (count >= 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	@Override
	public DonationBean findByPrimaryKey(int donationId)
	{
		DonationBean bean = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PRYMARY_KEY);)
		{

			pstmt.setInt(1,donationId);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				while(rs.next())
				{
					bean = new DonationBean();

					bean.setDonationId(rs.getInt("donationId"));
					bean.setSchoolId(rs.getInt("schoolId"));
					bean.setDonationStatus(rs.getString("donationStatus"));
					bean.setSupplyName(rs.getString("supplyName"));
					bean.setOriginalDemandNumber(rs.getInt("originalDemandNumber"));
					bean.setOriginalDemandUnit(rs.getString("originalDemandUnit"));
					bean.setDemandNumber(rs.getInt("demandNumber"));
					bean.setSize(rs.getString("size"));
					bean.setDemandContent(rs.getString("demandContent"));
					bean.setSupplyStatus(rs.getString("supplyStatus"));
					bean.setDemandTime(rs.getTimestamp("demandTime"));
					bean.setExpireTime(rs.getTimestamp("expireTime"));
					bean.setImageName(rs.getString("imageName"));
					bean.setImageFile(rs.getBytes("imageFile"));
					bean.setImageLength(rs.getLong("imageLength"));
					bean.setRemark(rs.getString("remark"));
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return bean;
	}
	
	private static final String SBP1 = "select * from Donation where donationId=? and schoolId=?";
//	public DonationBean findByPrimaryKey(int donationId, int schoolId) {
//		DonationBean bean = null;
//		ResultSet rs = null;
//
//		try (	Connection conn = datasource.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(SBP1);) {
//
//			pstmt.setInt(1, donationId);
//			pstmt.setInt(2, schoolId);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				bean = new DonationBean();
//
//				bean.setDonationId(rs.getInt("donationId"));
//				bean.setSchoolId(rs.getInt("schoolId"));
//				bean.setDonationStatus(rs.getString("donationStatus"));
//				bean.setSupplyName(rs.getString("supplyName"));
//				bean.setOriginalDemandNumber(rs.getInt("originalDemandNumber"));
//				bean.setOriginalDemandUnit(rs.getString("originalDemandUnit"));
//				bean.setDemandNumber(rs.getInt("demandNumber"));
//				bean.setSize(rs.getString("size"));
//				bean.setDemandContent(rs.getString("demandContent"));
//				bean.setSupplyStatus(rs.getString("supplyStatus"));
//				bean.setDemandTime(rs.getDate("demandTime"));
//				bean.setExpireTime(rs.getDate("expireTime"));
//				bean.setImageName(rs.getString("imageName"));
//				bean.setImageFile(rs.getBytes("imageFile"));
//				bean.setImageLength(rs.getLong("imageLength"));
//				bean.setRemark(rs.getString("remark"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//		return bean;
//	}

	@Override
	public List<DonationBean> getAll()
	{
		List<DonationBean> list = new ArrayList<DonationBean>();
		DonationBean bean = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(GET_ALL);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new DonationBean();
				
				bean.setDonationId(rs.getInt("donationId"));
				bean.setSchoolId(rs.getInt("schoolId"));
				bean.setDonationStatus(rs.getString("donationStatus"));
				bean.setSupplyName(rs.getString("supplyName"));
				bean.setOriginalDemandNumber(rs.getInt("originalDemandNumber"));
				bean.setOriginalDemandUnit(rs.getString("originalDemandUnit"));
				bean.setDemandNumber(rs.getInt("demandNumber"));
				bean.setSize(rs.getString("size"));
				bean.setDemandContent(rs.getString("demandContent"));
				bean.setSupplyStatus(rs.getString("supplyStatus"));
				bean.setDemandTime(rs.getDate("demandTime"));
				bean.setExpireTime(rs.getDate("expireTime"));
				bean.setImageName(rs.getString("imageName"));
				bean.setImageFile(rs.getBytes("imageFile"));
				bean.setImageLength(rs.getLong("imageLength"));
				bean.setRemark(rs.getString("remark"));
				
				list.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return list;
	}

	public List<DonationBean> getAllByODNumber()
	{
		List<DonationBean> list = new ArrayList<DonationBean>();
		DonationBean bean = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(GET_ALL_BY_ODN);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new DonationBean();
				
				bean.setDonationId(rs.getInt("donationId"));
				bean.setSchoolId(rs.getInt("schoolId"));
				bean.setDonationStatus(rs.getString("donationStatus"));
				bean.setSupplyName(rs.getString("supplyName"));
				bean.setOriginalDemandNumber(rs.getInt("originalDemandNumber"));
				bean.setOriginalDemandUnit(rs.getString("originalDemandUnit"));
				bean.setDemandNumber(rs.getInt("demandNumber"));
				bean.setSize(rs.getString("size"));
				bean.setDemandContent(rs.getString("demandContent"));
				bean.setSupplyStatus(rs.getString("supplyStatus"));
				bean.setDemandTime(rs.getDate("demandTime"));
				bean.setExpireTime(rs.getDate("expireTime"));
				bean.setImageName(rs.getString("imageName"));
				bean.setImageFile(rs.getBytes("imageFile"));
				bean.setImageLength(rs.getLong("imageLength"));
				bean.setRemark(rs.getString("remark"));
				
				list.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return list;
	}
	
	public List<DonationBean> getAllByExpiretime()
	{
		List<DonationBean> list = new ArrayList<DonationBean>();
		DonationBean bean = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(GET_ALL_BY_EXP);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new DonationBean();
				
				bean.setDonationId(rs.getInt("donationId"));
				bean.setSchoolId(rs.getInt("schoolId"));
				bean.setDonationStatus(rs.getString("donationStatus"));
				bean.setSupplyName(rs.getString("supplyName"));
				bean.setOriginalDemandNumber(rs.getInt("originalDemandNumber"));
				bean.setOriginalDemandUnit(rs.getString("originalDemandUnit"));
				bean.setDemandNumber(rs.getInt("demandNumber"));
				bean.setSize(rs.getString("size"));
				bean.setDemandContent(rs.getString("demandContent"));
				bean.setSupplyStatus(rs.getString("supplyStatus"));
				bean.setDemandTime(rs.getDate("demandTime"));
				bean.setExpireTime(rs.getDate("expireTime"));
				bean.setImageName(rs.getString("imageName"));
				bean.setImageFile(rs.getBytes("imageFile"));
				bean.setImageLength(rs.getLong("imageLength"));
				bean.setRemark(rs.getString("remark"));
				
				list.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return list;
	}
	
	public List<DonationBean> getAllByDemandtime()
	{
		List<DonationBean> list = new ArrayList<DonationBean>();
		DonationBean bean = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(GET_ALL_BY_DET);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new DonationBean();
				
				bean.setDonationId(rs.getInt("donationId"));
				bean.setSchoolId(rs.getInt("schoolId"));
				bean.setDonationStatus(rs.getString("donationStatus"));
				bean.setSupplyName(rs.getString("supplyName"));
				bean.setOriginalDemandNumber(rs.getInt("originalDemandNumber"));
				bean.setOriginalDemandUnit(rs.getString("originalDemandUnit"));
				bean.setDemandNumber(rs.getInt("demandNumber"));
				bean.setSize(rs.getString("size"));
				bean.setDemandContent(rs.getString("demandContent"));
				bean.setSupplyStatus(rs.getString("supplyStatus"));
				bean.setDemandTime(rs.getDate("demandTime"));
				bean.setExpireTime(rs.getDate("expireTime"));
				bean.setImageName(rs.getString("imageName"));
				bean.setImageFile(rs.getBytes("imageFile"));
				bean.setImageLength(rs.getLong("imageLength"));
				bean.setRemark(rs.getString("remark"));
				
				list.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return list;
	}
	
	public static void main(String[] args)
	{
		DonationDAO daojdbc = new DonationDAOJdbc();
		/** INSERT OK **/
		DonationBean bean1 = new DonationBean();
		bean1.setSchoolId(11503);
		bean1.setDonationStatus("否");
		bean1.setSupplyName("尺");
		bean1.setOriginalDemandNumber(12);
		bean1.setOriginalDemandUnit("打");
		bean1.setDemandNumber(12);
		bean1.setSize("15公分的尺");
		bean1.setDemandContent("數學課學生沒尺可用");
		bean1.setSupplyStatus("不拘");
		try
		{
			bean1.setDemandTime(GlobalService.convertStringToDate("2015-08-24"));
			bean1.setExpireTime(GlobalService.convertStringToDate("2015-08-30"));
		}
		catch(ParseException e1)
		{
			e1.printStackTrace();
		}
		File file = new File("image/member/member02.jpg");
		try(FileInputStream fis = new FileInputStream(file);)
		{
			bean1.setImageName(file.getName());
			bean1.setImageFile(GlobalService.convertInputStreamToByteArray(fis));
			bean1.setImageLength(file.length());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		bean1.setRemark("尺的用途單純教學使用");
		bean1 = daojdbc.insert(bean1);
		System.out.println(bean1);

		/** UPDATE OK **/
		DonationBean bean2 = new DonationBean();
		bean2.setDonationId(2);
		bean2.setSchoolId(11503);
		bean2.setDonationStatus("是");
		bean2.setSupplyName("尺修");
		bean2.setOriginalDemandNumber(121);
		bean2.setOriginalDemandUnit("打1");
		bean2.setDemandNumber(132);
		bean2.setSize("15公分的尺2");
		bean2.setDemandContent("數學課學生沒尺可用3rr");
		bean2.setSupplyStatus("不拘rr");
		try
		{
			bean2.setDemandTime(GlobalService.convertStringToDate("2015-08-30"));
			bean2.setExpireTime(GlobalService.convertStringToDate("2015-08-31"));
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		file = new File("image/member/member01.jpg");
		try(FileInputStream fis = new FileInputStream(file);)
		{
			bean2.setImageName(file.getName());
			bean2.setImageFile(GlobalService.convertInputStreamToByteArray(fis));
			bean2.setImageLength(file.length());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		bean2.setRemark(null);
		daojdbc.update(bean2);

		/** DELETE OK **/
		boolean count = daojdbc.delete(100);
		System.out.println(count);

		/** SELECT_BY_PRYMARY_KEY **/
		DonationBean bean4 = new DonationBean();
		bean4 = daojdbc.findByPrimaryKey(1);
		System.out.println(bean4);

		/** GET_ALL OK **/
		List<DonationBean> list = daojdbc.getAll();
		System.out.println();
		for(DonationBean bean5 : list)
		{
			System.out.println(bean5);
		}
	}

}
