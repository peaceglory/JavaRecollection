package oop.design.dzone.abstractfactory;

/**
 * <p>
 * <b>Intent:</b><br />
 * Enables clients to create families of related objects without the need to know which classes need to be instantiated.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * Hides implementation details - clients are only aware of interfaces.
 * </p>
 *
 * <p>
 * <b>Downs:</b>
 * <ul>
 * <li>If it is not actually needed it adds complexity.</li>
 * <li>The exact factory to be used is sometimes determined at runtime with some if/else statements (although that's not always the case).</li>
 * </ul>
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        String platform = "Linux";

        GUIBuilder builder = new GUIBuilder();
        AbstractWidgetFactory widgetFactory = null;
        //check what platform we're on
        if (platform.equals("MACOSX")) {
            widgetFactory = new MacOSXWidgetFactory();
        } else {
            widgetFactory = new MsWindowsWidgetFactory();
        }
        builder.buildWindow(widgetFactory);
    }
}
