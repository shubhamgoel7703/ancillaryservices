

package com.accenture.ancillary.download;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 
 * @author 
 *
 */
public class AppDownloadServlet extends HttpServlet {

	/**
	 * Represents the logger used to log the operations and errors encountered
	 * in this class.
	 */
	private final Logger log = Logger.getLogger(AppDownloadServlet.class);

	private static final long serialVersionUID = 1L;
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		try{
			log.info("Entering to the DownloadServlet");
			ApplicationDownloader appDownloader = new ApplicationDownloader();
			appDownloader.downloadApplication(request, response);
			log.info("Returned back to DownloadServlet");
		}catch(Exception e){
			log.error("Inside exception block of DownloadServlet.", e);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Exception while downloading apk");
		}finally{
			log.info("Exiting from the DownloadServlet");
			log.info("Returning control to front end");
		}
	}
}
