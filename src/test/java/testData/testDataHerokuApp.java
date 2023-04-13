package testData;

import netscape.javascript.JSObject;
import org.json.JSONObject;

public class testDataHerokuApp {
   public int basariliStatusKod=200;

     /* Request body
        {
            "firstname" : "Ali",
                "lastname" : “Bak",
            "totalprice" : 500,
                "depositpaid" : false,
                "bookingdates" : {
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
        },
            "additionalneeds" : "wi-fi"
        }
     */

    public JSONObject bookingDatesJson() {
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "2021-06-01");
        bookingDates.put("checkout", "2021-06-10");

        return bookingDates;

    }

    public JSONObject reqBodyJson() {

        JSONObject booking = new JSONObject();
        booking.put("firstname", "Ali");
        booking.put("lastname", "Bak");
        booking.put("totalprice", 500);
        booking.put("depositpaid", false);
        booking.put("bookingdates", bookingDatesJson());
        booking.put("additionalneeds", "wi-fi");

        return booking;
    }

    /*
     Expected Body
    {
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
     */

    public JSONObject expBodyJson() {
        JSONObject expBody = new JSONObject();

        expBody.put("bookingid", 24);
        expBody.put("booking", reqBodyJson());

        return expBody;
    }


}
