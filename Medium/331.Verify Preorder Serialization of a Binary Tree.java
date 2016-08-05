// At the first glance, I have no idea about the problem. So I decided to simulate some cases to find whether there are some regulations. After trying several cases I found that the value before two consecutive '#'s should be a leaf and there are two consecutive '#'s after a leaf. So I think out a solution using stack.

// Here is the steps of the algorithm:

// 1)push a '*' when we encounter a number;

// 2)push a '#' when we encounter a '#',

// then judge whether the top two elements in the stack are '#', -------------- question 1

// if yes for question 1,

// judge whether the third element is '*' ---------------- question 2

// if yes for question 2, pop the top three element, then push a '#'.

// if no for question 2, then return false.

// if no for question 1, then continue.

// In the end, if there is only one element in the stack and it is '#', then return true, else return false.

// This algorithm runs in O(n) time complexity and O(n) space complexity.

//method 2
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] chars = preorder.split(",");
    
    int sentinel = 0;
    int node = 0;
    for (int i = chars.length - 1; i >= 0; i--)
    {
        if (chars[i].equals("#"))
        {
            sentinel++;
        }
        else
        {
            node++;
        }
        if (sentinel - node < 1)
        {
            return false;
        }
    }
    return sentinel - node == 1;
}
}