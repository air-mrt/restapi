package com.airmart.api.models.deserialize;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.airmart.api.config.ApiConstants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


public class DateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext dContx) throws IOException, JsonProcessingException {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(ApiConstants.DATE_PATTERN);
			return dateFormat.parse(jp.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
