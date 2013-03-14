package labo_json;
import com.google.gson.*;
import java.net.URL;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class GithubApi {

    public static User createUser(String username) throws Exception{
        String json = obtenirLesDonneesDeLUrl("https://api.github.com/users/"+username);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObj = jsonParser.parse(json).getAsJsonObject();


        User user = new User(
                jsonObj.get("login").getAsString(),
                jsonObj.get("followers").getAsInt(),
                jsonObj.get("public_repos").getAsInt(),
                jsonObj.get("public_gists").getAsInt(),
                jsonObj.get("avatar_url").getAsString()
                );
        return user;
    }

    public static String obtenirLesDonneesDeLUrl(String url) throws Exception{
        InputStream request = new URL(url).openStream();
        return IOUtils.toString(request,"UTF-8");
    }


}