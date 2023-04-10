package com.example.demo.util;

import java.util.List;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JoltUtil {

	    public static <T> Object getEntity(String spec, Class<T> clazz, Object inputJson) {
	        List<?> chainrSpecJSON = JsonUtils.classpathToList(spec);
	        Chainr chainr = Chainr.fromSpec(chainrSpecJSON);
	        Object transformedOutput = chainr.transform(inputJson);
	        ObjectMapper objectMapper = new ObjectMapper();
	        //objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	        
	        return transformedOutput;
	    }
	
}
