package com.vliux.util;

import java.util.ArrayList;
import java.util.List;

public class Trie<T> {
    private List<Trie> children;
    private T data;

    public Trie(T data) {
        this.children = new ArrayList<>();
        this.data = data;
    }

    public List<Trie> getChildren() {
        return children;
    }

    public void addChild(Trie c){
        children.add(c);
    }

    public T getData() {
        return data;
    }
}
