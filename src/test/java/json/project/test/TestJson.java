package json.project.test;
import json.framework.browser.rest.RestManager;
import json.project.pojo.MyPost;
import kong.unirest.HttpResponse;
import kong.unirest.HttpStatus;
import kong.unirest.JsonNode;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonUtils;

public class TestJson {
    private final int id99 = 99;
    private final int id105 = 105;

    @Test
    public void checkMyPosts() {
        HttpResponse<JsonNode> response = RestManager.getAllPosts();
        Assert.assertNotNull(response, "all Posts are null");
        Assert.assertEquals(response.getStatus(), HttpStatus.OK, "status-code is wrong");
    }
    @Test
    public void checkPostById() {
        HttpResponse<JsonNode> response = RestManager.getPostById(id99);
        Assert.assertNotNull(response, "Post is null");
        Assert.assertEquals(response.getStatus(), HttpStatus.OK, "status-code is wrong");

        MyPost expectedResult = JsonUtils.getMyPostByJsonText(JsonUtils.getExpectedJSONObject());
        String actualJsonText = response.getBody().getObject().toString();
        MyPost actualResult = JsonUtils.getMyPostByJsonText(actualJsonText);
        Assert.assertEquals(actualResult.getUserId(), expectedResult.getUserId(), "text of posts aren't matches");
        Assert.assertEquals(actualResult.getBody(), expectedResult.getBody(), "text of posts aren't matches");
        Assert.assertEquals(actualResult.getTitle(), expectedResult.getTitle(), "text of posts aren't matches");
        Assert.assertEquals(actualResult.getId(), expectedResult.getId(), "text of posts aren't matches");
    }

    @Test
    public void getPostByInvalidId() {
        HttpResponse<JsonNode> response = RestManager.getPostById(id105);
        Assert.assertNotNull(response, "Post is null");
        Assert.assertTrue(response.getBody().getObject().isEmpty(), "Post is not empty");
        Assert.assertEquals(response.getStatus(), HttpStatus.NOT_FOUND, "status-code is wrong");
    }

}
