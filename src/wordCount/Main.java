package wordCount;

import java.util.*;

public class Main{
	public static void main(String[] args){


        String string = "I i i i i i i am a string of stuff to be filtered and sort";
        
        //String To Array
        string.replaceAll("[[\\.\\?\\!\\,\\;\\:\\{\\}\\(\\)\\']]", "");
        String[] words = string.split(" +");

       
        

        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        for(String word:words){
             if (!wordMap.containsKey(word)){
                wordMap.put(word, 1);
            }
            else{
                wordMap.put(word, wordMap.get(word) + 1);
            }
        }
        
        ArrayList<StringFilter> wordsArrayList = new ArrayList<StringFilter>();
		wordsArrayList.addAll(wordMap.entrySet());
        //Begin Hash Map
        HashMap<Integer, StringFilter> wordsHashMap = new HashMap<Integer, StringFilter>();
		int hashCount = 0;
		for (StringFilter d : wordsArrayList){
			// we need a kay (integer)
			wordsHashMap.put(hashCount, d);   
			hashCount++;
		}
		wordsArrayList.clear();
		// will clear the array list and the information from computer memory
        
        ArrayList<HashMap.Entry<Integer, StringFilter>> sortedMap = new ArrayList<HashMap.Entry<Integer, StringFilter>>();
		sortedMap.addAll(wordsHashMap.entrySet());
		// add all takes entire set in the hashmap and adds it to the array list. we dont know what order it goes into though.
		Collections.sort(sortedMap, new Comparator<Map.Entry<Integer, StringFilter> >(){
            public int compare (HashMap.Entry<Integer, StringFilter> o1, HashMap.Entry<Integer, StringFilter> o2){
                if (o1.getValue().getWord().equals(o2.getValue().getWord())) {
                    System.out.println(o2.getKey());
                    sortedMap.remove(o2.getKey());
                    System.out.println();
                }
                return o1.getValue().getOccurences() - o2.getValue().getOccurences();
            }
		});
		sortedMap.forEach(d -> System.out.println(d));
	}
}