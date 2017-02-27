package com.urbanise.mmanchev.source.dataproviders;

/**
 * Classes implementing this interface are responsible for providing input to <name>DependencyGraph<name/> structures.
 * This class' subclasses act as input consumers themselves. The way the input is fed to them depends on specific
 * implementation but the format must be as follows:<br />
 *
 * &lt;string11&gt; &lt;string12&gt; ... &lt;string1N&gt;<br />
 * &lt;string21&gt; &lt;string22&gt; ... &lt;string2H&gt;<br />
 *     .<br />
 *     .<br />
 *     .<br />
 * &lt;stringM1&gt; &lt;stringM2&gt; ... &lt;stringMK&gt;<br />
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
