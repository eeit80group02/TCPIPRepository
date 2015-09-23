package init;

public class init
{

	private String test = "hahaha";
	public static void main(String[] args)
	{
		InsertMember.start();
		InsertSchool.start();
		InsertSchoolDemandId.start();
		InsertPrimaryProj.start();
		InsertProcessingProj.start();
		InsertFullProj.start();
		InsertParticipator.start();
		InsertMissionBoard.start();
		InsertMissionSet.start();
		InsertMission.start();
		System.out.println("資料全部已新增");
	}
}
