package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Comment extends Model{
    public String anthor;
    public Date postdate;
    public String postid;
    @Lob
    public String content;
    @ManyToOne
    public Post post;


    public Comment(Post post,String anthor,String content){
        this.post = post;
        this.anthor = anthor;
        this.content = content;
        this.postdate = new Date();
    }
    public Comment(Post postr,String content){
        this.post = post;
        this.content = content;
        this.postdate = new Date();
    }
    public Comment(String anthor,String content){
        this.anthor = anthor;
        this.content = content;
        this.postdate = new Date();
    }
}

