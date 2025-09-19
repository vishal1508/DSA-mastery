package projects.librarymanagement;

abstract class Person {
  String name;
  int personId;
  String contactNumber;
  String username;
  String password;
  boolean isLogin;

  protected void displayDetails() {
    System.out.printf(
        "\n\nPerson Name := %s\n\nPerson ID := %d\n\nPerson ContactNumber := %s\nusername := %s\npassword := %s\n\n",
        name, personId,
        contactNumber, username, password);
  }

}
