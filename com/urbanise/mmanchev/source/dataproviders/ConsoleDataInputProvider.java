package com.urbanise.mmanchev.source.dataproviders;

import com.urbanise.mmanchev.source.utils.PrintUtils;

import java.util.Scanner;

/**
 * Created by mman on 25.02.17.
 */
public class ConsoleDataInputProvider implements DataInputProvider {

    @Override
    public String provide() {
        StringBuilder sb = new StringBuilder();

        try (Scanner scan = new Scanner(System.in).useDelimiter(PrintUtils.NL)) {
            String answer = null;
            do {
                PrintUtils.print("Type dependency: ");
                String line = scan.nextLine();
                if (line != null && !line.isEmpty()) {
                    sb.append(line);
                    sb.append(PrintUtils.NL);
                }
                PrintUtils.newLine();
                PrintUtils.print("Continue? [Y]/N");
                answer = scan.nextLine();
            } while (!answer.equalsIgnoreCase("N"));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DataInputProvider in = new ConsoleDataInputProvider();
        System.out.println(in.provide());
    }
}
