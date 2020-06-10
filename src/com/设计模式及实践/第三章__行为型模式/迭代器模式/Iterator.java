package com.设计模式及实践.第三章__行为型模式.迭代器模式;

class main{
    public static void main(String[] args) {
        String arr[] = {"a","b","c","d"};
        StringArray stringArray = new StringArray(arr);
        Iterator it =stringArray.createIterator();


        while (it.hashNext()
             ) {
            System.out.println(it.next());
        }
    }
}

public interface Iterator {
    public Object next();
    public boolean hashNext();

}

interface Aggregate{
 public  Iterator createIterator();
}

class           StringArray implements  Aggregate{
    private String[] values;

    public StringArray(String[] values){
        this.values =values;
    }

    @Override
    public Iterator createIterator() {
        return  new StringArrayIterator();
    }
    private class  StringArrayIterator implements Iterator{

        private int position;

        @Override
        public Object next() {
            if (this.hashNext()){
                return values[position++];
            }else{
                return null;
            }
         
        }

        @Override
        public boolean hashNext() {
            return (position< values.length);
        }
    }
}