package com.vanroid.onebuy.core.service;

import java.util.List;

import com.vanroid.onebuy.entity.CarouselAds;

/**
 * 首页服务 
*  @company vanroid.com
 * @author cgz
 * @date 2016年2月28日
 * @version 1.0
 */
public interface IndexCoreService {

	/**
	 * 获取首页图片 
	 * @return
	 */
	public List<CarouselAds> getCarouselAdsList();

}
