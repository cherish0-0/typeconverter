package springmvc.typeconverter.converter;

import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import springmvc.typeconverter.type.IpPort;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {

    /**
     * 스프링 컨버전 서비스는 Converter를 등록해서 사용할 수 있다.
     * convert 시 등록된 Converter 중 쓰일 수 있는 것을 자동으로 찾아서 변환한다.
     * 스프링 컨버전 서비스는 컨버터를 등록 및 관리하는 인터페이스와
     * 변환 로직을 실행하는 인터페이스로 나뉜다.(불필요한 메서드는 모르게 됨)
     * 이렇게 인터페이스를 분ㄹ니하는 것을 ISP(Interface Segregation Principle)라고 한다.
     */
    @Test
    void conversionService() {
        // 컨버터 등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // 컨버전 서비스 사용해서 변환
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");

        IpPort result = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));

        String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
    }
}

