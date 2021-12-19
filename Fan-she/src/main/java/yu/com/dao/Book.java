package yu.com.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Book
 * @Date 2021/4/9 10:15
 * @Created by yufx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book{
    private final static String TAG = "BookTag";

    private String name;
    private String author;

    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "I am declaredMethod 1 !";
                break;
            case 1:
                string = "I am declaredMethod 2 !";
                break;
            default:
                string = "I am declaredMethod 1 !";
        }

        return string;
    }
}
