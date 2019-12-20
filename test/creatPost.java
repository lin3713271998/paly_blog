import models.Post;
import models.User;
import org.junit.*;
import java.util.*;
import play.test.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.xml.stream.events.Comment;

public class creatPost extends UnitTest {

    @Test
    public void creatPost(){
        User bob = new User("bob@gmail.com","secret","Bob").save();
        new Post(bob,"My first post","Hello world").save();
        assertEquals(1,Post.count());
        List<Post> bobPost = Post.find("byAnthor",bob).fetch();

        assertEquals(1,bobPost.size());
        Post firstPost = bobPost.get(0);
        assertNotNull(firstPost);
        assertEquals(bob,firstPost.anthor);
        assertEquals("My first post",firstPost.title);
        assertEquals("Hello world",firstPost.content);
        assertNotNull(firstPost.postdate);
    }


    @Test
    public void postComments(){
        User bob = new User("bob@gmail.com","secret","Bob").save();
        Post bobPost = new Post(bob,"My first post","Hello world").save();
        new models.Comment(bobPost,"Jeff","Nice post").save();
        new models.Comment(bobPost,"Tom","I know that!").save();

        List<models.Comment> bobPostComments = models.Comment.find("byPost",bobPost).fetch();

        assertEquals(2,bobPostComments.size());
        models.Comment firstComment = bobPostComments.get(0);
        assertNotNull(firstComment);
        assertEquals("Jeff",firstComment.anthor);
        assertEquals("Nice post",firstComment.content);
        assertNotNull(firstComment.postdate);

        models.Comment secondComment = bobPostComments.get(1);
        assertNotNull(secondComment);
        assertEquals("Tom",secondComment.anthor);
        assertEquals("I know that!",secondComment.content);
        assertNotNull(secondComment.postdate);
    }
}


