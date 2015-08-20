package model;

public class DntDetailBean 
{
	private int donationId;              //  捐獻編號(流水號) FK
	private int memberId;             	 //  會員編號  FK
	private java.util.Date tpick;     	 //  收件時間(由欲捐獻會員填寫)
	private String name;              	 //  寄件人姓名(由欲捐獻會員填寫)
	private String address;              //  地址(由欲捐獻會員填寫)
	private String phone;              	 //  電話(由欲捐獻會員填寫)
	private String cellPhone;            //  手機(由欲捐獻會員填寫)
	private String email;              	 //  E-mail(由欲捐獻會員填寫)
	private int dntQty;              	 //  會員捐贈數量(數量)
	private String dealId;               //  交易編號(出貨單號)
}

	