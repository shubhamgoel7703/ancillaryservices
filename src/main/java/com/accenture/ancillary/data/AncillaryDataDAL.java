package com.accenture.ancillary.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.accenture.ancillary.dto.HotelDto;
import com.accenture.ancillary.dto.ServicesDto;

public class AncillaryDataDAL  extends JdbcDaoSupport{
	private static final Logger log = Logger.getLogger(AncillaryDataDAL.class);
	private void closeConnection(Connection jdbcConnection, PreparedStatement preparedStatement) throws SQLException {
		if(jdbcConnection!=null){
			jdbcConnection.close();
		}
		if(preparedStatement!=null){
			preparedStatement.close();
		}
	}

	public List<HotelDto> getHotelList() throws SQLException{
		List<HotelDto> hotelList=null;
		String query = "select * from hotel";
		PreparedStatement preparedStatement = null;
		Connection jdbcConnection=null;
		ResultSet rs=null;
		try{
			jdbcConnection = getConnection();
			preparedStatement=jdbcConnection.prepareStatement(query);
			//preparedStatement.setString(1,user_name);
			rs = preparedStatement.executeQuery();
			if(rs!=null && !rs.wasNull()){
				hotelList=new ArrayList<HotelDto>();
				HotelDto hotelDto;
				while(rs.next()){
					hotelDto=new HotelDto();
					hotelDto.setHotelId(rs.getInt("hotel_id"));
					hotelDto.setHotelname(rs.getString("hotel_name"));
					hotelDto.setHotelCity(rs.getString("hotel_city"));
					hotelDto.setHotelCountry(rs.getString("hotel_country"));
					hotelDto.setHotelShortDesc(rs.getString("hotel_short_desc"));
					hotelList.add(hotelDto);
				}
			}
		}catch(Exception e){
			log.error("exception while getting hotel details "+e);
			throw e;
		}finally{
			closeConnection(jdbcConnection,preparedStatement);
			rs.close();
		}
		return hotelList;
	}
	
	public List<ServicesDto> getServiceList(int hotelId) throws SQLException{
		log.info("get services DB call with hotel id="+hotelId);
		List<ServicesDto> servicesList=null;
		String query = "select * from services";
		if(hotelId>0){
			query = "SELECT * FROM services WHERE service_id IN(SELECT service_id FROM hotel_service_map WHERE hotel_id=?)";
		}
		PreparedStatement preparedStatement = null;
		Connection jdbcConnection=null;
		ResultSet rs=null;
		try{
			jdbcConnection = getConnection();
			preparedStatement=jdbcConnection.prepareStatement(query);
			if(hotelId>0){
				preparedStatement.setInt(1,hotelId);
			}
			rs = preparedStatement.executeQuery();
			if(rs!=null && !rs.wasNull()){
				servicesList=new ArrayList<ServicesDto>();
				ServicesDto servicesDto;
				while(rs.next()){
					servicesDto=new ServicesDto();
					servicesDto.setServiceId(rs.getInt("service_id"));
					servicesDto.setServiceName(rs.getString("service_name"));
					servicesDto.setServicePrice(rs.getString("service_price"));
					servicesDto.setServiceDesc(rs.getString("service_description"));
					servicesList.add(servicesDto);
				}
			}
		}catch(Exception e){
			log.error("exception while getting service details "+e);
			throw e;
		}finally{
			closeConnection(jdbcConnection,preparedStatement);
			rs.close();
		}
		return servicesList;
	}
}
