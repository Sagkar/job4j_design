package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ForwardLinkedTest {

    private ForwardLinked<Integer> linked;

    @Before
    public void init() {
        linked = new ForwardLinked<>();
    }

    @Test
    public void whenSize0ThenReturnFalse() {
        assertFalse(linked.revert());
    }

    @Test
    public void whenSize1ThenReturnFalse() {
        linked.add(1);
        assertFalse(linked.revert());
    }

    @Test
    public void whenAddAndRevertTrue() {
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        assertThat(linked, is(contains(1, 2, 3, 4)));
        assertTrue(linked.revert());
        assertThat(linked, is(contains(4, 3, 2, 1)));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        assertThat(linked.deleteFirst(), is(1));
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }
}