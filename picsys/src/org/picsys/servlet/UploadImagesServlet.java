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
 * �ϴ�ͼƬServlet
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
		//��ȡ��ͼƬ����������
		String pic=  smartUpload.getRequest().getParameter("content");
		String _pic =new String(pic.trim().getBytes(),"utf-8");
		System.out.println("pic:"+_pic);
		//��ȡ��һ���ϴ����ļ�
		File file = smartUpload.getFiles().getFile(0);  
		String  webPath =request.getServletContext().getRealPath("/");
		String address="";
		if(!file.isMissing()){
			//��ȡ��ǰʱ�䣬��ΪͼƬ�������֣����ʹ��ԭ���ֿ��ܸ��Ƿ������ϵ�ͼƬ ��ȷ��ͼƬΨһ��
			String picname = new Date().getTime() + "";  
			java.io.File webFile=new java.io.File(webPath+"/images");
			if(!webFile.exists()){
				webFile.mkdirs();
			}
			
			address="/images/"+picname+"."+file.getFileExt();
			
			
			try {
				
				file.saveAs(address, File.SAVEAS_VIRTUAL);
			} catch (SmartUploadException e) {
				System.out.println("�ϴ�ͼƬ����������г����쳣");
				e.printStackTrace();
			}
		}
		HashMap  map=new HashMap();
		map.put("url", webPath+address);
		BeanJsonUtil.writeJson(response, map);
	
		
		
	}
}
