package FormFramework.action;

public class ActionHandlerFactory {

    public static ActionHandler createAction(String type) {
        switch(type) {
            case "default":
                return new DefaultActionHandler();
            default:
                try {
                    ClassLoader classLoader = ActionHandlerFactory.class.getClassLoader();
                    Class<?> actionHandlerClass = classLoader.loadClass(type);
                    return (ActionHandler) actionHandlerClass.newInstance();
                } catch(Exception e) {
                    System.err.println("Error creation action handler.");
                    e.printStackTrace();
                    System.exit(0);
                }
        }
        return null;
    }
}
