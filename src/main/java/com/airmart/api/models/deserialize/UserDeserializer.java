package com.airmart.api.models.deserialize;

import java.io.IOException;

import com.airmart.api.domains.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class UserDeserializer extends StdDeserializer<User> {
	private static final long serialVersionUID = 1L;

	public UserDeserializer() {
        this(null);
    }

	public UserDeserializer(Class<?> vc) {
        super(vc);
    }

	@Override
	public User deserialize(JsonParser jp, DeserializationContext context) throws IOException, JsonProcessingException {
		String username = jp.getText();
		return new User(username);
	}

}
