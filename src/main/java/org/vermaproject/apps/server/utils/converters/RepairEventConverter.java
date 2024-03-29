package org.vermaproject.apps.server.utils.converters;

import org.vermaproject.apps.server.enums.RepairEventEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public final class RepairEventConverter implements AttributeConverter<RepairEventEnum, String> {

    @Override
    public String convertToDatabaseColumn(RepairEventEnum repairEvent) {
        if (repairEvent == null) throw new IllegalArgumentException("DB error. Enum variant is not populated.");

        return repairEvent.toString();
    }

    @Override
    public RepairEventEnum convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) throw new IllegalArgumentException("DB error. Value (String) is not populated.");

        return RepairEventEnum.valueOf(s);
    }
}
