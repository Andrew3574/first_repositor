import org.junit.*;
public class UnitTests {
    @Test
    public void FirstTest(){
        int[] array = {5,3,7,1,0};
        Main.sort(array);
        int element = 8;
        int result = Main.ternarySearch(array,element);
        int expected = -1;
        Assert.assertEquals(expected,result);
    }

    public void SecondTest(){
        int[] array = {0,-4,10,5,2};
        Main.sort(array);
        int element = 0;
        int result = Main.ternarySearch(array,element);
        int expected = 1;
        Assert.assertEquals(expected,result);
    }
}
