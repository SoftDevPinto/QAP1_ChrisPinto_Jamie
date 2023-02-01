package com.keyin.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTime {
    public static void main(String[] args) {
        Time t1 = new Time(21, 10, 15);
        Time t2 = new Time(10, 20, 25);

        t1.nextSecond();
        t2.previousSecond();

        System.out.println("t1: " + t1.toString());
        System.out.println("t2: " + t2.toString());
    }


    // This method sets the time to "21:10:15" and calls the nextSecond method on the t1, then the assertEquals method checks the result of t1.toString
    // to see if it is equal to "21:10:16" and if it does that means the nextSecond() method is working and prints out "testNextSecond passed!"
    @Test
    public void testNextSecond() {
        Time t1 = new Time(21, 10, 15);
        t1.nextSecond();
        assertEquals("21:10:16", t1.toString());
        System.out.println("testNextSecond passed!");
    }


    // This method sets the time to "10:20:25" and calls the previousSecond method on the t2, then the assertEquals method checks the result of t2.toString()
    // to see if it is equal to "10:20:24" and if it does that means previousSecond() method is working and prints out "testPreviousSecond passed!"
    @Test
    public void testPreviousSecond() {
        Time t2 = new Time(10, 20, 25);
        t2.previousSecond();
        assertEquals("10:20:24", t2.toString());
        System.out.println("testPreviousSecond passed!");
    }

    // This method sets the time to "23:59:59" and calls the nextSecond method on the t3, then the assertEquals method checks the result of t3.toString()
    // to see if it is equal to "00:00:00" and if it does that means the nextSecond method worked and prints out that is has passed.
    // The Timer wrapped around and reset to 00:00:00
    @Test
    public void testNextSecondWithWrapAround() {
        Time t3 = new Time(23, 59, 59);
        t3.nextSecond();
        assertEquals("00:00:00", t3.toString());
        System.out.println("testNextSecondWithWrapAround has passed!");
        System.out.println(t3);
    }

    // This method is the same as the previous one, but it goes back from "00:00:00" and makes it "23:59:59"
    // and if it returns the wrap around time it prints "testPreviousSecondWithWrapAround has passed!"
    @Test
    public void testPreviousSecondWithWrapAround() {
        Time t4 = new Time(0, 0, 0);
        t4.previousSecond();
        assertEquals("23:59:59", t4.toString());
        System.out.println("testPreviousSecondWithWrapAround has passed!");
        System.out.println(t4);
    }

    // This method tests the nextMinute() method by setting the time to "21:10:15",
    // calling the nextMinute method on t5, then checking the result of t5.toString()
    // to see if it's equal to "21:11:15". If it is, then the nextMinute method is working, and
    // it prints "testNextMinute passed!"
    @Test
    public void testNextMinute() {
        // Creates a new Time object with the time set to "21:10:15"
        Time t5 = new Time(21, 10, 15);
        // Calls the nextMinute method on t5
        t5.nextMinute();
        // Checks the result of t5.toString to see if it's equal to "21:11:15"
        assertEquals("21:11:15", t5.toString());
        // If the assertEquals passes, it means the nextMinute method is working and prints "testNextMinute passed!"
        System.out.println("testNextMinute passed!");
    }

    @Test
    public void testPreviousMinute() {
        Time t6 = new Time(21, 10, 15); // Creates a new Time object with the time set to "21:10:15"
        t6.previousMinute(); // Calls the previousMinute method on t6
        assertEquals("21:09:15", t6.toString()); // Checks the result of t6.toString to see if it's equal to "21:09:15"
        System.out.println("testPreviousMinute passed!"); // If the assertEquals passes, it means the previousMinute method is working and prints "testPreviousMinute passed!"
        System.out.println(t6);
    }

    @Test
    public void testNextMinuteWithWrapAround() {
        Time t7 = new Time(21, 59, 15); // Creates a new Time object with the time set to "21:59:15"
        t7.nextMinute(); // Calls the nextMinute method on t7
        assertEquals("22:00:15", t7.toString()); // Checks the result of t7.toString to see if it's equal to "22:00:15"
        System.out.println("testNextMinuteWithWrapAround passed!"); // If the assertEquals passes, it means the nextMinute method is working and prints "testNextMinuteWithWrapAround passed!"
        System.out.println(t7);
    }

    @Test
    public void testPreviousMinuteWithWrapAround() {
        Time t8 = new Time(21, 0, 15); // Creates a new Time object with the time set to "21:00:15"
        t8.previousMinute(); // Calls the previousMinute method on t8
        assertEquals("20:59:15", t8.toString()); // Checks the result of t8.toString to see if it's equal to "20:59:15"
        System.out.println("testPreviousMinuteWithWrapAround passed!"); // If the assertEquals passes, it means the previousMinute method is working and prints "testPreviousMinuteWithWrapAround passed!"
        System.out.println(t8);
    }

    @Test
    public void testNextHour() {
        Time t9 = new Time(21, 10, 15); // Creates a new Time object with the time set to "21:10:15"
        t9.nextHour(); // Calls the nextHour method on t9
        assertEquals("22:10:15", t9.toString()); // Checks the result of t9.toString to see if it's equal to "22:10:15"
        System.out.println("testNextHour passed!"); // If the assertEquals passes, it means the nextHour method is working and prints "testNextHour passed!"
        System.out.println(t9);
    }

    @Test
    public void testPreviousHour() {
        Time t10 = new Time(21, 10, 15); // Creates a new Time object with the time set to "21:10:15"
        t10.previousHour(); // Calls the previousHour method on t10
        assertEquals("20:10:15", t10.toString()); // Checks the result of t10.toString to see if it's equal to "20:10:15"
        System.out.println("testPreviousHour passed!"); // If the assertEquals passes, it means the previousHour method is working and prints "testPreviousHour passed!"
        System.out.println(t10);
    }


    @Test
    public void testNextHourWithWrapAround() {
        Time t11 = new Time(23, 10, 15); // Creates a new Time object with the time set to "23:10:15"
        t11.nextHour(); // Calls the nextHour method on t11
        assertEquals("00:10:15", t11.toString()); // Checks the result of t11.toString to see if it's equal to "00:10:15"
        System.out.println("testNextHourWithWrapAround passed!"); // If the assertEquals passes, it means the nextHour method is working and prints "testNextHourWithWrapAround passed!"
        System.out.println(t11);
    }

    @Test
    public void testPreviousHourWithWrapAround() {
        Time t12 = new Time(0, 10, 15); // Creates a new Time object with the time set to "00:10:15"
        t12.previousHour(); // Calls the previousHour method on t12
        assertEquals("23:10:15", t12.toString()); // Checks the result of t12.toString to see if it's equal to "23:10:15"
        System.out.println("testPreviousHourWithWrapAround passed!"); // If the assertEquals passes, it means the previousHour method is working and prints "testPreviousHourWithWrapAround passed!"
        System.out.println(t12);
    }

}

