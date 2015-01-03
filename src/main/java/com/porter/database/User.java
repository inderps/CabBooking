package com.porter.database;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

@Table(name = "Users")
public class User extends Model {
  @Column(name = "Name")
  private String name;

  @Column(name = "EmailID")
  public String emailId;

  public User(){
    super();
  }
  public User(String name, String emailId){
    super();
    this.name = name;
    this.emailId = emailId;
  }

  public static User getLoggedInUser() {
    return new Select().from(User.class).executeSingle();
  }

  public String getName() {
    return name;
  }
}
