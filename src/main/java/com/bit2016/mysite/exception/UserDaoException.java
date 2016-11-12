package com.bit2016.mysite.exception;


@SuppressWarnings("serial")
public class UserDaoException extends RuntimeException{
   public UserDaoException(){
         super("User Not Found");
      }
}