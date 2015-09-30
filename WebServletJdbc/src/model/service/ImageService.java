package model.service;

import model.FullProjBean;
import model.ImageHolder;
import model.PrimaryProjBean;
import model.dao.FullProjDAOJdbc;
import model.dao.PrimaryProjDAOJdbc;
import model.dao.interfaces.FullProjDAO;
import model.dao.interfaces.PrimaryProjDAO;

public class ImageService
{
	private PrimaryProjDAO primaryProjDAO;
	private FullProjDAO fullProjDAO;
	public ImageService()
	{
		primaryProjDAO = new PrimaryProjDAOJdbc();
		fullProjDAO = new FullProjDAOJdbc();
	}
	public ImageHolder getFullProjImage(int fullProjId)
	{
		FullProjBean fullProjBean = fullProjDAO.findByPrimaryKey(fullProjId);
		
		ImageHolder imageHolder = new ImageHolder();
		imageHolder.setName(fullProjBean.getFrontCoverName());
		imageHolder.setContentLength(fullProjBean.getFrontCoverLength());
		imageHolder.setContent(fullProjBean.getFrontCover());
		
		return imageHolder;
	}
	public ImageHolder getPrimaryProjImage(int primaryProjId)
	{
		PrimaryProjBean PrimaryProjBean = primaryProjDAO.findByPrimaryKey(primaryProjId);
		
		ImageHolder imageHolder = new ImageHolder();
		imageHolder.setName(PrimaryProjBean.getFrontCoverName());
		imageHolder.setContentLength(PrimaryProjBean.getFrontCoverLength());
		imageHolder.setContent(PrimaryProjBean.getFrontCover());
		
		return imageHolder;
	}
	
	public static void main(String[] args)
	{

	}

}
