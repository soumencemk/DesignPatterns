package prototype;

/**
 * @author Soumen Karmakar
 * 07/06/2020
 */
public interface PrototypeCapable extends Cloneable{

    PrototypeCapable clone() throws CloneNotSupportedException;
}
