package controllers;

import play.mvc.With;

import java.security.Security;

@With(Security.class)
public class Posts extends CRUD {
}
