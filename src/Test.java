/**
 * @Author: anan
 * @Date: 2022/7/22 2:04
 */
public class Test {

  public static void main(String[] args){
    int interview1 = Interview.interview("5,4,3,13,4,34,34,45,2,10");
    System.out.println("interview： "+interview1 +"\n\n");

    int interview2 = Interview.interview("5,4,3,13,4,34,34,45,2,10");
    System.out.println("interview： "+interview2 +"\n\n");

    int interview3 = Interview.interview("5,4,3,13,4,35,34,45,2,1");
    System.out.println("interview： "+interview3 +"\n\n");

    int interview4 = Interview.interview("5,4,3,13,4,35,34,45,2,1");
    System.out.println("interview： "+interview4 +"\n\n");

  }

}
