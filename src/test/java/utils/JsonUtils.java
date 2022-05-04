package utils;
import com.google.gson.Gson;
import json.project.pojo.MyPost;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONArray;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static kong.unirest.JsonPatchOperation.add;

public class JsonUtils {
    private static Gson gson = new Gson();

    public static MyPost getMyPostByJsonText(String jsonText) {
        return gson.fromJson(jsonText, MyPost.class);
    }

    public static List<MyPost> getMyPostsByResponse(HttpResponse<JsonNode> response) {
        List<MyPost> result = new ArrayList<>();
        JSONArray array = response.getBody().getArray();
        for (int i = 0; i < array.length(); i++) {
            String text = array.getJSONObject(i).toString();
            MyPost postText = getMyPostByJsonText(text);
            result.add(postText);
        }
        return result;
        //Collections.sort();
    }

    public static String getExpectedJSONObject() {
        String path = JsonUtils.class.getClassLoader().getResource("my_post").getFile();
        JsonNode node = null;
        try {
            node = new JsonNode(FileUtils.readFileToString(new File(path)));
        }
        catch (IOException e) {
            Logger.error("file hasn't been read");
        }
        return node.getObject().toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getExpectedJSONObject());
    }
}
