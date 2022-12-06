import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void invalidLionSexShouldThrowException() throws Exception {
        Exception e = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Невиданная зверушка", feline);
        });
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        String actual = e.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void createLionWithManePositiveResult() throws Exception {
        Lion Lion = new Lion("Самец", feline);
        assertTrue(Lion.hasMane);
    }

    @Test
    public void createLionWithoutManePositiveResult() throws Exception {
        Lion Lion = new Lion("Самка", feline);
        assertFalse(Lion.hasMane);
    }
    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Lion Lion = new Lion("Самец", feline);
        Lion lion1 = Mockito.spy(Lion);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(lion1.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion1.getFood("Хищник");
        assertEquals(expected, actual);
    }
    @Test
    public  void  doesHaveManeShouldReturnTrue() throws Exception {
        Lion Lion = new Lion("Самец", feline);
        assertTrue(Lion.doesHaveMane());
    }
    @Test
    public  void  doesHaveManeShouldReturnFalse() throws Exception {
        Lion Lion = new Lion("Самка", feline);
        assertFalse(Lion.doesHaveMane());

    }
}



