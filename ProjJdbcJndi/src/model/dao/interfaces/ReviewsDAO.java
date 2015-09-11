package model.dao.interfaces;

import java.util.List;

import model.ReviewsBean;

public interface ReviewsDAO
{

	public List<ReviewsBean> getAll();

	public ReviewsBean findByPrimaryKey(int reviewsId);

	public ReviewsBean insert(ReviewsBean bean);

	public ReviewsBean update(ReviewsBean bean);

	public boolean delete(int reviewsId);

}