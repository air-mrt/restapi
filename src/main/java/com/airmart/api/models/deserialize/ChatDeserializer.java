package com.airmart.api.models.deserialize;

import java.io.IOException;

import com.airmart.api.domains.Chat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ChatDeserializer extends StdDeserializer<Chat> {
	private static final long serialVersionUID = 1L;

	public ChatDeserializer() {
		this(null);
	}

	public ChatDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Chat deserialize(JsonParser jp, DeserializationContext context) throws IOException, JsonProcessingException {
		long userId = Long.parseLong(jp.getText());
		return new Chat(userId);
	}
}
