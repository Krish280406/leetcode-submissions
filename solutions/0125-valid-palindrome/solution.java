class Solution {
    public boolean isPalindrome(String s) {
        
s = s.toLowerCase().replaceAll("[^a-z0-9]", "");


char[] arr = s.toCharArray();
int n = arr.length ;
int left = 0 , right = n -1 ;
while (left < right) {
 if (arr [left] == arr [right]){
      left++;
    right--;
}
else{
return false ;}
}
return true ;
}
}
