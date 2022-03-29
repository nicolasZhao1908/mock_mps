package org.mps.mock.exercises;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MockingExamplesTest {

    private class Buffer {
        List<Box> boxes;
        int totalSize;

        Buffer(){
            boxes = new ArrayList<>();
            totalSize = 0;
        }
        void insertBox(Box box){
            boxes.add(box);
            totalSize++;
        }
        void removeBox(Box box){
            boxes.remove(box);
            totalSize--;
        }
        int getTotalSize(){
            return totalSize;
        }
        Enumeration<Box> getBoxes(){
            return java.util.Collections.enumeration(boxes);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Buffer buffer = (Buffer) o;

            if (totalSize != buffer.totalSize) return false;
            return boxes != null ? boxes.equals(buffer.boxes) : buffer.boxes == null;
        }

        @Override
        public int hashCode() {
            int result = boxes != null ? boxes.hashCode() : 0;
            result = 31 * result + totalSize;
            return result;
        }
    }

    private class Item {
        int content;

        Item(int content) {
            content = this.content;
        }

        int getContent() {
            return content;
        }

        void setContent(int content) {
            this.content = content;
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
    }

    private class Box {
        List<Item> items;
        int totalSize;
        Box(){
            items = new ArrayList<>();
        }
        void insertItem(Item item){
            items.add(item);
            totalSize++;
        }
        void removeItem(Item item){
            items.remove(item);
            totalSize--;
        }
        int getTotalSize(){
            return totalSize;
        }
        Enumeration<Item> getItems(){
            return java.util.Collections.enumeration(items);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Box box = (Box) o;

            if (totalSize != box.totalSize) return false;
            return items != null ? items.equals(box.items) : box.items == null;
        }

        @Override
        public int hashCode() {
            int result = items != null ? items.hashCode() : 0;
            result = 31 * result + totalSize;
            return result;
        }
    }

    @Test
    public void test() {
        Buffer example = Mockito.mock(Buffer.class);

        assertNotNull(example);
    }
}
