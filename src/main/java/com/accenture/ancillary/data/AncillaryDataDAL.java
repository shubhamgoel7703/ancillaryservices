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
import com.accenture.ancillary.dto.ServicePerReservation;
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
					hotelDto.setHotelPrice(rs.getString("hotel_price"));
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

	public int saveReservation(int resvId,int hotelId,String guestName,String guestAddress,String guestEmail,String checkIn,String checkOut,String resvPrice) throws SQLException{
		log.info("save reservation "+resvId+hotelId+guestName+guestAddress+guestEmail+checkIn+checkOut);
		String insertResv="INSERT INTO reservation VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		Connection jdbcConnection=null;
		int retVal=0;
		try{
			jdbcConnection = getConnection();
			preparedStatement=jdbcConnection.prepareStatement(insertResv);
			preparedStatement.setInt(1, resvId);
			preparedStatement.setString(2, guestName);
			preparedStatement.setString(3, guestAddress);
			preparedStatement.setString(4, guestEmail);
			preparedStatement.setInt(5, hotelId);
			preparedStatement.setString(6, checkIn);
			preparedStatement.setString(7, checkOut);
			preparedStatement.setString(8, resvPrice);
			retVal = preparedStatement.executeUpdate();
		}catch(Exception e){
			log.error("exception while saving reservaiton  details "+e);
			throw e;
		}finally{
			closeConnection(jdbcConnection,preparedStatement);
		}
		if(retVal>0){
			return resvId;
		}else{
			return retVal;
		}
	}
	
	public int saveServices(int resvId,int serviceId,String servStart,String servEnd,String servCost,String servReqFor) throws SQLException{
		log.info("save services "+resvId+serviceId+servStart+servEnd+servCost+servReqFor);
		String insertResv="INSERT INTO res_service_map(res_id,service_id,service_start,service_end,service_cost,service_required_for) VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		Connection jdbcConnection=null;
		int retVal=0;
		try{
			jdbcConnection = getConnection();
			preparedStatement=jdbcConnection.prepareStatement(insertResv);
			preparedStatement.setInt(1, resvId);
			preparedStatement.setInt(2, serviceId);
			preparedStatement.setString(3, servStart);
			preparedStatement.setString(4, servEnd);
			preparedStatement.setString(5, servCost);
			preparedStatement.setString(6, servReqFor);
			retVal = preparedStatement.executeUpdate();
		}catch(Exception e){
			log.error("exception while saving service  details "+e);
			throw e;
		}finally{
			closeConnection(jdbcConnection,preparedStatement);
		}
		if(retVal>0){
			return resvId;
		}else{
			return retVal;
		}
	}
	
	public List<ServicePerReservation> getServicePerResv(int resvId)throws SQLException{
		log.info("get srvices per resv"+resvId);
		List<ServicePerReservation> servPerResv=null;
		String insertResv="SELECT serv.service_name,rsm.service_start,rsm.service_end,rsm.service_cost "
				+ " FROM services serv, res_service_map rsm WHERE serv.service_id=rsm.service_id AND rsm.res_id= ?";
		PreparedStatement preparedStatement = null;
		Connection jdbcConnection=null;
		ResultSet rs=null;
		try{
			jdbcConnection = getConnection();
			preparedStatement=jdbcConnection.prepareStatement(insertResv);
			preparedStatement.setInt(1, resvId);
			rs = preparedStatement.executeQuery();
			if(rs!=null && !rs.wasNull()){
				servPerResv=new ArrayList<ServicePerReservation>();
				ServicePerReservation servicesDto;
				while(rs.next()){
					servicesDto=new ServicePerReservation();
					servicesDto.setServiceName(rs.getString("service_name"));
					servicesDto.setServiceStart(rs.getString("service_start"));
					servicesDto.setServiceEnd(rs.getString("service_end"));
					servicesDto.setServiceCost(rs.getString("service_cost"));
					servPerResv.add(servicesDto);
				}
			}
		}catch(Exception e){
			log.error("exception while getting service details per reservation "+e);
			throw e;
		}finally{
			closeConnection(jdbcConnection,preparedStatement);
			rs.close();
		}
		return servPerResv;
	}
}
