package com.clinicguru.application.converters;

import com.clinicguru.application.enums.AppointmentType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class AppointmentTypeConverter implements AttributeConverter<AppointmentType, String> {

    @Override
    public String convertToDatabaseColumn(AppointmentType appointmentType) {
        if (appointmentType == null) {
            return null;
        }
        return appointmentType.getType();
    }

    @Override
    public AppointmentType convertToEntityAttribute(String type) {
        if (type == null) {
            return null;
        }

        return Stream.of(AppointmentType.values())
                .filter(c -> c.getType().equals(type))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
