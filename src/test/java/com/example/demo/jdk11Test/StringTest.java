package com.example.demo.jdk11Test;

import com.example.demo.proxy2.JDKProxy.ProxyO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author sunxian
 * @version 2022-08-24 9:43
 */
public class StringTest {

   public static void main(String[] args) {
      var s = "       sasws ssd ww2  sdw das                  ";
      List<String> collect = s.lines().map(String::strip).collect(Collectors.toList());
      for (int c = 0; c <collect.size() ; c++) {
         System.out.println(collect.get(c));
      }
      //嵌套访问控制(Nest Based Access Control)
      assertThat(StringTest.class.isNestmateOf(hello.class)).isTrue();
      Class<?>[] nestMembers = StringTest.class.getNestMembers();
//      for (Class<?> nestMember : nestMembers) {
//         System.out.println(nestMember.getName());
//      }

      for (Class<?> nestMember : nestMembers) {
         System.out.println(nestMember.getNestHost());
      }


   }

   class hello{

   }

}
