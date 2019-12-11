package com.example.retrofitexample;


import com.google.gson.annotations.SerializedName;

public class post {
  private String FName;
  private String LName;
  private String Email;
  private String Password;
  @SerializedName("body")
  private String text;

  public post(String fName, String lName, String email, String password, String text) {
    FName = fName;
    LName = lName;
    Email = email;
    Password = password;
    this.text = text;
  }

  public String getFName() {
    return FName;
  }

  public String getLName() {
    return LName;
  }

  public String getEmail() {
    return Email;
  }

  public String getPassword() {
    return Password;
  }

  public String getText() {
    return text;
  }
}
