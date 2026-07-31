class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=capital.length;
        int [][] combined=new int[n][2];
        
        for(int i=0;i<n;i++){
            combined[i][0]=capital[i];
            combined[i][1]=profits[i];
        }
        Arrays.sort(combined, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        while(k>0){
            while(i<n&&combined[i][0]<=w){
                pq.add(combined[i][1]);
                i++;
            }
            if(pq.isEmpty()) break;
            w+=pq.poll();
            k--;
        }
        return w;
    }
}
