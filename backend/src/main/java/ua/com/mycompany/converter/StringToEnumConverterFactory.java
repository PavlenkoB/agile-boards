package ua.com.mycompany.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import ua.com.mycompany.enums.Colors;
import ua.com.mycompany.enums.Stikers;

public class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {
    @Override
    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        if (targetType.equals(Colors.class)) {
            return (Converter<String, T>) new StringToColor();
        } else if (targetType.equals(Stikers.class)) {
            return (Converter<String, T>) new StringToStikers();
        }
        throw new RuntimeException("Converter not found");
    }

    private final class StringToColor implements Converter<String, Colors> {
        @Override
        public Colors convert(String source) {
            return Enum.valueOf(Colors.class, source.toUpperCase().trim());
        }
    }

    private final class StringToStikers implements Converter<String, Stikers> {
        @Override
        public Stikers convert(String source) {
            return Enum.valueOf(Stikers.class, source.toUpperCase().trim());
        }
    }
}
