package controllers;

import play.db.Model;
import play.mvc.*;

import java.security.Security;
import java.util.*;

import models.*;
@With(controllers.Security.class)
public class Blog extends Controller {

    public static void index() {
        String user = controllers.Security.connected();

        List<Post> posts = Post.findAll();
        render(posts,user);
    }

    public static void form(){
        render();
    }



    public static void save(String title,String content){
        Post post = new Post(title,content);

        validation.valid(post);
        if (validation.hasErrors()){
            render("@form",post);
        }
      post.save();
        index();//???????????????????????????????????????
    }

    public static void seecomment(String id){  //返回数据库里的内容
        Post post = Post.findById(Long.parseLong(id));
        session.put("postid",post.id);
        render("@see", post,post.content);
    }

//    public static void addcomment(String id){
//        Post post = Post.findById(Long.parseLong(id));
//        render("@Rform",post);
//
//    }

    public static void Rform(Post post){
//        Comment object = Comment.findById(comment.id);
//        Comment newComment = new models.Comment(object.post,object.anthor,object.content).save();
        render("@Rform",post);//差这一点
    }

    public static void savecomment(String postid,String anthor, String content){
        Post post = Post.findById(Long.parseLong(postid));
        Comment comment = new Comment(post,anthor,content);
        validation.valid(comment);
        if (validation.hasErrors()){
            render("@see",comment);
        }
        comment.save();
        index();
    }
    @Check("deletecomment")
    public static void deletecomment(String postid,String commentid){
        Post post = Post.findById(Long.parseLong(postid));
        Comment comment = Comment.findById(Long.parseLong(commentid));
        validation.valid(comment);
        if (validation.hasErrors()){
            render("@see",comment);
        }
        comment.delete();
//        render("http://localhost:9000/blog/seecomment?id="+postid);
        render("@see",post);
        }



}
