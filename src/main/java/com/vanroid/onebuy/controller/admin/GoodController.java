package com.vanroid.onebuy.controller.admin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
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

import com.vanroid.onebuy.common.Pager;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.LatestStage;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.service.GoodService;
import com.vanroid.onebuy.service.StageService;

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
			goodPager.setPageSize(2);
			
		}
		goodPager = goodService.findByPager(goodPager);
		model.addAttribute("pager", goodPager);
		return "admin/good/goods";
	}
	
	@RequestMapping(value ="/goods",method=RequestMethod.POST)
	public String goodIndexPager(@RequestParam("page") int pageIndex,Model model,Pager goodPager){
		if(goodPager.getTotalCount()==0){
			goodPager = new Pager();
			goodPager.setPageIndex(pageIndex);
			goodPager.setPageSize(1);
			
		}
		goodPager = goodService.findByPager(goodPager);
		model.addAttribute("pager", goodPager);
		return "admin/goods/goods";
	}
	
	@RequestMapping("/goods/detail/{goodId}")
	public String goodDetail(@PathVariable int goodId,Model model){
		Good good = goodService.get(goodId);
		Set<Stage> stages = good.getStages();
		LatestStage latestStage = good.getLatestStage();
		int i=0;
		if(stages!=null && latestStage!=null){
			model.addAttribute("stages", stages);
			model.addAttribute("latestStage", latestStage);
		}
		if(good!=null){
			model.addAttribute("good", good);
		}
		
		return "admin/good/good_detail";
	}
	
	@RequestMapping(value = "/goods/upload")
	@ResponseBody
	public JSONObject goodPictureUpload(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest request){
		JSONObject json = new JSONObject();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		String realPath = request.getSession().getServletContext().getRealPath("/upload/goods");
		System.out.println("realPath:"+realPath);
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> names = multiRequest.getFileNames();
			while(names.hasNext()){
				MultipartFile fileDetail = multiRequest.getFile(names.next());
				System.out.println(fileDetail.getName());
				if(fileDetail!=null){
					String fileName = fileDetail.getOriginalFilename();
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
	
	@RequestMapping("/goods/uploadPage/{goodId}")
	public String goodPhotoUploadPage(@PathVariable int goodId){
		return "admin/good/photo_upload";
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
	
}
