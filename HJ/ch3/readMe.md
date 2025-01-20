## Chapter Program Control Statement

### The Switch Statement
For versions of Java prior to JDK 7, the expression controlling the switch must be of
type byte, short, int, char, or an enumeration. (Enumerations are described in Chapter 12.)

Beginning with JDK 7, expression can also be of type String. This means that modern versions
of Java can use a string to control a switch.


The condition is a Boolean expression
that determines whether or not the loop will repeat.

The for loop will continue to
execute as long as the condition tests true.

## Some Variations on the for Loop
```Java
public class Comma {
   public static void main(String[] args) {
      int i, j;

      for(i = 0, j = 10; i < j; i++, j--) {
         System.out.println("i and j : " + i + " " + j);
      }
   }
}
```

```java
public class ForTest {
   public static void main(String[] args) throws java.io.IOException {
      int i;
      System.out.println("Press S to stop.");
      
      for(i = 0; (char)System.in.read() != 'S'; i++) {
         System.out.println("pass #" + i);
      }
   }
}
```

## Declaring Loop Control Variables Inside the for Loop
```java
public class ForVar {
   public static void main(String[] args) {
      int sum = 0;
      int fact = 1;

      for(int i = 1; i <= 5; i++) {
         sum += i;
         fact *= i;
      }

      System.out.println(sum);
      System.out.println(fact);
   }
}
```

85p