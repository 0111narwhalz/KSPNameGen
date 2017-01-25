/*
 * KSPNameGen: name generator for Kerbal Space Program
 * Kerbal Space Program is (c) 2011-2017 Squad. All Rights Reserved.
 * KSPNameGen is (c) 2016-2017 0111narwhalz & TotallyNotHuman_
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package kspnamegen;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class nameGen {

    static void main(String[] args) throws InterruptedException {

        // array defs

        String[] fcp = {    // female constructed prefix
            "Aga", "Al", "An", "Ar", "As", "Bar", "Bea", "Ber", "Car", "Cat",
            "Cer", "Clau", "Cris", "Da", "Dan", "Daph", "De", "Deb", "Di", "Eil",
            "Eli", "Eri", "Fran", "Gem", "Ger", "Gi", "Gil", "Gle", "Gra", "Gwen",
            "Hai", "Hay", "Hel", "Hil", "Ir", "Isa", "Ja", "Jan", "Jen", "Jes",
            "Jo", "Jul", "Ka", "Kar", "Kat", "Kath", "Ker", "Kim", "La", "Lager",
            "Le", "Lea", "Lee", "Lin", "Lis", "Liz", "Lu", "Ma", "Mad", "Mag",
            "Mar", "Mau", "Max", "Meg", "Mel", "Mi", "Mia", "Mil", "Mir", "Mo",
            "Na", "Nata", "Ne", "Pa", "Pho", "Ra", "Ro", "Ros", "Sam", "San",
            "Si", "Sie", "Sig", "Sta", "Stel", "Su", "Tam", "Tan", "Te", "Ti",
            "Tra", "Tri", "Ur", "Val", "Ver", "Vir", "Wen", "Wil", "Zel"
        };

        String[] fcs = {    // female constructed suffix
            "a", "alla", "an", "anda", "anna", "anne", "ayne", "be", "bel",
            "bella", "belle", "berta", "beth", "bie", "by", "ca", "cee", "cella",
            "chel", "chell", "chelle", "cia", "cie", "cine", "cy", "da", "di",
            "dia", "die", "dine", "dolin", "dra", "drien", "e", "edith", "ee",
            "ela", "ella", "elle", "elyn", "emma", "ena", "ene", "enna", "erta",
            "et", "ette", "gee", "gela", "gie", "grid", "gy", "i", "iana", "ica",
            "icca", "ice", "ie", "iel", "iella", "igh", "in", "ina", "ine",
            "inne", "is", "isa", "ise", "issa", "jorie", "ke", "la", "lee",
            "lenna", "lian", "liana", "lie", "lin", "lina", "line", "linne",
            "lla", "llian", "lotte", "ly", "lyn", "ma", "mie", "mma", "my", "na",
            "na", "nda", "ne", "nica", "nie", "nna", "nne", "ny", "otte", "phe",
            "phia", "phie", "ra", "re", "ree", "righ", "rina", "rine", "ris",
            "rix", "rude", "ry", "rys", "sa", "san", "sei", "selle", "sha", "sie",
            "sy", "t", "ta", "te", "tha", "this", "thy", "ti", "tina", "tine",
            "trice", "trid", "tris", "trix", "trude", "tte", "ty", "uki", "ula",
            "una", "vie", "vy", "xie", "xy", "y", "ya", "yin", "yn", "yne", "ys",
            "zie", "zy"
        };

        String[] fpr = {    // female proper name
            "Alice", "Barbara", "Bonnie", "Brooke", "Carol", "Dottie", "Dotty",
            "Eileen", "Ellen", "Heidi", "Jane", "Jean", "Jeaneane", "Jeanette",
            "Joan", "Judith", "Karen", "Leah", "Leia", "Lisa", "Lola", "Margaret",
            "Maya", "Megan", "Mila", "Nancy", "Nicole", "Nina", "Olivia", "Peggy",
            "Phoebe", "Piper", "Sally", "Samantha", "Sara", "Sarah", "Serena",
            "Shannon", "Stephanie", "Summer", "Svetlana", "Tamara", "Tati",
            "Tatyana", "Valentina"
        };

        String[] mcp = {    // male constructed prefix
            "Ad", "Al", "Ald", "An", "Bar", "Bart", "Bil", "Billy-Bob", "Bob",
            "Bur", "Cal", "Cam", "Chad", "Cor", "Dan", "Der", "Des", "Dil", "Do",
            "Don", "Dood", "Dud", "Dun", "Ed", "El", "En", "Er", "Fer", "Fred",
            "Gene", "Geof", "Gil", "Greg", "Gus", "Had", "Hal", "Han", "Har",
            "Hen", "Her", "Hud", "Jed", "Jen", "Jer", "Joe", "John", "Jon", "Jor",
            "Kel", "Ken", "Ker", "Kir", "Lan", "Lem", "Len", "Lo", "Lod", "Lu",
            "Lud", "Mac", "Mal", "Mat", "Mel", "Mer", "Mil", "Mit", "Mun", "Ned",
            "Neil", "Nel", "New", "Ob", "Or", "Pat", "Phil", "Ray", "Rib", "Rich",
            "Ro", "Rod", "Ron", "Sam", "Sean", "See", "Shel", "Shep", "Sher",
            "Sid", "Sig", "Son", "Thom", "Thomp", "Tom", "Wehr", "Wil"
        };

        String[] mcs = {    // male constructed suffix
            "ald", "bal", "bald", "bart", "bas", "berry", "bert", "bin", "ble",
            "bles", "bo", "bree", "brett", "bro", "bur", "burry", "bus", "by",
            "cal", "can", "cas", "cott", "dan", "das", "den", "din", "do", "don",
            "dorf", "dos", "dous", "dred", "drin", "dun", "ely", "emone", "emy",
            "eny", "fal", "fel", "fen", "field", "ford", "fred", "frey", "frey",
            "frid", "frod", "fry", "furt", "gan", "gard", "gas", "gee", "gel",
            "ger", "gun", "hat", "ing", "ke", "kin", "lan", "las", "ler", "ley",
            "lie", "lin", "lin", "lo", "lock", "long", "lorf", "ly", "mal", "man",
            "min", "ming", "mon", "more", "mund", "my", "nand", "nard", "ner",
            "ney", "nie", "ny", "oly", "ory", "rey", "rick", "rie", "righ", "rim",
            "rod", "ry", "sby", "sel", "sen", "sey", "ski", "son", "sted", "ster",
            "sy", "ton", "top", "trey", "van", "vey", "vin", "vis", "well", "wig",
            "win", "wise", "zer", "zon", "zor"
        };

        String[] mpr = {    // male proper name
            "Adam", "Al", "Alan", "Archibald", "Buzz", "Carson", "Chad", "Charlie",
            "Chris", "Chuck", "Dean", "Ed", "Edan", "Edlu", "Frank", "Franklin",
            "Gus", "Hans", "Jack", "James", "Jim", "Kirk", "Kurt", "Lars", "Luke",
            "Mac", "Matt", "Phil", "Randall", "Scott", "Scott", "Sean", "Steve",
            "Tom", "Will"
        };

        // variable definitions

        Random random = new Random(); // used for namegen and probability
        Scanner scanner = new Scanner(System.in); // should be obvious
        boolean bool = random.nextInt(20)==0; // used for probability
        String nameGenParams = null; // just an init to stop NB from freaking out

        // mostly user input here

        System.out.println("Specify type of names to generate.");
        System.out.println("Type 'f' for Future-style names, and 's' for standard names.");
        System.out.println("Type 'help' for help, or type 'exit' to exit.");
        String inputStr = scanner.nextLine().toLowerCase();
        switch (inputStr) {
            case "exit":    System.out.println("Exiting...");
                            Thread.sleep(2000);
                            System.exit(0);
                            break;
            case "help":    helpPage.main(args);
                            break;
            case "f":       nameGenParams = "f";
                            break;
            case "s":       nameGenParams = "s";
                            break;
            default:        System.out.println("Specified type is not valid.");
                            nameGen.main(args);
                            break;
        }

        if ("f".equals(nameGenParams)) { // if the selected type is Future
          break; // then just skip this
        } else { // else; more selection
          System.out.println("Specify if you want to generate:"
                  + "\na combination of both constructed and proper names (type [r]),"
                  + "\nconstructed names only (type [c])"
                  + "\nor proper names only [p].");
          System.out.println("Type 'help' for help, or type 'exit' to exit.");
          String inputStr2 = scanner.nextLine().toLowerCase();
          switch (inputStr2) {
              case "exit":    System.out.println("Exiting...");
                              Thread.sleep(2000);
                              System.exit(0);
                              break;
              case "help":    helpPage.main(args);
                              break;
              case "r":       nameGenParams = "sr";
              case "c":       nameGenParams = "sc";
              case "p":       nameGenParams = "sp";
            }
        }

        System.out.println("Specify gender for generated names.");
        System.out.println("Type 'f' for female, and 'm' for male.");
        String inputStr3 = scanner.nextLine().toLowerCase();
        switch (inputStr3) {
            case "f":       if ("f".equals(nameGenParams)) {
                                nameGenParams = "ff";
                            } else if ("sr".equals(nameGenParams)) {
                                nameGenParams = "srf";
                            } else if ("sc".equals(nameGenParams)) {
                                nameGenParams = "scf";
                            } else if ("sp".equals(nameGenParams)) {
                                nameGenParams = "spf";
                            }
                            break;
            case "m":       if ("f".equals(nameGenParams)) {
                                nameGenParams = "fm";
                            } else if ("sr".equals(nameGenParams)) {
                                nameGenParams = "srm";
                            } else if ("sc".equals(nameGenParams)) {
                                nameGenParams = "scm";
                            } else if ("sp".equals(nameGenParams)) {
                                nameGenParams = "spm";
                            }
                            break;
            default:        System.out.println("Specified gender is not valid.");
                            nameGen.main(args);
                            break;
        }

        System.out.println("Specify number of names to generate.");
        int inputInt = 0;
        try {
            inputInt = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("A number was not specified.");
            nameGen.main(args);
        }
        if (inputInt <= 0) {
            System.out.println("A negative number / zero was specified.");
            System.out.println("Please specify a nonzero, nonnegative number.");
            nameGen.main(args);
        }

        // namegen code starts here

        switch (nameGenParams) {
            case "ff":      for (int i=0; i<inputInt; i++) { // loops for inputInt times
                                System.out.println(fpr[random.nextInt(fpr.length)] + " " + fcp[random.nextInt(fcp.length)] + fcs[random.nextInt(fcs.length)]);
                                // female proper name + space + female constructed prefix + female constructed suffix
                            }
                            System.out.println("Name generation successful.");
                            nameGenLoop.main(args);
                            break;
            case "fm":      for (int i=0; i<inputInt; i++) { // loops for inputInt times
                                System.out.println(mpr[random.nextInt(mpr.length)] + " " + mcp[random.nextInt(mcp.length)] + mcs[random.nextInt(mcs.length)]);
                                // female proper name + space + female constructed prefix + female constructed suffix
                            }
                            System.out.println("Name generation successful.");
                            nameGenLoop.main(args);
                            break;
            case "srf":     for (int i=0; i<inputInt; i++) { // loops for inputInt times
                                if (bool) { // if bool is true (1/20 chance)
                                    System.out.println(fpr[random.nextInt(fpr.length)] + " Kerman");
                                    // female proper name + Kerman
                                } else { // else
                                    System.out.println(fcp[random.nextInt(fcp.length)] + fcs[random.nextInt(fcs.length)] + " Kerman");
                                    // female constructed prefix + female constructed suffix + Kerman
                                }
                            }
                            System.out.println("Name generation successful.");
                            nameGenLoop.main(args);
                            break;
            case "srm":     for (int i=0; i<inputInt; i++) { // loops for inputInt times
                                if (bool) { // if bool is true (1/20 chance)
                                    System.out.println(mpr[random.nextInt(mpr.length)] + " Kerman");
                                    // male proper name + Kerman
                                } else { // else
                                    System.out.println(mcp[random.nextInt(mcp.length)] + mcs[random.nextInt(mcs.length)] + " Kerman");
                                    // male constructed prefix + male constructed suffix + Kerman
                                }
                            }
                            System.out.println("Name generation successful.");
                            nameGenLoop.main(args);
                            break;
            case "scf":     for (int i=0; i<inputInt; i++) { // loops for inputInt times
                            System.out.println(fcp[random.nextInt(fcp.length)] + fcs[random.nextInt(fcs.length)] + " Kerman");
                            // female constructed prefix + female constructed suffix + Kerman
                            }
                            break;
            case "scm":     for (int i=0; i<inputInt; i++) { // loops for inputInt times
                            System.out.println(mcp[random.nextInt(mcp.length)] + mcs[random.nextInt(mcs.length)] + " Kerman");
                            // male constructed prefix + male constructed suffix + Kerman
                            }
                            break;
            case "spf":     for (int i=0; i<inputInt; i++) { // loops for inputInt times
                            System.out.println(fpr[random.nextInt(fpr.length)] + " Kerman");
                            // female proper name + Kerman
                            }
                            break;
            case "spm":     for (int i=0; i<inputInt; i++) { // loops for inputInt times
                            System.out.println(mpr[random.nextInt(mpr.length)] + " Kerman");
                            // male proper name + Kerman
                            }
                            break;
            default:        System.out.println("Specified type is not valid.");
                            nameGen.main(args);
                            break;

        }

    }

}
