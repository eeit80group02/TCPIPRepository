package init;

public class init
{

	public static void main(String[] args)
	{
		InsertMember.start();
		InsertSchool.start();
		InsertPrimaryProj.start();
		InsertProcessingProj.start();
		InsertFullProj.start();
		System.out.println("資料全部已新增");
	}
}
