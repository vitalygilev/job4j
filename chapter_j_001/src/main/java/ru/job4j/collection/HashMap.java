package ru.job4j.collection;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashMap<K, V> implements Iterable<V> {

    private static final int SIZE_OF_BUCKETS_ARRAY = 16;
    private static final float LOAD_FACTOR = (float) 0.75;
    private Bucket[] buckets;
    private Bucket lastFoundBucket;
    private int lastBucketIndex;
    private int size = SIZE_OF_BUCKETS_ARRAY;
    private int currentBucketElementsCounter = 0;
    private long modCount = 0;

    public HashMap() {
        this.buckets = new Bucket[SIZE_OF_BUCKETS_ARRAY];
    }

    private void grow() {
        size = size + size >> 1;
        buckets = Arrays.copyOf(buckets, size);
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        Bucket curBucket = getBucket(key);
        if (curBucket == null) {
            result = true;
            modCount++;
            curBucket = new Bucket(key);
            if (lastFoundBucket == null) {
                buckets[hash(getHashCode(key))] = curBucket;
                currentBucketElementsCounter++;
                if ((double) currentBucketElementsCounter / size >= LOAD_FACTOR) {
                    grow();
                }
            } else {
                lastFoundBucket.next = curBucket;
            }
        }
        curBucket.value = value;
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        Bucket curBucket = getBucket(key);
        if (curBucket != null) {
            result = true;
            modCount++;
            if (lastBucketIndex != -1) {
                buckets[lastBucketIndex] = curBucket.next;
            } else {
                lastFoundBucket.next = curBucket.next;
            }
        }
        return result;
    }

    public V get(K key) {
        Object result = getBucket(key);
        if (result != null) {
            result = ((Bucket) result).value;
        }
        return (V) result;
    }

    private int hash(int curHash) {
        return Math.abs(curHash % size);
    }

    private int getHashCode(K key) {
        int result = 0;
        if (key != null) {
            result = key.hashCode();
        }
        return result;
    }

    private Bucket getBucket(K key) {
        int curHash = getHashCode(key);

        lastBucketIndex = hash(curHash);
        Bucket curBucket = buckets[lastBucketIndex];
        lastFoundBucket = curBucket;
        while (curBucket != null)  {
            if (curBucket.hashCode == curHash && curBucket.key.equals(key)) {
                break;
            }
            lastBucketIndex = -1;
            lastFoundBucket = curBucket;
            curBucket = curBucket.next;
        }
        return curBucket;
    }

    @Override
    public Iterator<V> iterator() {

        return new Iterator<>() {

            int currentIteratorIndex = 0;
            Bucket curBucketInList;
            boolean needFindNext = true;
            long expectedModCount = modCount;

            private void findNextBucket() {
                while (currentIteratorIndex < size) {
                    if (curBucketInList == null) {
                        if (buckets[currentIteratorIndex] != null) {
                            curBucketInList = buckets[currentIteratorIndex];
                            break;
                        } else {
                            currentIteratorIndex++;
                        }
                    } else {
                        if (curBucketInList.next != null) {
                            curBucketInList = curBucketInList.next;
                            break;
                        } else {
                            curBucketInList = null;
                            currentIteratorIndex++;
                        }
                    }
                }
            }

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (needFindNext) {
                    findNextBucket();
                    needFindNext = false;
                }
                return curBucketInList != null;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                needFindNext = true;
                return (V) curBucketInList.value;
            }
        };
    }

    private static class Bucket<K, V> {
        int hashCode;
        K key;
        V value;
        Bucket<K, V> next;

        private int getHashCode(K key) {
            int result = 0;
            if (key != null) {
                result = key.hashCode();
            }
            return result;
        }
        public Bucket(K key) {
            this.hashCode = getHashCode(key);
            this.key = key;
        }
    }

}
