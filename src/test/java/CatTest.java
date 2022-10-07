import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;



@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(new Feline());
        String expected = "Мяу";
        assertEquals(expected, cat.getSound());
    }

    @Test
    public void GetFoodWithInvalidAnimalKindShouldThrowException() throws Exception{
        try {
            Cat cat = new Cat(new Feline());
            Mockito.when(new Feline().getFood("Барсик")).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
            cat.getFood();
        }
        catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }
    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Cat cat = new Cat(new Feline());
        Cat cat1 = Mockito.spy(cat);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(cat1.getFood()).thenReturn(expected);
        List<String> actual = cat1.getFood();
        assertEquals(expected, actual);

    }
}
