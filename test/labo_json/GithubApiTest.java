package labo_json;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class GithubApiTest {

    public GithubApiTest() {
    }

    @Test
    public void obtenirLesDonneesDeLUrl() throws Exception{
        assertThat(GithubApi.obtenirLesDonneesDeLUrl("https://api.github.com/users/alexcp"),not(isEmptyOrNullString()));
    }
}
