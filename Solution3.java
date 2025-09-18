/*
 * Problem: Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * Link:https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Time Complexity: O(n)
 * Space Complexity: O(min(m, n)) where m is the size of the character set and n is the length of the string
 * Given : string s, return : length of the longest substring without repeating characters.
 * Example : s = "abcabcbb"
 *              - The answer is "abc", with the length of 3.
 *  Approach :
 *  1) Sliding window technique use karo        
 *  2) HashMap use karo to store characters and their indices
 *     Set/HashSet (convenient & efficient) : Best for uniqueness and check repeated characters
 *  3) Do pointers rakho: left (start of window) and right (end of window)
 *     Here Window = substring without repeating characters
 *  4) Right pointer ko iterate karo through the string
 *  5) Agar character repeat ho raha hai aur uska index left se bada ya equal hai,
 *        toh left pointer ko uske next index pe le jao
 *  6) Character aur uska index HashMap me update karo
 *  7) Longest substring length ko update karo: right - left + 1
 *  8) Loop ke baad longest substring length return karo
 *  9) Edge cases:
 *       Empty string
 *       All characters same
 *       String with all unique characters
 *       Sliding window technique
 *       HashMap for character indices
 *       Update left pointer on repeats
 *       Update longest length
 *   Here is Java Solution :
 */
import java.util.*;
public class Solution3{
    public int lengthOfLongestSubstring(String s) {
        // HashSet to store unique characters in the current window
        Set<Character> set = new HashSet<>();
        // Two pointers for the sliding window
        int left = 0, maxLen = 0;
        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, move the left pointer
            // to the right until the character is removed from the set
            while (set.contains(s.charAt(right))) {
                // Remove the character at the left pointer and move left pointer to the right
                set.remove(s.charAt(left));
                // Move the left pointer to the right
                left++;
            }
            // Add the current character to the set
            set.add(s.charAt(right));
            // Update the maximum length of the substring
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    // Main Method Directly not written in Leetcode
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        Solution3 obj = new Solution3();
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}
/*
 * Example Dry and Run : s = abcbebb
 *  left = 0, right = 0, maxLen = 0
 *  1) right = 0, char = 'a', set = {'a'}, maxLen = 1
 *  2) right = 1, char = 'b', set = {'a', 'b'}, maxLen = 2
 *  3) right = 2, char = 'c', set = {'a', 'b', 'c'}, maxLen = 3
 *  4) right = 3, char = 'b' (repeat)
 *      - set = {'a', 'b', 'c'}
 *      - b already in set, 
 *           - remove 'a': left = 1, set = {'b', 'c'}
 *           - remove 'b': left = 2, set = {'c'}
 *      - set = {'c'} add 'b': set = {'c', 'b'}, maxLen = 3
 *  5) right = 4, char = 'e', set = {'c', 'b', 'e'}, left =2, maxLen = 3
 *  6) right = 5, char = 'b' (repeat)
 *      - set = {'c', 'b', 'e'}
 *      - b already in set,
 *             - remove 'c': left = 3, set = {'b', 'e'}
 *             - remove 'b': left = 4, set = {'e'}
 *      - set = {'e'} add 'b': set = {'e', 'b'}, maxLen = 3
 *  7) right = 6, char = 'b' (repeat)
 *       - set = {'e', 'b'}
 *       - b already in set,
 *             - remove 'e': left = 5, set = {'b'}
 *             - remove 'b': left = 6, set = {}
 *       - set = {} add 'b': set = {'b'}, maxLen = 3
 *  End of string, return maxLen = 3
 *  Output: 3 
 *  Simply String me hum right se start karege unique 
 *  characters ko check karna or or set me char dalege 
 *  or right ko increase karege jab tak set me se koi char 
 *  repeat na ho jaye, repeat hone pe set me se pehle waale 
 *  repeated char tak ke sare char remove kar denge
 *  or left ko uske next index pe le jaenge, or fir se
 *  char ko set me add karenge or maxLen ko update karenge.
 */
