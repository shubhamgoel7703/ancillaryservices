package com.accenture.ancillary.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.omg.CORBA.SystemException;

public class AncillaryUtils {
	private static final Logger LOG = Logger.getLogger(AncillaryUtils.class);
	private static ObjectMapper mapper  = new ObjectMapper();


	/**
	 * This object writes the object as string
	 * @param object
	 * @return
	 * @throws SystemException
	 */
	public static String writeObjectAsString(Object object) throws Exception{
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonParseException e) {
			LOG.error("JsonParseException Exception occured!!");
			return null;
		} catch (JsonMappingException e) {
			LOG.error("JsonMappingException Exception occured!!");
			return null;
		} catch (IOException e) {
			LOG.error("IOException Exception occured!!");
			return null;
		}
	}

	/**
	 * This api gets the object from the json String
	 * @param strObject
	 * @param inputClass
	 * @return
	 * @throws SystemException
	 */
	public static Object getObjectFromString(String strObject,Class<?> inputClass) throws Exception{
		LOG.debug("Entering getObjectFromString method with String ::"+strObject);
		try {
			return mapper.readValue(strObject, inputClass);
		} catch (JsonParseException e) {
			LOG.error("JsonParseException Exception occured!!");
			return null;
		} catch (JsonMappingException e) {
			LOG.error("JsonMappingException Exception occured!!");
			return null;
		} catch (IOException e) {
			LOG.error("IOException Exception occured!!");
			return null;
		}
	}

	public static String createStackTraceAsString(Exception e) {
        if (e == null){ return null; }
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        try {
        	LOG.error(errors.toString());
			return writeObjectAsString(new ErrorMessage((errors.toString().length()>0&&errors.toString().length()>=200)?errors.toString().substring(0, 200):errors.toString()));
		} catch (Exception e1) {
			e1.printStackTrace();
			return "\"errorMessage\": \"Exception Occured\"";
		}
    }
	
	public static int generateRandNum(){
		Random r = new Random();
		return r.nextInt((99999 - 11111) + 1) + 11111;
	}
	
	/**
	 * @param strObject
	 * @param requiredClass
	 * @return
	 * @throws SystemException
	 */
	public static List<?> getListFromString(String strObject,Class<?> requiredClass) throws SystemException{
		LOG.debug("Entering getListFromString method with String ::"+strObject);
		try {
			return mapper.readValue(strObject, TypeFactory.collectionType(List.class, requiredClass));
		} catch (JsonParseException e) {
			LOG.error("JsonParseException Exception occured!!");
			return null;
		} catch (JsonMappingException e) {
			LOG.error("JsonMappingException Exception occured!!");
			return null;
		} catch (IOException e) {
			LOG.error("IOException Exception occured!!");
			return null;
		}
	}
}
