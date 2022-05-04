package json.project.pojo;

import com.google.gson.Gson;

public class MyPost {
    private int userId;
    private int id;
    private String title;
    private String body;

    public MyPost(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        String jsonText = "{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  }";
        MyPost myPost = gson.fromJson(jsonText, MyPost.class);
        System.out.println(myPost.getTitle());
        System.out.println(myPost.getBody());
    }
}
