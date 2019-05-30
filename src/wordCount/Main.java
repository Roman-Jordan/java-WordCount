package wordCount;

import java.util.*;

public class Main{
	public static void main(String[] args){


        String string = "I i i i i i i am a string of stuff to be filtered and sort";
        
        //String To Array
        string.replaceAll("[[\\.\\?\\!\\,\\;\\:\\{\\}\\(\\)\\']]", "");
        String[] words = string.split(" +");

       
        // Declaring Array Type as Object.. I think 
        StringFilter filteredWords[] = new StringFilter[words.length];

        //Count Occurences
        for (int i = 0; i < words.length;i++){
            String word = words[i].toLowerCase();
            int occurences = 0;
            for (int x = 0; x < words.length;x++){
                if(word.equals(words[x].toLowerCase())){
                    occurences++;
                }
            }
            filteredWords[i] = new StringFilter(words[i],i,occurences);
        }
        
        ArrayList<StringFilter> wordsArrayList = new ArrayList<StringFilter>();
		wordsArrayList.addAll(Arrays.asList(filteredWords));
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
                    System.out.println(o2.getKey());
                }
                return o1.getValue().getOccurences() - o2.getValue().getOccurences();
            }
		});
		//sortedMap.forEach(d -> System.out.println(d));
	}
}