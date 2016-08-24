package com.accenture.ancillary.reports;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import com.accenture.ancillary.data.AncillaryDataDAL;
import com.accenture.ancillary.dto.RevenueReportDto;
import com.accenture.ancillary.util.AncillaryUtils;

public class RestClient {

	public static List<RevenueReportDto> getData()throws Exception{

		String uri = "http://52.76.153.228:8080/AncillaryService/restservice/getRevenueReport";
		//WebTarget target = client.target(uri);
		URL url = new URL(uri);
		HttpURLConnection connection =
				(HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "application/json");
		String input = "8/01/2016";

		OutputStream os = connection.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(connection.getInputStream())));
		StringBuilder crunchifyBuilder = new StringBuilder();
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			crunchifyBuilder.append(output);
		}

		System.out.println(crunchifyBuilder.toString());
		List<RevenueReportDto> resp=(List<RevenueReportDto>)AncillaryUtils.getObjectFromString(crunchifyBuilder.toString(), RevenueReportDto.class);

		connection.disconnect();
		return resp;
	}
	
	public static List<RevenueReportDto> getDataDirectly(String startDate) throws SQLException{
		AncillaryDataDAL ancillaryDataDAL=new AncillaryDataDAL();
		return ancillaryDataDAL.getRevenueReport(startDate);
	}
}