package com.urbanise.mmanchev.source.dataproviders;

/**
 * Classes implementing this interface are responsible for providing input to <name>DependencyGraph<name/> structures.
 * This class' subclasses act as input consumers themselves. The way the input is fed to them depends on specific
 * implementation but the format must be as follows:
 *
 * <string11> <string12> ... <string1N>
 * <string21> <string22> ... <string2H>
 *     .
 *     .
 *     .
 * <stringM1> <stringM2> ... <stringMK>
 *
 * where N, H, K, M are finite whole numbers.
 *
 * @author mmanchev, 25.02.17
 */
public interface DataInputProvider {

    /**
     * Provides meaningful data as a String formated according to specific rules.
     * @return a formated string representing useful data.
     */
    public String provide();
}
