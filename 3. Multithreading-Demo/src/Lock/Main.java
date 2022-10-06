package Lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.*;

public class Main {
    public static void main(String[] args) {
        CounterLock counterLock = new CounterLock();

        counterLock.increment();
        System.out.println(counterLock.getCount());


        Map<String, String> personNames = new HashMap<>();

        //Write
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Lock writeLock = lock.writeLock();
        try {
            writeLock.lock();
            personNames.putIfAbsent("Galin", "Manov");
        } finally {
            writeLock.unlock();
        }


        //Read
        String personStartWithName = "Galin";

        Lock readLock = lock.readLock();
        try {
            readLock.lock();
            System.out.println(personNames.get(personStartWithName));
        } finally {
            readLock.unlock();
        }


        //StampedLock
        StampedLock lockStamp = new StampedLock();

        long stamp = lockStamp.writeLock();
        try {
            personNames.putIfAbsent("Kaloyan", "Manov");
        } finally {
            lockStamp.unlockWrite(stamp);
        }

        long stamp2 = lockStamp.readLock();
        try {
            System.out.println(personNames.get("Kaloyan"));
        }finally {
            lockStamp.unlockRead(stamp2);
        }


        //Conditions
        ReentrantLock lockCon = new ReentrantLock();
        Condition stackEmptyCondition = lockCon.newCondition();
    }
}
