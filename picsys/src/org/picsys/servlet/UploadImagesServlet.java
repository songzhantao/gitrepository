package org.picsys.servlet;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.picsys.utils.BeanJsonUtil;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * 上传图片Servlet
 * @author Lanqiao08
 *
 */
@WebServlet("/upload.jhtml")
public class UploadImagesServlet extends  HttpServlet  {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SmartUpload  smartUpload=new  SmartUpload();
		smartUpload.initialize(getServletConfig(),request, response);
		smartUpload.setMaxFileSize(2*1024*1024);
		smartUpload.setAllowedFilesList("jpg,png,gif");
		try {
			smartUpload.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		//获取非图片表单区域内容
		String pic=  smartUpload.getRequest().getParameter("content");
		String _pic =new String(pic.trim().getBytes(),"utf-8");
		System.out.println("pic:"+_pic);
		//获取第一个上传的文件
		File file = smartUpload.getFiles().getFile(0);  
		String  webPath =request.getServletContext().getRealPath("/");
		String address="";
		if(!file.isMissing()){
			//获取当前时间，作为图片的新名字，如果使用原名字可能覆盖服务器上的图片 ，确保图片唯一性
			String picname = new Date().getTime() + "";  
			java.io.File webFile=new java.io.File(webPath+"/images");
			if(!webFile.exists()){
				webFile.mkdirs();
			}
			
			address="/images/"+picname+"."+file.getFileExt();
			
			
			try {
				
				file.saveAs(address, File.SAVEAS_VIRTUAL);
			} catch (SmartUploadException e) {
				System.out.println("上传图片，保存过程中出现异常");
				e.printStackTrace();
			}
		}
		HashMap  map=new HashMap();
		map.put("url", webPath+address);
		BeanJsonUtil.writeJson(response, map);
	
		
		
	}
}
