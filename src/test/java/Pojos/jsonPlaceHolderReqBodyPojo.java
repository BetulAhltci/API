package Pojos;

public class jsonPlaceHolderReqBodyPojo {

   /* Request Body
    {
        "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
    }*/

    //1-tum key degerlerini class level da aldıkları data turune gore privet variable olarak olustur
    private String title;
    private String body;
    private int userId;
    private int id;

    //2-tum variable için geter() ve seter() olustur

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //3-tum variableları içeren parametreli construktor olustur

    public jsonPlaceHolderReqBodyPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    //4-parametreli constructor olusturuldugu için bir tadede parametresiz constructor olustur

    public jsonPlaceHolderReqBodyPojo() {
    }

    //5-toString() olustur


    @Override
    public String toString() {
        return "jsonPlaceHolderReqBodyPojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
