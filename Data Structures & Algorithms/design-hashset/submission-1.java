class MyHashSet {
    int ARRAY_SIZE = 100;
    List<List<Integer>> bucket;
    
    public MyHashSet() {
        bucket = new ArrayList<>(ARRAY_SIZE);
        for(int i =0; i<= ARRAY_SIZE; i++){
            bucket.add(null);
        }
    }
    
    public void add(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> list = bucket.get(index);
        if(list == null){
            List<Integer> newList = new ArrayList<>();
            newList.add(key);
            bucket.set(index,newList);
        }else{
            if(!list.contains(key)){
                list.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> list = bucket.get(index);
        if(list != null){
            list.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> list = bucket.get(index);
        return list != null && list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */