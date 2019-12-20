//import models.Comment;
//import models.Post;
//import models.User;
//import org.junit.Test;
//import play.test.UnitTest;
//
//public  class addPost  extends UnitTest {
//
//    @Test
//    public void useTheCommentRelation(){
//        User bob = new User("bob@gmail.com","secret","bob").save();
////        Post bobpost = new Post(bob,"My first post","Hello world").save();
////        bobpost.addComment("Jeff","Nice post");
////        bobpost.addComment("Tom","I know that!");
//
//        assertEquals(1,User.count());
//        assertEquals(1,Post.count());
//        assertEquals(2, Comment.count());
//
//        bobpost = Post.find("byAnthor",bob).first();
//        assertNotNull(bobpost);
//
//        assertEquals(2,bobpost.comments.size());
//        assertEquals("Jeff",bobpost.comments.get(0).anthor);
//
//        bobpost.delete();
//
//        assertEquals(1,User.count());
//        assertEquals(0,Post.count());
//        assertEquals(0,Comment.count());
//
//    }
//
//}
