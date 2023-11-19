package org.frank.java.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    @Test
    public void RemoveAllTest(){
        List<Character> characters = new ArrayList<>();
        characters.add('.');
        characters.add('8');
        characters.add('6');
        characters.add('4');
        characters.add('9');
        System.out.println(characters);
        characters.removeAll(characters);
        System.out.println(characters);
    }
}
