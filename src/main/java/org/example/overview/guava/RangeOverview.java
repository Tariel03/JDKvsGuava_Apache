package org.example.overview.guava;

import com.google.common.collect.Range;
/*
Range basiert auf Menge in Mathematik, Range kann öffenen, geschlossen und mixed sein. z.B. [1,10], (1,19];
 */
public class RangeOverview {
    public static void main(String[] args) {
        closedRangeView();
        openRangeView();
        openClosedRangeView();
        closedOpenRangeView();
        upToView();
        fromView();
        checkIntersection();
        checkGap();

    }

    //Hier wird das öffene Range erzeugt, das enthält alle N Elemente from 1 bis zu 1000000
    public static void closedRangeView(){
        Range<Integer> closedRange = Range.closed(1,1000000);
        System.out.println(closedRange.contains(1));

    }
    //Hier wird das öffene Range erzeugt, das enthält alle N Elemente from 1 bis zu 1000000, aber das enthält die erste and letzte Elemente nicht!
    public static void openRangeView(){
        Range<Integer> openRange = Range.open(1,1000000);
        System.out.println(openRange.contains(1));
    }
    //Diese Range bekommt man alle N Elemente from 1 bis zu 1000000, aber 1 fehlt.
    public static void openClosedRangeView(){
        Range<Integer> openClosed = Range.openClosed(1,100000000);
        System.out.println();
        System.out.println(openClosed.contains(1));
        System.out.println(openClosed.contains(100000000));

    }
    //Diese Range bekommt man alle N Elemente from 1 bis zu 1000000, aber 1000000 fehlt.
    public static void closedOpenRangeView(){
        Range<Integer> openClosed = Range.closedOpen(1,100000000);
        System.out.println();
        System.out.println(openClosed.contains(1));
        System.out.println(openClosed.contains(100000000));

    }
    //Hier kriegt man, alle Elemente from -∞ bis zu 100
    public static void upToView(){
        Range<Integer> from = Range.atMost(100);
        System.out.println();
        System.out.println(from.contains(101));
        System.out.println(from.contains(-100000000));

    }
    //Hier kriegt man, alle Elemente from 100 bis zu ∞
    public static void fromView(){
        Range<Integer> from = Range.atLeast(100);
        System.out.println();
        System.out.println(from.contains(101));
        System.out.println(from.contains(100000000));

    }
    //Das ist ein Method, man benutzt zu bestimmen ob A and B == C, wo |C| >= 0
    public static void checkIntersection(){
        Range<Integer> from = Range.atLeast(10);
        Range<Integer> closedRange = Range.closed(1,101);
        System.out.println(from.intersection(closedRange));

    }
    //Das ist ein Method, man benutzt zu bekommen, eine Distanz zwischen zwei Mengen, z.B. A = [1,10], B = [15,27]. Das C ist Distanz zwischen A und B, → C = [11,12,13,14]
    public static void checkGap(){
        Range<Integer> range1 = Range.closed(100, 200);
        Range<Integer>range2 = Range.closed(300, 400);
        System.out.println(range2.gap(range1));
     }









}
