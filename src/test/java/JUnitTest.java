import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitTest {
    /*
    * 스프링부트 스타터 테스트 목록
    * 대표적으로
    * JUnit : 자바 프로그래밍 언어용 단위 테스트 프레임워크
    * AssertJ : 검증문인 어설션을 작성하는 데 사용되는 라이브러리
    * */
    @DisplayName("1+2는 3이다")
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;
        // 기존 가독성 낮은 버전 Assertions.assertEquals(sum, a+b);
        assertThat(a+b).isEqualTo(sum);
    }

}
