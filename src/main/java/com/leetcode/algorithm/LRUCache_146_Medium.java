package com.leetcode.algorithm;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 146. LRU 缓存
 * https://leetcode.cn/problems/lru-cache/description/
 * Guava Cache google guava cache缓存基本使用讲解 https://www.jianshu.com/p/f01ac385e4e5
 */
public class LRUCache_146_Medium {

    @Test
    public void testLRUCacheV1() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // 缓存是 {1=1}
        lruCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lruCache.get(1);    // 返回 1
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lruCache.get(2);    // 返回 -1 (未找到)
        lruCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lruCache.get(1);    // 返回 -1 (未找到)
        lruCache.get(3);    // 返回 3
        lruCache.get(4);    // 返回 4
    }

    @Test
    public void testLRUCacheV3() {
        LRUCacheV3 lruCache = new LRUCacheV3(2);
        lruCache.put(1, 1); // 缓存是 {1=1}
        lruCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lruCache.get(1);    // 返回 1
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lruCache.get(2);    // 返回 -1 (未找到)
        lruCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lruCache.get(1);    // 返回 -1 (未找到)
        lruCache.get(3);    // 返回 3
        lruCache.get(4);    // 返回 4
    }



    @Test
    public void testGuavaLRUCache() {
           LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
                                                    //设置并发级别为8，并发级别是指可以同时写缓存的线程数
                                                   .concurrencyLevel(8)
                                                    //设置缓存容器的初始容量为10
                                                   .initialCapacity(10)
                                                    //设置缓存最大容量为100，超过100之后就会按照LRU最近最少使用算法来移除缓存项
                                                   .maximumSize(100)
                                                    //是否需要统计缓存情况,该操作消耗一定的性能,生产环境应该去除
                                                   .recordStats()
                                                    //设置写缓存后n秒钟过期
                                                   .expireAfterWrite(17, TimeUnit.SECONDS)
                                                   //设置读写缓存后n秒钟过期,实际很少用到,类似于expireAfterWrite
                                                   //.expireAfterAccess(17, TimeUnit.SECONDS)
                                                   //只阻塞当前数据加载线程，其他线程返回旧值
                                                   //.refreshAfterWrite(13, TimeUnit.SECONDS)
                                                   //设置缓存的移除通知
                                                   .removalListener(notification -> {
                                                       System.out.println(notification.getKey() + " " + notification.getValue() + " 被移除,原因:" + notification.getCause());
                                                   })
                                                   //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                                                   .build(new DemoCacheLoader());
            //模拟线程并发
            new Thread(() -> {
                //非线程安全的时间格式化工具
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                try {
                    for (int i = 0; i < 15; i++) {
                        String value = cache.get(1);
                        System.out.println(Thread.currentThread().getName() + " " + simpleDateFormat.format(new Date()) + " " + value);
                        TimeUnit.SECONDS.sleep(3);
                    }
                } catch (Exception ignored) {
                }
            }).start();

            new Thread(() -> {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                try {
                    for (int i = 0; i < 10; i++) {
                        String value = cache.get(1);
                        System.out.println(Thread.currentThread().getName() + " " + simpleDateFormat.format(new Date()) + " " + value);
                        TimeUnit.SECONDS.sleep(5);
                    }
                } catch (Exception ignored) {
                }
            }).start();
            //缓存状态查看
            System.out.println(cache.stats().toString());
        }

    }



/**
 * 随机缓存加载,实际使用时应实现业务的缓存加载逻辑,例如从数据库获取数据
 */
class DemoCacheLoader extends CacheLoader<Integer, String> {
    @Override
    public String load(Integer key) throws Exception {
        System.out.println(Thread.currentThread().getName() + " 加载数据开始");
        TimeUnit.SECONDS.sleep(8);
        Random random = new Random();
        System.out.println(Thread.currentThread().getName() + " 加载数据结束");
        return "value:" + random.nextInt(10000);
    }
}

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * 手写链表
 */
class LRUCacheV3 {
    /**
     * 定义双向链表
     */
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {
        }
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCacheV3(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头和伪头部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * get操作
     * 对于 get 操作，首先判断 key 是否存在：
     * 如果 key 不存在，则返回 −1；
     * 如果 key 存在，则 key 对应的节点是最近被使用的节点。
     * 通过哈希表定位到该节点在双向链表中的位置，并将其移动到双向链表的头部，最后返回该节点的值。
     */
    public int get(int key) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        //如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(dLinkedNode);
        return dLinkedNode.key;
    }

    /**
     * put操作
     * 对于 put 操作，首先判断 key 是否存在：
     * 如果 key 不存在，使用 key 和 value 创建一个新的节点，在双向链表的头部添加该节点，并将 key 和该节点添加进哈希表中。
     *  然后判断双向链表的节点数是否超出容量，如果超出容量，则删除双向链表的尾部节点，并删除哈希表中对应的项；
     * 如果 key 存在，则与 get 操作类似，先通过哈希表定位，再将对应的节点的值更新为 value，并将该节点移到双向链表的头部。
     */
    public void put(int key, int value) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            // 创建节点
            DLinkedNode node = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, node);
            // 插入到队列头
            addToHead(node);
            ++size;
            // 如果元素超过容量，需要删除队尾元素
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 更新节点
            dLinkedNode.value = value;
            // 并移动到队列头
            moveToHead(dLinkedNode);
        }
    }

    /**
     * 将当前节点移动到队头
     */
    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 队列头插入节点
     */
    public void addToHead(DLinkedNode node) {
        //DLinkedNode temp = head.next;
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除当前节点
     */
    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
    }

    /**
     * 删除队尾的节点
     * @return
     */
    private DLinkedNode removeTail(){
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    /**
     * 删除队头的节点
     * @return
     */
    private DLinkedNode removeHead(){
        DLinkedNode node = head.next;
        removeNode(node);
        return node;
    }
}