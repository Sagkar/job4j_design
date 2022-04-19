package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddRoleThenFindRoleOne() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "RoleOne"));
        Role rsl = roleStore.findById("1");
        assertThat(rsl.getRole(), is("RoleOne"));
    }

    @Test
    public void whenAddRoleAndReplaceIt() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "RoleFirst"));
        roleStore.replace("1", new Role("1", "RoleSecond"));
        Role rsl = roleStore.findById("1");
        assertThat(rsl.getRole(), is("RoleSecond"));
    }

    @Test
    public void whenDeleteRole() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "RoleToDelete"));
        assertTrue(roleStore.delete("1"));
    }
}