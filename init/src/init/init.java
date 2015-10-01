package init;

import java.util.Date;

public class init
{
	public static void main(String[] args)
	{
		Date start = new Date(System.currentTimeMillis());
		InsertMember.start();            //新增會員
		InsertSchool.start();			 //新增學校
		InsertSchoolDemandId.start();    //新增學校需求
		InsertPrimaryProj.start();       //新增會員的初步計畫
		InsertProcessingProj.start();    //新增會員和學校的交談過程
		InsertProcessingMember.start();  //新增學校和會員的交談過程
		InsertFullProj.start();          //新增完整計畫
		InsertParticipator.start();      //參加人
		InsertMissionBoard.start();
		InsertMissionSet.start();
		InsertMission.start();
		
		// Donation 系列 start
		InsertDonation.start();
		InsertDonationOrder.start();
		InsertDonationOrderDetail.start();
		// Donation 系列 end
		
		System.out.println("資料全部已新增");		
		Date end = new Date(System.currentTimeMillis());
		System.out.println("費時:" + (end.getTime()-start.getTime()) + "ms");
	}
}
