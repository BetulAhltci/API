package Pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class pojoHerokuAppBooking {
  /*  {
            "firstname" : "Ali",
            "lastname" : “Bak",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
    },
            "additionalneeds" : "wi-fi"
    }*/

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private pojoHerokuAppBookingDates bookingdates;
    private String additionalneeds;
}
