package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashMap<K, V> implements Iterable<V> {

    private static final int SIZE_OF_BUCKETS_ARRAY = 16;
    private Bucket[] buckets;
    private Bucket lastFoundBucket;

    public HashMap() {
        this.buckets = new Bucket[SIZE_OF_BUCKETS_ARRAY];
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        Bucket curBucket = getBucket(key);
        if (curBucket == null) {
            result = true;
            curBucket = new Bucket(key);
            if (lastFoundBucket == null) {
                buckets[hash(getHashCode(key))] = curBucket;
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
            if (curBucket.equals(lastFoundBucket)) {
                buckets[hash(getHashCode(key))] = curBucket.next;
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
        return Math.abs(curHash % SIZE_OF_BUCKETS_ARRAY);
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

        Bucket curBucket = buckets[hash(curHash)];
        lastFoundBucket = curBucket;
        while (curBucket != null)  {
            if (curBucket.hashCode == curHash && curBucket.key.equals(key)) {
                break;
            }
            lastFoundBucket = curBucket;
            curBucket = curBucket.next;
        }
        return curBucket;
    }

    @Override
    public Iterator<V> iterator() {

        return new Iterator<>() {

            int currentIteratorIndex = 0;
            Bucket curBucketInList = null;

            private void findNextBucket() {
                while (currentIteratorIndex < SIZE_OF_BUCKETS_ARRAY) {
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
                if (currentIteratorIndex == 0 && curBucketInList == null) {
                    findNextBucket();
                }
                return curBucketInList != null;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                V result = (V) curBucketInList.value;
                findNextBucket();
                return result;
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
