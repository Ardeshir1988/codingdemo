package com.ardeshir.codingdemo.Logic;

import com.ardeshir.codingdemo.model.Child;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ChildSerializer extends StdSerializer<Child> {
    public ChildSerializer() {
        this(null);
    }
    public ChildSerializer(Class<Child> t) {
        super(t);
    }

    @Override
    public void serialize(Child child, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("childId", child.getChildId());
        jsonGenerator.writeStringField("childName", child.getChildName());
        jsonGenerator.writeStringField("childAge", String.valueOf(child.getChildAge()));
        jsonGenerator.writeStringField("childGender", child.getChildGender());
        jsonGenerator.writeStringField("childSchoolName", child.getChildName());
        jsonGenerator.writeStringField("childParentId",String.valueOf( child.getChildParent().getPersonId()));

        jsonGenerator.writeEndObject();
    }
}
