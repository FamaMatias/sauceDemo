package sauceDemo.endPoint;

public class ApiEndPoint {

    private static final String MENU = "menu";
    private static final String DEPARTMENTS = "departments";
    private static final String MENU_DEPARTMENTS = "menu/departments";


    public static String obtenerEndPoint(String endpoint){
        switch (endpoint){

            case "menu":
                return ApiEndPoint.MENU;

            case "departments":
                return ApiEndPoint.DEPARTMENTS;

            case "menu/departments":
                return ApiEndPoint.MENU_DEPARTMENTS;

            default:
                break;
        }
        return "";
    }
}
