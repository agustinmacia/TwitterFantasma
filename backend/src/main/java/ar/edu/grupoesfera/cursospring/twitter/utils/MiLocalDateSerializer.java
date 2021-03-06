package ar.edu.grupoesfera.cursospring.twitter.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class MiLocalDateSerializer extends StdSerializer<LocalDateTime>{

	private static final long serialVersionUID = 1L;
	
	public MiLocalDateSerializer() {
		this(null);
	}

	public MiLocalDateSerializer(Class<LocalDateTime> t) {
		super(t);
	}

	@Override
	public void serialize(LocalDateTime fecha, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException{
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = fecha.format(formatter);
		
		jsonGenerator.writeString(formattedString);
	}

}
