package projects.librarymanagement;

public class Member extends Person {
  private int memberId;

  public Member(int memberId, String name, String contactNumber, String username, String password) {
    this.personId = memberId++;
    this.memberId = this.personId;
    this.name = name;
    this.contactNumber = contactNumber;
    this.username = username;
    this.password = password;
  }

}
