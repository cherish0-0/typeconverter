package springmvc.typeconverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springmvc.typeconverter.converter.IntegerToStringConverter;
import springmvc.typeconverter.converter.IpPortToStringConverter;
import springmvc.typeconverter.converter.StringToIntegerConverter;
import springmvc.typeconverter.converter.StringToIpPortConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 이 컨버터가 없을 때도 잘 동작했던 이유는
     * 스프링 MVC가 기본적으로 제공하는 컨버터가 있기 때문
     * 지정 컨버터가 있으면 기본 컨버터보다 우선순위가 높아서 지정 컨버터가 사용됨
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
    }
}
