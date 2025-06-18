package springmvc.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


@Slf4j
public class MyNumberFormatter implements Formatter<Number> {

    /**
     * Formatter 인터페이스를 구현하여 숫자 형식 변환을 처리한다.
     * - parse: 문자열을 숫자로 변환
     * - print: 객체를 문자열로 변환
     */
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={}, locale={}", text, locale);
        // NumberFormat 객체는 locale에 따라 숫자 형식을 다르게 처리한다. (예: 천 단위 구분 기호, 소수점 기호 등)
        return NumberFormat.getInstance(locale).parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}", object, locale);
        return NumberFormat.getInstance(locale).format(object);
    }
}
