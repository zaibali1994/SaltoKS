package general;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericFunctions {

    //Fetch Day
    public static String getDayFromDate() {

        Date now = new Date();

        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        return simpleDateformat.format(now);


    }

}


