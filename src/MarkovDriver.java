/*
Trent Blair
4/4/24
this class drives the markov chain and generates the text
collaborated with Ishan
 */
public class MarkovDriver {

    public static void main(String[] args) {
        MarkovChain m = new MarkovChain();
        m.readingText();
        m.addDictionary();//these are in the markov chain class and will ask the users for the files

        System.out.println(m.createText());
    }

}
