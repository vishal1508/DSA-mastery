package projects.librarymanagement;

public abstract class Person {
  private String name;
  private String contactNumber;
  private String username;
  private String password;
  private boolean isLogin;

  public Person(String name, String contactNumber, String username, String password) {
    this.name = name;
    this.contactNumber = contactNumber;
    this.username = username;
    this.password = password;
    this.isLogin = false;
  }

  protected void displayDetails() {
    System.out.printf(
        "\nPerson Name := %s\nPerson Contact := %s\nUsername := %s\n",
        name, contactNumber, username);
  }

  // Getters
  public String getName() {
    return name;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public String getUsername() {
    return username;
  }

  public boolean isLogin() {
    return isLogin;
  }

  // Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setLogin(boolean login) {
    isLogin = login;
  }

  // Optional: password management (for security)
  protected boolean checkPassword(String password) {
    return this.password.equals(password);
  }

  protected void setPassword(String password) {
    this.password = password;
  }
}
