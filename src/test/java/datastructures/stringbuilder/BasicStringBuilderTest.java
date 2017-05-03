package datastructures.stringbuilder;

import datastructures.custom.stringbuilder.BasicStringBuilder;

/**
 * Created by mman on 11.02.17.
 */
public class BasicStringBuilderTest {

    public static void main(String[] args) {
        BasicStringBuilder sb = new BasicStringBuilder("mir");

        sb.append('o').append('s').append('l').append('a').append('v');

        System.out.println(sb);
    }
}
