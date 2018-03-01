package lesson3.testSpeed;

import java.sql.SQLException;

/**
 * Created by Kushn_000 on 22.02.2018.
 */
public class Demo {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.testDeletePerformance());
        //System.out.println(solution.testSelectByIdPerformance());
        System.out.println(solution.testSelectPerformance());

//        try {
//            System.out.println(solution.testSavePerformance());
//
//            //System.out.println(solution.testDeleteByIdPerformance());
//
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
    }
}
