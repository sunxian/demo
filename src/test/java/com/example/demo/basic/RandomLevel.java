package com.example.demo.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author sunxian
 * @version 2022-08-13 16:06
 */
@Slf4j
public class RandomLevel {
   // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
//        1/2 的概率返回 1
//        1/4 的概率返回 2
//        1/8 的概率返回 3 以此类推
   float SKIPLIST_P=0.25f;
   @Test
   public void randomLevel() {
      int level = 1;
      // 当 level < MAX_LEVEL，且随机数小于设定的晋升概率时，level + 1
      while (Math.random() < SKIPLIST_P && level < 5)
         level += 1;

      log.info("level {}",level);

   }
}
