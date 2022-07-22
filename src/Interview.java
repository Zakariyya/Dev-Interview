import java.util.Random;
import java.util.Scanner;

/**
 * @Author: anan
 * @Date: 2022/7/22 1:52
 */
public class Interview {

  public static void main(String[] args) {
    /**
     * 输入案例：
     * 5,4,3,13,4,34,34,45,2,1
     */
    String input = input();

    /**
     * 主处理函数
     */
    int interview = interview(input);

    System.out.println("interview： "+interview);
  }

  public static int interview(String input) {
    String[] split = input.split(",");

    /**
     * 输入校验：
     *
     * 这里只做简单的输入校验，不是很严格，因为还要判断输入非正整数（如：字符，负数，纯俩逗号等）的异常处理。
     * 但归于非本题重点，校验做简单处理
     */
    while(split.length > 5000){
      System.out.println("请输入积分数组，长度不可大于50000，请重新输入：（按逗号分隔）");
      input = input();
      split = input.split(",");
    }
    /**
     * 初始化数组（原始数组）
     * 将输入的数据转成题干提及的数据类型（Int整数类型）
     */
    int[] initArray = new int[split.length];
    for(int i = 0;i<split.length;i++){
      initArray[i] = Integer.valueOf(split[i]);
    }
    System.out.print("initArray: ");
    sout(initArray);
    System.out.println("--- 数组初始化完成 ---");

    /**
     * 生成差值数组
     *
     * 将初始化的数组，按照每项的元素数值累加填入新的数组中
     * 目的：
     *    元素之间的差值会换算成概率计算，省去了排序的时间。
     *    生成随机数的时候，按照这个数组元素间的差值（区间）寻找对应原始数组的下标，
     *    即可找到对应的原始数组的实际元素
     */

    int[] totalArray = new int[initArray.length];
    int total = 0; // 计算所有元素的总和，后面随机数将在这个 0 ~ total 值范围中随机生成
    for (int i = 0; i < initArray.length; i++) {
      total += initArray[i];
      totalArray[i] = total;
    }
    System.out.print("totalArray: ");
    sout(totalArray);
    System.out.println("总和为： " + total);
//    System.out.println("差值数组： " + totalArray); // 这里为了方便代码阅读，不把 totalArray 展示出来


    /**
     * 生成随机数：
     *
     * total：上方的 total是用来做随机数范围的。
     * i1：用来获取 0 ~ total 之间的随机数。
     *
     */
    Random r = new Random();
    int  i1 = r.nextInt(total);
    System.out.println("---生成的随机数是：---  "+i1);


    /**
     *  根据 “随机数” 和 “差值数组” ，利用二分法算出随机数坐落在差值数组的区间，
     *  并取得 差值数组 的区间的下标
     */
    int result = recursion(0, totalArray.length-1, totalArray, i1);
    System.out.println("---随机数坐落在差值数组的下标（同时也是中奖用户的ID）：--- "+result);
    System.out.println("---初始数组对应的数值是：---"+initArray[result]);
    System.out.println("---中奖用户的ID：---"+result);
//
//    redisService.all();
    return result;
  }

  /**
   * 递归实现二分法
   *
   * @param start
   * @param end
   * @param arr
   * @param key
   * @return
   */
  public static int recursion(int start, int end, int[] arr, int key) {

    //递归算法结束条件，因为是计算区间，只要end大于start，就达到条件了
    if (start > end) {
      return start;
    }

    int middle = (start + end) / 2;
    if (key < arr[middle]) {
      return recursion(start, middle - 1, arr, key);
    } else if (key > arr[middle]) {
      return recursion(middle + 1, end, arr, key);
    } else {
      return middle;
    }
  }

  public static void sout(int[] arr) {
    String s = "";
    for(int i=0;i<arr.length;i++){
      s += arr[i]+",";
    }
    System.out.println(s.substring(0,s.length()-1));
  }

  public static String  input(){
    /**
     * 输入案例：
     * 5,4,3,13,4,34,34,45,2,1
     */
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入积分数组，长度不可大于50000：（按逗号分隔）");
    String str =  scanner.next();

    return str;
  }

}
