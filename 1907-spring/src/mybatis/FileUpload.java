package mybatis;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Page;

import org.apache.commons.fileupload.*;

public class FileUpload {
	   public static String upload = "C:\\Users\\김도경\\git\\Spring\\1907-spring\\WebContent\\upload\\";
	   String tempDir = "c:/temp2/";
	   
	   int maxSize=1024*1024*50;
	   HttpServletRequest req;
	   HttpServletResponse resp;
	   
	   public FileUpload(HttpServletRequest req, HttpServletResponse resp) {
	      this.req = req;
	      this.resp = resp;
	   }
	   
	   public boolean uploadFormCheck() { // enctype 이 enctype='multipart/form-data'인가 체크
	      boolean flag = ServletFileUpload.isMultipartContent(req);
	      
	      return flag;
	   }
	   
	   public HttpServletRequest uploading() {
	      BoardVo vo = new BoardVo();
	      List<AttVo> attList = new ArrayList<AttVo>();
	      List<AttVo> delList = new ArrayList<AttVo>();
	      Page p = new Page();
	      
	      DiskFileItemFactory factory = new DiskFileItemFactory(); // 아파치에 파일업로드를 하기위한 클래스
	      factory.setSizeThreshold(4096); // 파일 업로드할때 사용할 버퍼 메모리 크기
	      factory.setRepository(new File(tempDir));// 업로드 중에 파일이 저장되는 공간
	      
	      ServletFileUpload sf = new ServletFileUpload(factory);
	      sf.setHeaderEncoding("utf-8");
	      sf.setFileSizeMax(maxSize);
	      
	      try {
	         List<FileItem> list = sf.parseRequest(req);
	         for(FileItem fi : list) {
	            String v = fi.getString("utf-8"); // 이건 value값
	            String k = fi.getFieldName(); // 입력 태그의 이름
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            if(fi.isFormField()) { // input type 인가?
	               switch(k) {
	               case "id": // <input type = 'text' name='mId'/> 인가
	                  vo.setId(v); break;
	               case "pwd":
	                  vo.setPwd(v); break;
	               case "subject" :
	                  vo.setSubject(v); 
	                  break;
	               case "content" :
	                  vo.setContent(v); 
	                  break;
	               case "mDate" :
	                  vo.setmDate(v);
	                  break;
	               case "serial":
	                  vo.setSerial(Integer.parseInt(v));break;
	               case "pSerial":
	                  vo.setpSerial(Integer.parseInt(v));break;
	               case "delFile":
	                  AttVo attVo = new AttVo();
	                  attVo.setSysFile(v);
	                  delList.add(attVo); break;
	                  
	               case "findStr" : 
	                  p.setFindStr(v); break;
	               case "nowPage":
	                  p.setNowPage(Integer.parseInt(v));break;
	               }
	            }else { // <input type = 'file' /> 인가
	               if(fi.getSize()>0) {
	                  String f = fi.getName();
	                  String sysfile = new Date().getTime()+"-"+f;
	                  AttVo attVo = new AttVo();
	                  attVo.setOriFile(f);
	                  attVo.setSysFile(sysfile);
	                  attList.add(attVo);
	                  
	                  File file = new File(upload + sysfile);
	                  fi.write(file);
	                  fi.delete(); // 임시파을을 지우는 작업
	               }
	            }
	         }
	      }catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      req.setAttribute("vo", vo);
	      req.setAttribute("attList", attList);
	      req.setAttribute("delList", delList);
	      req.setAttribute("p", p);
	      return req;
	      
	   }
	   

}
