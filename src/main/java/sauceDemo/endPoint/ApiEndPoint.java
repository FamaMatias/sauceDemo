package sauceDemo.endPoint;

public class ApiEndPoint {
    private static final String MENU = "menu";

    private static final String DEPARTMENTS = "departments";

    public static String obtenerEndPoint(String endpoint){
        switch (endpoint){
            case "menu":
                return ApiEndPoint.MENU;

            case "departments":
                return ApiEndPoint.DEPARTMENTS;

            default:
                break;
        }
        return "";
    }
}
