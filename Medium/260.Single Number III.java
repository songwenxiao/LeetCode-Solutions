public class Solution {
    public int[] singleNumber(int[] nums) {
      int record = 0;
      int[] result = new int[2];
      for(int num : nums){
          record ^= num;
      }
      
      record &= -record;
      
      for(int num : nums){
          if((num & record) == 0){
              result[0] ^= num;
          }else {
              result[1] ^= num;
          }
      }
      return result;
    }
    
}