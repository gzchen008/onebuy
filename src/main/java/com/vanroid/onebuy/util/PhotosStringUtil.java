package com.vanroid.onebuy.util;
/**
*@author kaiscript
*@date 2016年1月26日 下午3:24:32
*/
public class PhotosStringUtil {
	
	/**
	 * 将上传的一张新图片链接添加到旧图片数组中
	 * @param oldPhotos
	 * @param downloadUrl
	 * @return
	 */
	public static String[] addPhotoUrl(String[] oldPhotos,String downloadUrl){
		String[] newPhotos = new String[oldPhotos.length+1];
		for(int i=0;i<oldPhotos.length;i++){
			newPhotos[i] = oldPhotos[i];
		}
		newPhotos[oldPhotos.length]=downloadUrl;
		return newPhotos;
		
	}
	/**
	 * 将上传的多张新图片链接添加到旧图片数组中
	 * @param oldPhotos
	 * @param addPhotos
	 * @return
	 */
	public static String[] addPhotoUrls(String[] oldPhotos,String[] addPhotos){
		String[] newPhotos = new String[oldPhotos.length+addPhotos.length];
		for(int i=0;i<oldPhotos.length;i++){
			newPhotos[i] = oldPhotos[i];
		}
		for(int i=0;i<addPhotos.length;i++){
			newPhotos[oldPhotos.length+i]=addPhotos[i];
		}
		return newPhotos;
	}
}
