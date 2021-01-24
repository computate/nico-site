package org.computate.nico.enus.java;

import java.io.IOException;
import java.time.LocalTime;

import org.computate.nico.enus.page.PageLayout;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalTimeSerializer extends JsonSerializer<LocalTime> {

	@Override()
	public void  serialize(LocalTime o, JsonGenerator generator, SerializerProvider provider) throws IOException, IOException {
		generator.writeString(PageLayout.FORMATTimeDisplay.format(o));
	}
}
