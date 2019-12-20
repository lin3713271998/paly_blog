package models;


import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Post extends Model{
    @Required
    public String title;
    public Date postdate;
    @Required
    @Lob
    public String content;
//    public User anthor;
    @ManyToOne
    public User anthor;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    public List<models.Comment>comments;
    public Post(User anthor,String title,String content){
        this.comments = new ArrayList<models.Comment>();
        this.anthor = anthor;
        this.title = title;
        this.content = content;
        this.postdate = new Date();

        this.comments = new ArrayList<>();
    }
    public Post(String title,String content){
        this.comments = new ArrayList<models.Comment>();
        this.title = title;
        this.content = content;
        this.postdate = new Date();

        this.comments = new ArrayList<>();
    }
//    public Post addComment(String anthor,String content){
//        models.Comment newComment = new models.Comment(this,anthor,content).save();
//        this.save();
//        return this;
//    }
}
