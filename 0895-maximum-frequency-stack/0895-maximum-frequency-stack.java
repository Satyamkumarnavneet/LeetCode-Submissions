class FreqStack {
    int maxfreq;
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> mp = new HashMap<>();

    public void push(int val) {
        int curr = freq.getOrDefault(val,0) + 1;
        freq.put(val,curr);
        maxfreq = Math.max(maxfreq,curr);
        if(!mp.containsKey(curr)){
            mp.put(curr,new Stack<Integer>());
        }
        mp.get(curr).add(val);
    }

    public int pop() {
        int val = mp.get(maxfreq).pop();
        freq.put(val,maxfreq-1);
        if(mp.get(maxfreq).size()==0){
            maxfreq--;
        }
        return val;
    }
}
