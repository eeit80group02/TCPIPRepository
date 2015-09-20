package model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.dao.DonationDAOJdbc;
import model.dao.DonationDiscussDAOJdbc;
import model.dao.DonationOrderDAOJdbc;
import model.dao.DonationOrderDetailDAOJdbc;
import model.dao.SchoolDAOJdbc;

public class DonationService {
	private DonationDAOJdbc donationDAOJdbc;
	private DonationBean donationBean;
	
	private DonationDiscussDAOJdbc donationDiscussDAOjdbc;
	private DonationDiscussBean donationDiscussBean;
	
	private DonationOrderDAOJdbc donationOrderDAOJdbc;
	private DonationOrderDetailDAOJdbc donationOrderDetailDAOJdbc;
	
	// 學校新增需求
	public DonationBean saveDemand(DonationBean donationBean) {
		if (donationBean != null) {
			donationDAOJdbc  = new DonationDAOJdbc();
			donationBean = donationDAOJdbc.insert(donationBean);
			if (donationBean != null) {
				return donationBean;
			}
		}
		return null;
	}
	public DonationBean updateDemandByMember(DonationBean donationBean) {
		if (donationBean != null) {
			donationDAOJdbc  = new DonationDAOJdbc();
			donationBean = donationDAOJdbc.update(donationBean);
			if (donationBean != null) {
				return donationBean;
			}
		}

		return null;
	}
	public boolean deleteDemand(int donationId, int schoolId) {
		boolean result = false;
		
		// "進行交易設定"
		
		// 先刪訂單明細
		// 1.取出所有的訂單明細
		donationOrderDetailDAOJdbc = new DonationOrderDetailDAOJdbc();
		List<DonationOrderDetailBean> list = donationOrderDetailDAOJdbc.getAll();
		for(DonationOrderDetailBean d : list) {
			// 2.找出與donationId相同訂單明細
			if (d.getDonationId() == donationId) {
				// 3.進行刪除
				boolean b = donationOrderDetailDAOJdbc.delete(d.getDonationOrderDetailId());
				System.out.println("訂單明細是否刪除: "+ b);
			}
		}
		
		// 留言也要一起刪，DELETE 陳述式與 REFERENCE 條件約束 "FK__DonationD__donat__22800C64" 衝突。衝突發生在資料庫 "TCPIP"，資料表 "dbo.DonationDiscuss", column 'donationId'。
		donationDiscussDAOjdbc = new DonationDiscussDAOJdbc();
		// 1.先取所有留言
		donationDiscussBean = new DonationDiscussBean();
		List<DonationDiscussBean> discussBeanList = donationDiscussDAOjdbc.getAll();
		for (DonationDiscussBean d : discussBeanList) {
			// 2.找出與donationId相同的留言
			if (d.getDonationId() == donationId) {
				// 3.進行刪除
				boolean b = donationDiscussDAOjdbc.delete(d.getDonationDiscussId());
				System.out.println("捐獻留言是否刪除: "+ b);
			}
		}
		
		// 後刪學校
		donationDAOJdbc = new DonationDAOJdbc();
		result = donationDAOJdbc.delete(donationId, schoolId);
		if (result != false) {
			System.out.println("捐獻需求是否刪除: "+ result);
			return result;
		}
		return false;
	}
	
	// 待修
	public DonationBeanDuplicate findOneDemand(int donationId){
		donationDAOJdbc = new DonationDAOJdbc();
		DonationBean odb = donationDAOJdbc.findByPrimaryKey(donationId);
		
		SchoolDAOJdbc schoolDAO = new SchoolDAOJdbc();
		SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
		String schoolName = sBean.getName();
		
		DonationBeanDuplicate dbdc = new DonationBeanDuplicate();
		dbdc.setDonationId(odb.getDonationId());
		dbdc.setSchoolId(odb.getSchoolId());
		dbdc.setSchoolName(schoolName);
		dbdc.setDonationStatus(odb.getDonationStatus());
		dbdc.setSupplyName(odb.getSupplyName());
		dbdc.setOriginalDemandNumber(odb.getOriginalDemandNumber());
		dbdc.setOriginalDemandUnit(odb.getOriginalDemandUnit());
		dbdc.setDemandNumber(odb.getDemandNumber());
		// 預設為 1
		dbdc.setDonateAmount(1);
		dbdc.setSize(odb.getSize());
		dbdc.setDemandContent(odb.getDemandContent());
		dbdc.setSupplyStatus(odb.getSupplyStatus());
		dbdc.setRemark(odb.getRemark());
		
		return dbdc;
	}
	
	// 包裝資料
	public DonationBean UpdateOneDemandBySchool(DonationBean donationBeanInput) {
		
		if (donationBeanInput.getDonationId() != 0 && donationBeanInput.getSchoolId() != 0) {
			donationDAOJdbc  = new DonationDAOJdbc();
			donationBean = donationDAOJdbc.findByPrimaryKey(donationBeanInput.getDonationId());
			
			// 資料包裝
			donationBean.setDonationId(donationBean.getDonationId());
			// 捐獻是否完成由捐贈系統設定，預設在新增時為否
			donationBean.setOriginalDemandUnit(donationBeanInput.getOriginalDemandUnit());
			donationBean.setSupplyName(donationBeanInput.getSupplyName());
			int i;
			// 如果更新的數量 大於原本填寫的需求數量
			if (donationBeanInput.getOriginalDemandNumber() >= donationBean.getOriginalDemandNumber()) {
				i = donationBeanInput.getOriginalDemandNumber() - donationBean.getOriginalDemandNumber();
				donationBean.setDemandNumber(donationBean.getDemandNumber() + i);
			}
			
			donationBean.setOriginalDemandNumber(donationBeanInput.getOriginalDemandNumber());
			donationBean.setSize(donationBeanInput.getSize());
			donationBean.setDemandContent(donationBeanInput.getDemandContent());
			donationBean.setSupplyStatus(donationBeanInput.getSupplyStatus());
			// 圖片處理
			// 更新時有傳圖片
			if (donationBeanInput.getImageLength() != 0) {
				donationBean.setImageName(donationBeanInput.getImageName());
				donationBean.setImageFile(donationBeanInput.getImageFile());
				donationBean.setImageLength(donationBeanInput.getImageLength());
			}
			
			donationBean.setRemark(donationBeanInput.getRemark());
			
			// 再 UPDATE
			donationDAOJdbc = new DonationDAOJdbc();
			donationBean = donationDAOJdbc.update(donationBean);
			if (donationBean != null) {
				return donationBean;
			}
			
		}
		return donationBean;
	}
	public List<DonationBeanDuplicate> findOneAllDeamndByMember(int schoolId) {
		// 比對schoolId後得到一間學校所有捐獻
		List<DonationBean> resultDisplay = new ArrayList<>();
		
		donationDAOJdbc  = new DonationDAOJdbc();
		List<DonationBean> result = new ArrayList<>();
		result = donationDAOJdbc.getAll();
		for (DonationBean d : result) {
			if (schoolId == d.getSchoolId() && d.getDonationStatus().equals("否")) {
				resultDisplay.add(d);
			}
		}
		
		// 包裝一間學校所有捐獻
		List<DonationBeanDuplicate> listDuplivate = new ArrayList<>();
		DonationBeanDuplicate donationBeanDuplicate;
		
		SchoolService schoolService = new SchoolService();
		SchoolBean schoolBean;
		for (DonationBean d : resultDisplay) {
			donationBeanDuplicate = new DonationBeanDuplicate();
			donationBeanDuplicate.setDonationId(d.getDonationId());
			donationBeanDuplicate.setSchoolId(d.getSchoolId());
			// 取出 schoolName
			schoolBean = schoolService.getSchoolData(d.getSchoolId());
			if (schoolBean != null) {
				donationBeanDuplicate.setSchoolName(schoolBean.getName());
			} else {
				System.out.println("系統錯誤");
				return null;
			}
			
			donationBeanDuplicate.setDonationStatus(d.getDonationStatus());
			donationBeanDuplicate.setSupplyName(d.getSupplyName());
			donationBeanDuplicate.setOriginalDemandNumber(d.getOriginalDemandNumber());
			donationBeanDuplicate.setOriginalDemandUnit(d.getOriginalDemandUnit());
			donationBeanDuplicate.setDemandNumber(d.getDemandNumber());
			// NEW 預設為1
			donationBeanDuplicate.setDonateAmount(1);
			donationBeanDuplicate.setSize(d.getSize());
			donationBeanDuplicate.setDemandContent(d.getDemandContent());
			donationBeanDuplicate.setSupplyStatus(d.getSupplyStatus());
			// ADD
			donationBeanDuplicate.setDemandTime(d.getDemandTime());
			donationBeanDuplicate.setExpireTime(d.getExpireTime());
			donationBeanDuplicate.setImageName(d.getImageName());
			donationBeanDuplicate.setImageFile(d.getImageFile());
			donationBeanDuplicate.setImageLength(d.getImageLength());
			donationBeanDuplicate.setRemark(d.getRemark());
			listDuplivate.add(donationBeanDuplicate);
		}
		return listDuplivate;
	}
	public List<DonationBeanDuplicate> findOneAllDeamndBySchool(int schoolId) {
		// 比對schoolId後得到一間學校所有捐獻
		List<DonationBean> resultDisplay = new ArrayList<>();
		
		donationDAOJdbc  = new DonationDAOJdbc();
		List<DonationBean> result = new ArrayList<>();
		result = donationDAOJdbc.getAll();
		for (DonationBean d : result) {
			if (schoolId == d.getSchoolId() && d.getDonationStatus().equals("否")) {
				resultDisplay.add(d);
			}
		}
		
		// 包裝一間學校所有捐獻
		List<DonationBeanDuplicate> listDuplivate = new ArrayList<>();
		DonationBeanDuplicate donationBeanDuplicate;
		
		SchoolService schoolService = new SchoolService();
		SchoolBean schoolBean;
		for (DonationBean d : resultDisplay) {
			donationBeanDuplicate = new DonationBeanDuplicate();
			donationBeanDuplicate.setDonationId(d.getDonationId());
			donationBeanDuplicate.setSchoolId(d.getSchoolId());
			// 取出 schoolName
			schoolBean = schoolService.getSchoolData(d.getSchoolId());
			if (schoolBean != null) {
				donationBeanDuplicate.setSchoolName(schoolBean.getName());
			} else {
				System.out.println("系統錯誤");
				return null;
			}
			
			donationBeanDuplicate.setDonationStatus(d.getDonationStatus());
			donationBeanDuplicate.setSupplyName(d.getSupplyName());
			donationBeanDuplicate.setOriginalDemandNumber(d.getOriginalDemandNumber());
			donationBeanDuplicate.setOriginalDemandUnit(d.getOriginalDemandUnit());
			donationBeanDuplicate.setDemandNumber(d.getDemandNumber());
			// NEW 預設為1
			donationBeanDuplicate.setDonateAmount(1);
			donationBeanDuplicate.setSize(d.getSize());
			donationBeanDuplicate.setDemandContent(d.getDemandContent());
			donationBeanDuplicate.setSupplyStatus(d.getSupplyStatus());
			// ADD
			donationBeanDuplicate.setDemandTime(d.getDemandTime());
			donationBeanDuplicate.setExpireTime(d.getExpireTime());
			donationBeanDuplicate.setImageName(d.getImageName());
			donationBeanDuplicate.setImageFile(d.getImageFile());
			donationBeanDuplicate.setImageLength(d.getImageLength());
			donationBeanDuplicate.setRemark(d.getRemark());
			listDuplivate.add(donationBeanDuplicate);
		}
		return listDuplivate;
	}
	public List<DonationBean> findDemands() {
		List<DonationBean> result = new ArrayList<>();
		donationDAOJdbc  = new DonationDAOJdbc();
		result = donationDAOJdbc.getAll();
		return result;
	}
	
	public List<DonationBeanDuplicate> findDemandsByMember() {
		donationDAOJdbc  = new DonationDAOJdbc();
		
		// 取出原始刊登的捐獻需求
		List<DonationBean> list = donationDAOJdbc.getAll();
		// 包裝原始刊登的捐獻需求
		List<DonationBeanDuplicate> listDuplivate = new ArrayList<>();
		SchoolBean schoolBean;
		if (list != null) {
			// 包裝從資料庫取出的DonationBean為DonationBeanDuplicate
			DonationBeanDuplicate donationBeanDuplicate;
			for (DonationBean d : list) {
				if (d.getDonationStatus().equals("否")) {
					donationBeanDuplicate = new DonationBeanDuplicate();
					donationBeanDuplicate.setDonationId(d.getDonationId());
					donationBeanDuplicate.setSchoolId(d.getSchoolId());
					
					SchoolService schoolService = new SchoolService();
					// 依 SchoolId取出SchoolName
					schoolBean = schoolService.getSchoolData(d.getSchoolId());
					if (schoolBean != null) {
						// 存取SchoolName
						donationBeanDuplicate.setSchoolName(schoolBean.getName());
					} else {
						System.out.println("系統錯誤");
						return null;
					}
					donationBeanDuplicate.setDonationStatus(d.getDonationStatus());
					donationBeanDuplicate.setSupplyName(d.getSupplyName());
					donationBeanDuplicate.setOriginalDemandNumber(d.getOriginalDemandNumber());
					donationBeanDuplicate.setOriginalDemandUnit(d.getOriginalDemandUnit());
					donationBeanDuplicate.setDemandNumber(d.getDemandNumber());
					// 預設會員的捐獻數量為1
					donationBeanDuplicate.setDonateAmount(1);
					donationBeanDuplicate.setSize(d.getSize());
					donationBeanDuplicate.setDemandContent(d.getDemandContent());
					donationBeanDuplicate.setSupplyStatus(d.getSupplyStatus());
					
					donationBeanDuplicate.setDemandTime(d.getDemandTime());
					donationBeanDuplicate.setExpireTime(d.getExpireTime());
					donationBeanDuplicate.setImageName(d.getImageName());
					donationBeanDuplicate.setImageFile(d.getImageFile());
					donationBeanDuplicate.setImageLength(d.getImageLength());
					donationBeanDuplicate.setRemark(d.getRemark());
					listDuplivate.add(donationBeanDuplicate);//16->18
				}
			}
		}
		return listDuplivate;
	}
	
	// 會員新增訂單
	public boolean saveBooking(DonationOrderBean donationOrderBean, 
			List<DonationOrderDetailBean> list) {
		boolean result = false;
		donationOrderDAOJdbc = new DonationOrderDAOJdbc();
		
		// "設定交易"
		
		// 新增訂單主檔
		donationOrderBean = donationOrderDAOJdbc.insert(donationOrderBean);
		if (donationOrderBean != null) {
			// 取得自增主鍵
			int pk = donationOrderBean.getDonationOrderId();
			for (DonationOrderDetailBean d : list) {
				// 將所有明細設定自增主鍵
				d.setDonationOederId(pk);
				donationOrderDetailDAOJdbc = new DonationOrderDetailDAOJdbc();
				donationOrderDetailDAOJdbc.insert(d);
				// 新增訂單明細
				System.out.println("訂單新增成功");
				result = true;
			}
		} else {
			System.out.println("Not success in DonationService");
		}
		return result;
	}
	public void bookingOrder(DonationOrderBean donationOrderBean, DonationCart dCart) {
		
		// 真正要進資料庫儲存的捐贈明細資料(OrderDetailBeanBean)
		List<DonationOrderDetailBean> orderDetailList = new ArrayList<>();
		DonationOrderDetailBean donationOrderDetailBean;
		
		// 經過資料轉換，需要更新的Donation(Part)
		List<DonationBean> donationBeanListPart = new ArrayList<>();
		
		// 資料交換 MAP 轉 List
		// 捐贈車裡所有包裝
		Map<Integer,DonationBeanDuplicate> maps = dCart.getContent();
		Set<Integer> sets = maps.keySet();
		for (Integer i : sets) {
			// 將duplicate資料取出作後面運用
			DonationBeanDuplicate duplicate = maps.get(i);
			
			// a.訂單明細封裝
			donationOrderDetailBean = new DonationOrderDetailBean();
			//donationOederId 為交易時取出的pk鍵
			donationOrderDetailBean.setDonationId(duplicate.getDonationId());
			// 作字串處理
			donationOrderDetailBean.setSupplyName(duplicate.getSupplyName()+" "+duplicate.getSchoolName());
			donationOrderDetailBean.setDonationAmount(duplicate.getDonateAmount());
			orderDetailList.add(donationOrderDetailBean);
			
			// b.原始需求數量更新
			DonationBean donationBeanPart = new DonationBean();
			donationBeanPart.setDonationId(duplicate.getDonationId());
			donationBeanPart.setSchoolId(duplicate.getSchoolId());
			// 進行狀態的邏輯判斷if (x-y != 0)...
			if (duplicate.getDemandNumber() - duplicate.getDonateAmount() <= 0) {
				donationBeanPart.setDonationStatus("是");
			} else {
				donationBeanPart.setDonationStatus("否");
			}
			
			donationBeanPart.setSupplyName(duplicate.getSupplyName());
			donationBeanPart.setOriginalDemandNumber(duplicate.getOriginalDemandNumber());
			donationBeanPart.setOriginalDemandUnit(duplicate.getOriginalDemandUnit());
			// 進行狀態的邏輯運算
			// 系統改設等於原始需求數量
			donationBeanPart.setDemandNumber(duplicate.getDemandNumber() - duplicate.getDonateAmount());
			donationBeanPart.setSize(duplicate.getSize());
			donationBeanPart.setDemandContent(duplicate.getDemandContent());
			donationBeanPart.setSupplyStatus(duplicate.getSupplyStatus());
			donationBeanPart.setDemandTime(duplicate.getDemandTime());
			donationBeanPart.setExpireTime(duplicate.getExpireTime());
			donationBeanPart.setImageName(duplicate.getImageName());
			donationBeanPart.setImageFile(duplicate.getImageFile());
			donationBeanPart.setImageLength(duplicate.getImageLength());
			donationBeanPart.setRemark(duplicate.getRemark());
			donationBeanListPart.add(donationBeanPart);
		}
		
		// 進行交易
		// 1.新增捐贈 主檔與副檔
		// ***交易控制
		boolean b = this.saveBooking(donationOrderBean, orderDetailList);
		System.out.println("新增主副檔:"+b);
		
		// 2.更新Donation表
		// 從資料庫抓出所有捐贈資料，需要更新的Donation(Orgin)
		List<DonationBean> donationBeanListOrgin = this.findDemands();
		
		// 3. 產生要更新的DonationBean
		List<DonationBean> donationBeanListUpdate = new ArrayList<>();
		
		for (DonationBean od : donationBeanListOrgin) {
			for (DonationBean pd : donationBeanListPart) {
				if (od.getDonationId() == pd.getDonationId()) {
					// 包裝轉換
					od.setDonationStatus(pd.getDonationStatus());
					od.setDemandNumber(pd.getDemandNumber());
					
					// select出imgFile/imgLength/imgName
					this.updateDemandByMember(od);
					System.out.println("schoolId:"+pd.getSchoolId()+"受到更新");
				}
			}
		}

		
	}
}
