package annotation.exercise;

/**
 * @auther 薛晨
 * @date 2019/12/20
 * @time 19:27
 * @description
 */
@MyClassAnnotation(className = "Table", description = "对应数据库表table")
public class MyTable {

    @MyFieldAnnotation(fieldName = "id", description = "注解")
    private Integer id;

    @MyFieldAnnotation(fieldName = "columnName", description = "列名")
    private String columnName;
}
