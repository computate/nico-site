package org.computate.nico.enus.java;

import java.io.IOException;
import java.time.LocalDate;

import org.computate.nico.enus.page.PageLayout;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

	@Override()
	public void  serialize(LocalDate o, JsonGenerator generator, SerializerProvider provider) throws IOException, IOException {
		generator.writeString(PageLayout.FORMATDateDisplay.format(o));
	}
}
