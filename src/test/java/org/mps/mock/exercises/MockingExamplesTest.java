package org.mps.mock.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

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

        int getContent() {
            return content;
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

    }
    
}
