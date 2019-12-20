package controllers;
import models.Comment;
import models.Post;
import play.mvc.Controller;
import java.util.List;

public class Reviews extends Controller {

    public static void index() {
        List<Comment> comments = Comment.findAll();
        render(comments);
    }

    public static void Rform(){
//        String postt = Secure.Security.connected();
        render();
    }
    public static void save(Post post, String content){
        Comment comment = new Comment(post,content);

        validation.valid(comment);
        if (validation.hasErrors()){
            render();
        }
        comment.save();
        index();//???????????????????????????????????????
    }
}
