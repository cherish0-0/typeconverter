package springmvc.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @EqualsAndHashCode는 equals()와 hashCode() 메서드를 자동으로 생성한다.
 * 모든 필드 값이 같으면 a.equals(b)는 true를 반환한다.
 */
@Getter
@EqualsAndHashCode
public class IpPort {

    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
