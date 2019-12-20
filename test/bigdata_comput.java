import org.junit.*;
import java.util.*;
import play.test.*;

public class bigdata_comput extends UnitTest {

    @Test
    public void BigdataComput(){
        int[] num1 = {2, 5, 6, 7, 8, 9, 1, 2, 3, 4};
        int[] num2 = {2, 5, 6, 7, 8, 9, 1};
        int[] result = new int[num1.length + num2.length - 1];
        int carry = 0;

        for (int i = num1.length - 1; i >= 0; i--)
        {
            carry = 0;

            for (int j = num2.length - 1; j >= 0; j--)
            {
                int temp = num1[i] * num2[j] + carry + result[i + j];
                result[i + j] = temp % 10;
                carry = temp / 10;
            }
            if (carry != 0)
            {
                result[i - 1] = carry;
            }
        }
        System.out.println(Arrays.toString(result));
    }

}



