// Java program to find length
// of the shortest chain
// transformation from source
// to target
import java.util.*;

class WordLadder
{


    static int shortestChainLen(String begin,
                                String target,
                                Set<String> D)
    {

        if(begin == target)
            return 0;

        if (!D.contains(target))
            return 0;

        int l1 = 0, wordlen = begin.length();

        Queue<String> Q = new LinkedList<>();
        Q.add(begin);

        // While the queue is non-empty
        while (!Q.isEmpty())
        {

            // Increment the chain length
            ++l1;

            // Current size of the queue
            int sizeofQ = Q.size();


            for (int i = 0; i < sizeofQ; ++i)
            {

                // Remove the first word from the queue
                char []word = Q.peek().toCharArray();
                Q.remove();

                // For every character of the word
                for (int pos = 0; pos < wordlen; ++pos)
                {


                    char orig_char = word[pos];


                    for (char c = 'a'; c <= 'z'; ++c)
                    {
                        word[pos] = c;

                        if (String.valueOf(word).equals(target))
                            return l1 + 1;


                        if (!D.contains(String.valueOf(word)))
                            continue;
                        D.remove(String.valueOf(word));


                        Q.add(String.valueOf(word));
                    }


                    word[pos] = orig_char;
                }
            }
        }

        return 0;
    }

    // Driver code
    public static void main(String[] args)
    {
        // make dictionary
        Set<String> s = new HashSet<String>();
        s.add("poon");
        s.add("plee");
        s.add("same");
        s.add("poie");
        s.add("plie");
        s.add("poin");
        s.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.print("Length of shortest chain is: "
                + shortestChainLen(start, target, s));
    }
}

