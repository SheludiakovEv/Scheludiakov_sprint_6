import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void eatMeatShouldReturnPredatorFood() throws Exception {
        Feline feline = new Feline();
        Feline feline1 = Mockito.spy(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline1.getFood("Хищник")).thenReturn(expected);
        List<String> actual = feline1.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittens() {
        assertEquals(1, (new Feline()).getKittens());
    }

    @Test
    public void testGetKittens1() {
        assertEquals(3, (new Feline()).getKittens(3));
    }

    @Test
    public void testConstructor() {
        assertEquals("Кошачьи", (new Feline()).getFamily());
    }
}


