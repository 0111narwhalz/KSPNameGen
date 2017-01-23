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

import java.util.Scanner;

public class nameGenLoop {

    static void main(String[] args) throws InterruptedException {
        System.out.println("Would you like to generate more names? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String yn = scanner.nextLine().toLowerCase();
        switch (yn) {

            case "y": nameGen.main(args);
                      break;
            case "n": System.out.println("Exiting...");
                      Thread.sleep(2000);
                      System.exit(0);
                      break;
            default:  System.out.println("Invalid selection.");
                      nameGenLoop.main(args);
                      break;
                      
        }
    }
    
}
