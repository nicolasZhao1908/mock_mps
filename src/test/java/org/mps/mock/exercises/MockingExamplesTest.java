package org.mps.mock.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MockingExamplesTest {
    /**
     * Components
     * Una box puede tener varios components.
     * Una box puede insertar o quitar components.
     * Los boxes insertados o quitados pueden no tener boxes o items.
     * Se puede obtener el valor del item o modificarlo.
     */

    private interface Component {
        void moveTo(Box destination);
        int getContent();
    }

    private class Item implements Component {
        int content;
        Box container;

        Item(int content) {
            content = this.content;
        }
        Item(int content, Box container){
            this.content = content;
            this.container = container;
            this.moveTo(this.container);
        }

        void setContent(int content) {
            this.content = content;
        }

        Box getContainer(){
            return container;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            return content == item.content;
        }

        @Override
        public int hashCode() {
            return content;
        }

        @Override
        public void moveTo(Box destination) {

        }

        @Override
        public int getContent() {
            return 0;
        }

    }

    private class Box implements Component {
        List<Component> components;

        Box() {
            components = new ArrayList<>();
        }

        int getSize() {
            return components.size();
        }

        Enumeration<Component> getComponent() {
            return java.util.Collections.enumeration(components);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Box box = (Box) o;

            return components != null ? components.equals(box.components) : box.components == null;
        }

        @Override
        public int hashCode() {
            int result = components != null ? components.hashCode() : 0;
            return result;
        }

        @Override
        public void moveTo(Box destination) {

        }

        @Override
        public int getContent() {
            return 0;
        }

    }

    @Test
    public void mockingExample() {
        Box box = Mockito.mock(Box.class);
        Item item = new Item(1,box);

        assertEquals(box,item.getContainer());
    }

    @Test
    public void stubbingExample() {
        Component component = Mockito.mock(Component.class);
        Box box = Mockito.mock(Box.class);
        component.moveTo(box);
        Mockito.when(box.getSize()).thenReturn(1);

        assertEquals(1,box.getSize());
    }

    @Test
    public void spyExample(){
        Box box = new Box();
        Box boxSpy = Mockito.spy(box);
        Mockito.when(boxSpy.getSize()).thenReturn(1);

        assertEquals(1, boxSpy.getSize());
    }

    @Test
    public void fakeExample(){
        ComponentFake componentFake = new ComponentFake();
        assertEquals(5,componentFake.getContent());
    }

    private class ComponentFake implements Component{

        @Override
        public void moveTo(Box destination) {
            System.out.println("Moved to destination");
        }

        @Override
        public int getContent() {
            return 5;
        }
    }

    
}
