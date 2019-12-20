package controllers;
import play.mvc.*;
import java.security.Security;
import java.util.*;

@With(Security.class)
public class Application extends Controller {

    public static void index() {
        String user = controllers.Security.connected();

        render(user);
    }

    public static void hello(){ render(); }
}