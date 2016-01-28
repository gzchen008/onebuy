package com.vanroid.onebuy.controller.admin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.mysql.jdbc.log.Log;
import com.vanroid.onebuy.common.Pager;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.service.GoodService;
import com.vanroid.onebuy.service.StageService;
import com.vanroid.onebuy.util.DateUtil;

import net.sf.json.JSONObject;

/**
*@author kaiscript
*@date 2016年1月19日 下午9:54:51
*/
@Controller
@RequestMapping(value = "/admin")
public class GoodController {
	
	@Resource(name = "goodService")
	private GoodService goodService;
	@Resource(name = "stageService")
	private StageService stageService;
	
	@RequestMapping(value = "/goods",method=RequestMethod.GET)
	public String goodIndex(Model model,Pager goodPager,HttpServletRequest request){
		if(goodPager.getTotalCount()==0){
			goodPager = new Pager();
			goodPager.setPageIndex(1);
			goodPager.setPageSize(4);
			
		}
		goodPager = goodService.findByPager(goodPager);
		model.addAttribute("pager", goodPager);
		return "admin/good/goods";
	}
	
	@RequestMapping(value ="/goodsto",method=RequestMethod.GET)
	public String goodIndexPager(@RequestParam("page") int pageIndex,Model model,Pager goodPager){

		if(goodPager.getTotalCount()==0){
			goodPager = new Pager();
			goodPager.setPageIndex(pageIndex);
			goodPager.setPageSize(4);
			
		}
		goodPager = goodService.findByPager(goodPager);
		model.addAttribute("pager", goodPager);
		return "admin/good/goods";
	}
	
	@RequestMapping("/goods/detail/{goodId}")
	public String goodDetail(@PathVariable int goodId,Model model){
		Good good = goodService.get(goodId);
		Set<Stage> stages = good.getStages();
		Stage latestStage = null;
		latestStage = stageService.getLastStageByGoodId((long) goodId);
		model.addAttribute("latestStage", latestStage);
		model.addAttribute("stages", stages);
		if(good!=null){
			model.addAttribute("good", good);
		}
		
		return "admin/good/good_detail";
	}
	
	/**
	 * 创建商品页面
	 * @return
	 */
	@RequestMapping("/goods/create")
	public String createGood(){
		return "admin/good/create_good";
	}
	
	/**
	 * 增加新的商品
	 * @return
	 */
	@RequestMapping("/goods/creating")
	public String createGoodWithParm(String goodName,String goodDescription,
			String url,String mainUrl,Model model){
		Good good ;
		good = (Good) goodService.getGoodByNameAndDescription(goodName, goodDescription);
		if(good.getId()!=0){//已创建该商品
			return "";
		}
		good = new Good();
		good.setName(goodName);
		good.setDescription(goodDescription);
		good.setTime(DateUtil.getDate());
		good.setMainPhoto(mainUrl);
		good.setDetailPhotos(url.split(","));
		goodService.add(good);
		good = goodService.findByExampleGood(good);
		Stage stage = new Stage();
		stage.setCreateTime(DateUtil.getDate());
		stage.setNum(1);
		stage.setPrice(0);
		stage.setPurchasedQuantity(0);
		stage.setQuantity(1);
		stage.setStatus(0);
		stage.setTotalPrice(0);
		stage.setGood(good);
		stageService.add(stage); //级联会更新good
		
		return "redirect:/admin/goods/detail/"+good.getId();
	}
	
	/**
	 * 编辑商品页面
	 * @param goodId
	 * @param model
	 * @return
	 */
	@RequestMapping("/goods/edit/{goodId}")
	public String editGood(@PathVariable int goodId,Model model){
		Good good = goodService.get(goodId);
		model.addAttribute("good", good);
		return "admin/good/edit_good";
	}
	
	@RequestMapping("/goods/update/{goodId}")
	public String updateGood(String goodName,String goodDescription,@PathVariable int goodId){
		Good good = goodService.get(goodId);
		if(good!=null){
			good.setName(goodName);
			good.setDescription(goodDescription);
			goodService.update(good);
		}
		return "redirect:/admin/goods/detail/"+goodId;
	}
	
	/**
	 * 上传图片页面
	 * @param goodId
	 * @param model
	 * @return
	 */
	@RequestMapping("/goods/uploadPage/{goodId}")
	public String goodPhotoUploadPage(@PathVariable int goodId,Model model){
		Good good = goodService.get(goodId);
		String[] photos =good.getDetailPhotos();
		
		model.addAttribute("good", good);
		model.addAttribute("photos", photos);
		return "admin/good/photo_upload";
	}
	
	/**
	 * 增加新的一期页面
	 * @return
	 */
	@RequestMapping("/goods/stage/create/{goodId}")
	public String goodCreateStagePage(@PathVariable int goodId,Model model){
		model.addAttribute("goodId", goodId);
		return "admin/good/create_stage";
	}
	
	/**
	 * 根据商品id 创建新的一期
	 */
	@RequestMapping("/goods/stage/creating/{goodId}")
	public String goodCreateStage(@PathVariable int goodId,String totalPrice,String quantity,
			Model model){
		Good good = goodService.get(goodId);
		int num = good.getStages().size()+1;
		int itotalPrice = Integer.valueOf(totalPrice);
		int iquantity = Integer.valueOf(quantity);
		Stage stage = new Stage();
		stage.setGood(good);
		stage.setTotalPrice(itotalPrice);
		stage.setPurchasedQuantity(0);
		stage.setQuantity(iquantity);
		stage.setPrice(itotalPrice/iquantity);
		stage.setNum(num);
		stage.setStatus(1);
		stage.setCreateTime(DateUtil.getDate());
		stageService.add(stage);
		//待增加  期数缓存操作
		return "redirect:/admin/stages/latest"; //要写成跳转到 新期列表
	}
	
	

	/**
	 * 上传图片到项目
	 * @param file
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/goods/upload")
	@ResponseBody
	public JSONObject goodPictureUpload(@RequestParam("file")CommonsMultipartFile file,
			HttpServletRequest request,@RequestParam("id")int id){
		JSONObject json = new JSONObject();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		Good good =goodService.get(id);
		String realPath = request.getSession().getServletContext().getRealPath("/upload/goods");
		String[] oldPicture = good.getDetailPhotos();//商品的图片数组
		System.out.println("realPath:"+realPath);
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> names = multiRequest.getFileNames();
			String pictureNames ="";//新增的图片文件名
			while(names.hasNext()){
				MultipartFile fileDetail = multiRequest.getFile(names.next());
				if(fileDetail!=null){
					String fileName = fileDetail.getOriginalFilename();
					pictureNames+=fileName+",";
					File uploadfile = new File(realPath+"/"+fileName);
					try {
						fileDetail.transferTo(uploadfile);
					} catch (Exception e) {
						json.put("message", "fail");
						e.printStackTrace();
						return json;
					}
				}
			}
			/**
			 * 将新老图片地址放到新String[]，并保存
			 */
			if(!pictureNames.equals("")){
				int oldPictureLength;
				oldPictureLength = (oldPicture==null)?0:oldPicture.length;
				String[] addPicture=pictureNames.split(",");
				String[] newPicture=new String[oldPictureLength+addPicture.length]; 
				for(int i=0;i<oldPictureLength;i++){
					newPicture[i] = oldPicture[i];
				}
				for(int i=0;i<addPicture.length;i++){
					newPicture[oldPictureLength+i]=addPicture[i];
				}
				good.setDetailPhotos(newPicture);
				goodService.update(good);
			}
			
			
		}
		json.put("message", "success");
		return json;
		
	}
	
	@RequestMapping("/goods/upload2")  
	public String uploadFile(@RequestParam("file") CommonsMultipartFile file,  
	        HttpServletRequest request) throws IOException {  
	    System.out.println("fileName : " + file.getOriginalFilename());  
	  
	    if (!file.isEmpty()) {  
	        BufferedOutputStream bos = new BufferedOutputStream(  
	                new FileOutputStream(request.getSession().getServletContext().getRealPath("/upload/goods")+"/" + file.getOriginalFilename()));  
	        InputStream in = file.getInputStream();  
	        BufferedInputStream bis = new BufferedInputStream(in);  
	        int n = 0;  
	        byte[] b = new byte[1024];  
	        while ((n = bis.read(b)) != -1) {  
	            bos.write(b, 0, n);  
	        }  
	        bos.flush();  
	        bos.close();  
	        bis.close();  
	    }  
	    System.out.println("cg");
	    return "/success";  
	}  
	
	//test
	@RequestMapping(value ="/pager",method=RequestMethod.GET)
	public String goodTextPager(@RequestParam("page") int pageIndex,Model model,Pager goodPager){
		if(goodPager.getTotalCount()==0){
			goodPager = new Pager();
			goodPager.setPageIndex(pageIndex);
			goodPager.setPageSize(1);
			
		}
		goodPager = goodService.findByPager(goodPager);
		model.addAttribute("pager", goodPager);
		return "admin/test/pagerTest";
	}
	
	//text
	@RequestMapping("/goods/{goodId}")
	public String text(@PathVariable int goodId){
		Good good = goodService.get(goodId);
		return "admin/good/create_stage";
	}
	
}
