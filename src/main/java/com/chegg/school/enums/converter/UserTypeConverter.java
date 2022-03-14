package com.chegg.school.enums.converter;

import com.chegg.school.enums.UserType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, String> {

    @Override
    public String convertToDatabaseColumn(UserType type) {
        if (type == null) {
            return null;
        }
        return type.getValue();
    }

    @Override
    public UserType convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }

        return Stream.of(UserType.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}