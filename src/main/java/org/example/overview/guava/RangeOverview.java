package org.example.overview.guava;

import com.google.common.collect.Range;

public class RangeOverview {
    public static void main(String[] args) {
        closedRangeView();
        openRangeView();
        openClosedRangeView();
        closedOpenRangeView();
        upToView();
        fromView();
        checkIntersection();

    }


    public static void closedRangeView(){
        Range<Integer> closedRange = Range.closed(1,1000000);
        System.out.println(closedRange.contains(1));

    }
    public static void openRangeView(){
        Range<Integer> openRange = Range.open(1,1000000);
        System.out.println(openRange.contains(1));
    }
    public static void openClosedRangeView(){
        Range<Integer> openClosed = Range.openClosed(1,100000000);
        System.out.println();
        System.out.println(openClosed.contains(1));
        System.out.println(openClosed.contains(100000000));

    }
    public static void closedOpenRangeView(){
        Range<Integer> openClosed = Range.closedOpen(1,100000000);
        System.out.println();
        System.out.println(openClosed.contains(1));
        System.out.println(openClosed.contains(100000000));

    }

    public static void upToView(){
        Range<Integer> from = Range.atMost(100);
        System.out.println();
        System.out.println(from.contains(101));
        System.out.println(from.contains(-100000000));

    }

    public static void fromView(){
        Range<Integer> from = Range.atLeast(100);
        System.out.println();
        System.out.println(from.contains(101));
        System.out.println(from.contains(100000000));

    }

    public static void checkIntersection(){
        Range<Integer> from = Range.atLeast(10);
        Range<Integer> closedRange = Range.closed(1,101);
        System.out.println(from.intersection(closedRange));

    }






}
