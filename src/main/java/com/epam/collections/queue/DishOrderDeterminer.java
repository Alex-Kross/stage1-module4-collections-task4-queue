package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        Queue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            queue.add(i);
        }
        int fullSizeQueue = queue.size();
        int sizeNewQueue = fullSizeQueue;
        int index = 1;
        for (int i = 0; i < fullSizeQueue; i++) {
            Queue<Integer> queue2 = new PriorityQueue<>();
            for (int j = 1; j <= sizeNewQueue; j++) {
                if (index % everyDishNumberToEat == 0) {
                    list.add(queue.remove());
                    index = 1;
                } else {
                    queue2.add(queue.remove());
                    index++;
                }
            }
            sizeNewQueue = queue2.size();
            queue.clear();
            queue.addAll(queue2);
        }
        return list;
    }
}
