

package com.accenture.ancillary.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ApplicationDownloader{

	/**
	 * Represents the log used to log the operations and errors encountered
	 * in this class.
	 */
	private final Logger log = Logger.getLogger(ApplicationDownloader.class);
	/**
	 * This method validates and processes the download request
	 * @param request
	 * @param response
	 */
	public void downloadApplication(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String strFileMimeType = null;
		String strRootPath = null;
		try {
			log.info("Entering to the method ApplicationDownloader.downloadApplication");
			strRootPath="C:\\apps\\testing\\FortuneSummryReport.pdf";
			strFileMimeType="application/vnd.android.package-archive"; 
			if (strRootPath != null && strFileMimeType != null) {
				log.info("Final Dir path :"+strRootPath);
				this.renderByteArrayAsFile(strRootPath,strFileMimeType, response);
			}
		}catch(Exception e){
			log.error("Error while downloading Store upgrade apk",e);
		}
	}

	
	/**
	 * @param strFilePath
	 * @param strFileMimeType
	 * @param response
	 * @throws IOException
	 */
	private void renderByteArrayAsFile(String strFilePath,String strFileMimeType,
			HttpServletResponse response)throws IOException {

		log.info("Entering to the method ApplicationDownloader.renderByteArrayAsFile");
		String [] arrDirPaths = null;
		OutputStream objOutputStream = null;
		String apkName="FortuneSummryReport.pdf";

		log.info("Application file path:"+strFilePath);
		File objApplicationFile = new File(strFilePath);
		if(objApplicationFile.exists()){
			log.info("Application file exists! proceeding for download");
		}else{
			log.info("Application file doesn not exists!");
		}
		log.info("Application file content length:" + objApplicationFile.length());

		byte[] arrBytes = new byte[(int) objApplicationFile.length()];

		if (null != arrBytes) {
			log.info("Array bytes is not null: " + arrBytes);
			//Retrieving the instance of output stream
			objOutputStream = response.getOutputStream();

			InputStream objInputStream = null;
			objInputStream = new FileInputStream(objApplicationFile);
			objInputStream.read(arrBytes);
			objInputStream.close();

			//Setting the attributes of response object
			response.setContentType(strFileMimeType);
			//Removing the relative directory path from the file name, if any
			arrDirPaths = strFilePath.split("/");
			if(null != arrDirPaths) {
				log.info("arrDirPath is not null: " + arrDirPaths);
				apkName=arrDirPaths[arrDirPaths.length-1];
				log.info("strFileName: " + apkName);
			}
			response.setHeader("Content-Disposition", "attachment;filename=" +apkName);
			response.setBufferSize(4096);
			response.setContentLength(arrBytes.length);

			objOutputStream.write(arrBytes, 0, arrBytes.length);
			log.info("After writing the content to output stream of response object");

			objOutputStream.flush();
			objOutputStream.close();
			log.info("Exiting from the method ApplicationDownloader.renderByteArrayAsFile");
		}
	}
	/**
	 * This method is used to get a bean handle
	 * @param request
	 * @param beanName
	 * @return Object
	 */
	private Object getBean(HttpServletRequest request, String beanName) {
		ServletContext servletContext = request.getSession().getServletContext();
		WebApplicationContext webCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		return webCtx.getBean(beanName);
	}
}
