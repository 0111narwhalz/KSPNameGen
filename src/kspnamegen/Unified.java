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

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

class Unified
{
    //Array defs
    static String[] fcp = {    // female constructed prefix
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
    static String[] fcs = {    // female constructed suffix
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
    static String[] fpr = {    // female proper name
        "Alice", "Barbara", "Bonnie", "Brooke", "Carol", "Dottie", "Dotty",
        "Eileen", "Ellen", "Heidi", "Jane", "Jean", "Jeaneane", "Jeanette",
        "Joan", "Judith", "Karen", "Leah", "Leia", "Lisa", "Lola", "Margaret",
        "Maya", "Megan", "Mila", "Nancy", "Nicole", "Nina", "Olivia", "Peggy",
        "Phoebe", "Piper", "Sally", "Samantha", "Sara", "Sarah", "Serena",
        "Shannon", "Stephanie", "Summer", "Svetlana", "Tamara", "Tati",
        "Tatyana", "Valentina"
    };
    static String[] mcp = {    // male constructed prefix
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
    static String[] mcs = {    // male constructed suffix
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
    static String[] mpr = {    // male proper name
        "Adam", "Al", "Alan", "Archibald", "Buzz", "Carson", "Chad", "Charlie",
        "Chris", "Chuck", "Dean", "Ed", "Edan", "Edlu", "Frank", "Franklin",
        "Gus", "Hans", "Jack", "James", "Jim", "Kirk", "Kurt", "Lars", "Luke",
        "Mac", "Matt", "Phil", "Randall", "Scott", "Scott", "Sean", "Steve",
        "Tom", "Will"
    };
    
    static enum index {
        TYPE, CMBO, GNDR, NMBR
    }
    static String[] prompts = { // cache all the prompts
        /*TYPE*/"Specify types of names to generate.\n" +
                "Type 'f' for Future-style names or 's' for standard names.\n",
        /*CMBO*/"Specify if you want to generate:\n" +
                " r: a combination of constructed and proper names\n" +
                " c: constructed names only\n" +
                " p: proper names only",
        /*GNDR*/"Specify gender of generated names.\n" +
                "'m' for male, 'f' for female",
        /*NMBR*/"Specify count of names to generate."
    };
        
    
    //Other static var defs
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();
    
    static void Loop()
    {
        String input;
        Boolean gen = true;
        for(;;)
        {
            if(gen)
            {
                nameGen();
            }
            input = PromptS("Would you like to generate more names? Y/N", false);
            switch(input)
            {
                case "y":
                    gen = true;
                    break;
                case "n":
                    Kill();
                    break;
                default:
                    System.out.println("Invalid response.");
                    gen = false;
                    break;
            }
        }
    }
    
    static void Kill()
    {
        System.out.print("Exiting");
        for(int i = 0; i < 3; i++)
        {
            Thread.sleep(250);
            System.out.print(".");
        }
        System.Exit(0);
    }
    
    static void nameGen()
    {
        nameGen("TYPE");
    }
    
    static void nameGen(String inpar, String param)
    {
        String input;
        int inint;
        
        switch(inpar)
        {
            case "TYPE":
                input = PromptS(prompt[index.TYPE]);
                switch(input)
                {
                    case exit:
                        Kill();
                        break;
                    case f:
                        param = "f";
                        inpar = "GNDR";
                        break;
                    case s:
                        param = "s";
                        inpar = "CMBO";
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
                nameGen(inpar, param);
                break;
            case "CMBO":
                input = PromptS(prompt[index.CMBO]);
                switch(input)
                {
                    case exit:
                        Kill();
                        break;
                    case r:
                        param += r;
                        inpar = "GNDR";
                        break;
                    case c:
                        param += c;
                        inpar = "GNDR";
                        break;
                    case p:
                        param += p;
                        inpar = "GNDR";
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            case "GNDR":
                input = PromptS(prompt[index.GNDR]);
                switch(input)
                {
                    case "f":
                        param += "f";
                        inpar = "NMBR";
                        break;
                    case "m":
                        param += "m";
                        inpar = "NMBR";
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            case "NMBR":
                inint = PromptI(prompt[index.NMBR]);
                if(inint < 0)
                {
                    System.out.println("Number was less than zero.");
                    nameGen(inpar, param);
                    return;
                }
                for(int i = 0; i < inint; i++)
                {
                    Generate(param);
                }
                inpar = "CMPT";
            case "CMPT":
                return;
        }
        nameGen(inpar, param);
    }
    
    static String PromptS(String query, boolean help)
    {
        System.out.println(query);
        if(help)
        {
            System.out.println("Type 'help' for help; 'exit' to exit.");
        }
        return scan.nextLine().toLowerCase();
    }
    
    static int PromptI(String query)
    {
        int inputInt = 0;
        System.out.println(query);
        try {
            inputInt = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("A number was not specified.");
            inputInt = PromptI(query);
        }
        return inputInt;
    }
    
    static void Generate(String param)
    {
        boolean toggle = random.nextInt(20) == 0;
        switch(param)
        {
            case "ff":
                System.out.println(fpr[random.nextInt(fpr.length)] + " " + fcp[random.nextInt(fcp.length)] + fcs[random.nextInt(fcs.length)]);
                break;
            case "fm":
                System.out.println(mpr[random.nextInt(mpr.length)] + " " + mcp[random.nextInt(mcp.length)] + mcs[random.nextInt(mcs.length)]);
                break;
            case "srf":
                if (bool) {
                    System.out.println(fpr[random.nextInt(fpr.length)] + " Kerman");
                } else {
                    System.out.println(fcp[random.nextInt(fcp.length)] + fcs[random.nextInt(fcs.length)] + " Kerman");
                }
                break;
            case "srm":
                if (bool) {
                    System.out.println(mpr[random.nextInt(mpr.length)] + " Kerman");
                } else {
                    System.out.println(mcp[random.nextInt(mcp.length)] + mcs[random.nextInt(mcs.length)] + " Kerman");
                }
                break;
            case "scf":
                System.out.println(fpr[random.nextInt(fpr.length)] + " Kerman");
                break;
            case "scm":
                System.out.println(mcp[random.nextInt(fcp.length)] + mcs[random.nextInt(fcs.length)] + " Kerman");
                break;
            case "spf":
                System.out.println(fpr[random.nextInt(fpr.length)] + " Kerman");
                break;
            case "spm":
                System.out.println(mpr[random.nextInt(mpr.length)] + " Kerman");
                break;
            default:
                System.out.println("Specified type is invalid.")
        }
    }
}
