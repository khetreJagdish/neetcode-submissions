class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for(int i = 0; i<strs.length; i++){
            
            if(visited[i]){
                continue;
            }

            List<String> groups = new ArrayList<>();
            groups.add(strs[i]);
            visited[i] = true;

            for(int j = i+1; j<strs.length; j++){

                if(!visited[j] && isAnagram(strs[i], strs[j])){
                    groups.add(strs[j]);
                    visited[j] = true;
                }
            }
        result.add(groups);
        }
        return result;
    }

    public boolean isAnagram(String str1 , String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1,chars2);
    }
}
