import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    //заготовки для параметризованного теста
    Lion lion;
    String sex;
    boolean hasMane;

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() { //червёртый - метод, который будет возвращать тестовые данные и написать аннотацию @Parameterized.Parameters
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(sex, feline);
    }

    @Test
    public void lionCallСonstructorCheckHasManeField() throws Exception {
        assertEquals("должен возвращаться параметр hasMane == ", hasMane, lion.hasMane);
    }

    @Test
    public void doesHaveManeCallMethodReturnHasManeField() {
        assertEquals("должен возвращаться ответ == " , hasMane, lion.doesHaveMane());
    }
}
