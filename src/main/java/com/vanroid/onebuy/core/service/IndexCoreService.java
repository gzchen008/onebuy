package com.vanroid.onebuy.core.service;

import java.util.List;

import com.vanroid.onebuy.entity.CarouselAds;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.Stage;

/**
 * 首页服务
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年2月28日
 * @version 1.0
 */
public interface IndexCoreService {

	public static final int RECOMD_PAGE_SIZE = 10;

	/**
	 * 获取首页图片
	 * 
	 * @return
	 */
	public List<CarouselAds> getCarouselAdsList();

	/**
	 * 获取推荐商品列表
	 * 
	 * @param pageNum
	 *            页码
	 * @return
	 */
	public List<Good> getRecommendGoodList(int pageNum);

	/**
	 * 获取推荐期列表
	 * @param i
	 * @return
	 */
	public List<Stage> getRecommendStageList(int pageNum);

	/**
	 * 获取最新上架的商品
	 * @param size 条数
	 * @return
	 */
	public List<Good> getNewGoodList(int size);

}
