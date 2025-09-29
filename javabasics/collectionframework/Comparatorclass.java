package collectionframework;

import java.util.ArrayList;
import java.util.Comparator;

class MyComparator implements Comparator<Integer> {

  @Override
  public int compare(Integer o1, Integer o2) {
    System.out.println(o2 - o1);
    return o2 - o1;
  }

}

class MyStudent {
  double cgpa;
  String name;

  public MyStudent(double cgpa, String name) {
    this.cgpa = cgpa;
    this.name = name;
  }

  public double getCgpa() {
    return this.cgpa;
  }

  public String getName() {
    return this.name;
  }

}

public class Comparatorclass {
  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(4);
    a.add(3);
    a.add(2);
    a.sort((o1, o2) -> o1 - o2);
    System.out.println("Integer :=> " + a);

    ArrayList<String> names = new ArrayList<String>();
    names.add("vishal");
    names.add("Ramesh");
    names.add("vikas");

    names.sort((o1, o2) -> o1.compareTo(o2));
    System.out.println("Names sorting :=> " + names);

    ArrayList<MyStudent> s = new ArrayList<>();
    s.add(new MyStudent(3.4, "vishal"));
    s.add(new MyStudent(3.2, "vikas"));
    s.add(new MyStudent(3.5, "suresh"));
    s.add(new MyStudent(3.4, "rajesh"));

    // s.sort((s1, s2) -> {
    // if (s1.getCgpa() - s2.getCgpa() > 0) {
    // return 1;
    // } else if (s1.getCgpa() - s2.getCgpa() < 0) {
    // return -1;
    // } else {
    // return 0;
    // }
    // });
    Comparator<MyStudent> compare = Comparator.comparing(MyStudent::getCgpa).reversed()
        .thenComparing(MyStudent::getName);
    s.sort(compare);
    System.out.println(compare);
    for (MyStudent stud : s) {
      System.out.println("name : " + stud.name + " \t cgpa : " + stud.cgpa);
    }
  }
}
