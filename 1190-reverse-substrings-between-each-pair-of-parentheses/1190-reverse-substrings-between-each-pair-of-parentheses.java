class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                String temp ="";
                while(st.peek()!='(')temp+=st.pop();
                st.pop();
                for(int j=0;j<temp.length();j++)st.push(temp.charAt(j));
            }
            else st.push(ch);
        }
        String result="";
        while(!st.isEmpty()) result=st.pop()+result;
        return result;
    }
}