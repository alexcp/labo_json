package labo_json;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {

    public UserTest() {
    }

    @Before
    public void before(){
        User.list.clear();
    }

    @Test
    public void liste() {
        //assertThat(User.list(),emptyArray());
    }

    @Test
    public void score(){
       User user =  new User("test",1,1,1,null);
       assertThat(user.score(),is(3));
    }

    @Test
    public void toJson(){
        User user =  new User("test",1,1,1,null);
        //assertThat(user.toJson(),is("ok"));
    }
}
