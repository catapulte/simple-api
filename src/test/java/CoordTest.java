import com.catapult.lolcat.model.DecimalCoord;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by erwann on 18/01/17.
 */
public class CoordTest {

//    @Test
//    public void test1(){
//        DecimalCoord decimalCoord = new DecimalCoord(4806.9136f, -140.4197f);
//        assertThat(decimalCoord.getDecimalCoord()).isEqualTo(new float[]{48.115227f,-1.6736615f});
//    }
//
//    @Test
//    public void test2(){
//        DecimalCoord decimalCoord = new DecimalCoord("4806.9136N", "140.4197W");
//        assertThat(decimalCoord.getDecimalCoord()).isEqualTo(new float[]{48.115227f,-1.6736615f});
//    }

    @Test
    public void test3() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy'@'HH:mm:ss.SSS");//'@'HH:mm:ss:SSS

        Date parse = simpleDateFormat.parse("18/1/2017@22:3:3.0");//@22:22:30.000

        System.out.println(parse);

    }
}
