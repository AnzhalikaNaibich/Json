package json.framework.browser.rest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import utils.ConfigFileReader;

public class RestManager {
    private static String POSTS = "posts";
    private static ConfigFileReader config = ConfigFileReader.configFileReader;

    public static String getUrl(String endPoint){
        return String.format("%s%s", config.getApplicationUrl(), endPoint);
    }
    public static HttpResponse<JsonNode> getAllPosts(){
        return Unirest.get(getUrl(POSTS)).asJson();
    }

    public static HttpResponse <JsonNode> getPostById(int id){
        return Unirest.get(String.format("%s/%d", getUrl(POSTS), id)).asJson();
    }

    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        System.out.println(response.getBody().toPrettyString());
    }

}
